package reino.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mapa {
    private Ubicacion actual;
    private List<Ubicacion> ubicaciones;

    public Mapa() {
        this.ubicaciones = new ArrayList<>();
        Ubicacion puebloPaleta = new Ciudad( "Pueblo Paleta", new ArrayList<Ubicacion>(), "npc1") ;
        Ubicacion ciudadVerde = new Ciudad( "Ciudad Verde", new ArrayList<Ubicacion>(), "npc1");
        Ubicacion ciudadPlateada = new Ciudad("Ciudad Plateada", new ArrayList<Ubicacion>(), "npc1");
        Ubicacion cuevaEspectros = new ZonaEnemiga("Cueva de espectros", new ArrayList<Ubicacion>() , new Espectro("pepe" , 5 , 2 , 3));
        puebloPaleta.agregarAdyacente(ciudadVerde);
        ciudadVerde.agregarAdyacente(ciudadPlateada);
        ciudadVerde.agregarAdyacente(puebloPaleta);
        ciudadVerde.agregarAdyacente(cuevaEspectros);
        ciudadPlateada.agregarAdyacente(ciudadVerde);
        cuevaEspectros.agregarAdyacente(ciudadPlateada);
        this.actual = puebloPaleta;
        this.agregarUbicacion(ciudadPlateada);
        this.agregarUbicacion(ciudadVerde);
        this.agregarUbicacion(puebloPaleta);
        this.agregarUbicacion(cuevaEspectros);
    }

    public void agregarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicaciones.add(nuevaUbicacion);
    }

    public Ubicacion getActual(){return this.actual;}


    public void viajar(){
        System.out.println("A donde quieres viajar?");
        this.actual.verViajes();
        Scanner myObj = new Scanner(System.in);
        int destino = myObj.nextInt();
        this.viajarAUbicacion(destino);

    }

    private void viajarAUbicacion(int opcion) {
        Ubicacion destino = this.actual.Viajar(opcion);
        if (destino != null) {
            this.actual = destino;
            System.out.println("Te encuentras en " + this.actual.getNombre());

        } else {
            System.out.println("No se puede viajar a " + actual.adyacentes.get(opcion-1).getNombre() + " desde aqui");
        }
    }



    public List<Ubicacion> getUbicaciones() {
        return this.ubicaciones;
    }
}
