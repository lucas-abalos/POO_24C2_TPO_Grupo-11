import java.util.ArrayList;
import java.util.List;

public class TestMapa {
    public static void main(String[] args) {
        Mapa mapa = iniciarMapa();
        while (true){
        mapa.viajar();
    }
    }

    public static Mapa iniciarMapa() { 
        
        Ubicacion puebloPaleta = new Ubicacion(null, "Pueblo Paleta", new ArrayList<Ubicacion>(), TipoUbicacion.CIUDAD);
        Ubicacion ciudadVerde = new Ubicacion(null, "Ciudad Verde", new ArrayList<Ubicacion>(), TipoUbicacion.CIUDAD);
        Ubicacion ciudadPlateada = new Ubicacion(null, "Ciudad Plateada", new ArrayList<Ubicacion>(), TipoUbicacion.CIUDAD);
        Ubicacion aldeaHerreros = new Ubicacion(null, "Aldea Herreros", new ArrayList<Ubicacion>(), TipoUbicacion.CIUDAD);
        puebloPaleta.agregarAdyacente(ciudadVerde);
        ciudadVerde.agregarAdyacente(ciudadPlateada);
        ciudadVerde.agregarAdyacente(puebloPaleta);
        ciudadVerde.agregarAdyacente(aldeaHerreros);
        ciudadPlateada.agregarAdyacente(ciudadVerde);
        aldeaHerreros.agregarAdyacente(ciudadPlateada);
        Mapa mapa = new Mapa(puebloPaleta , new ArrayList<Ubicacion>());
        mapa.agregarUbicacion(ciudadPlateada);
        mapa.agregarUbicacion(ciudadVerde);
        mapa.agregarUbicacion(puebloPaleta);
        mapa.agregarUbicacion(aldeaHerreros);
        return mapa;
    }
}
