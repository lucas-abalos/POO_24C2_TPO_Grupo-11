package reino.modelo;

import java.util.ArrayList;
import java.util.List;


public class Mapa {
    private Ubicacion actual;
    private final List<Ubicacion> ubicaciones;
    private final List<Recompensa> recompensas;

    private Mapa() {
        this.recompensas = new ArrayList<>();
        this.ubicaciones = new ArrayList<>();
        Ubicacion puebloNeutral = new Ubicacion( "Pueblo Neutral", new ArrayList<>(), null , null ,null) ;

        Dragon dragon = new Dragon("Drogon del Norte" , 1 , 1 , 120);
        Recompensa recompensa1 = new Recompensa("Aumenta el ataque un 20%" , "Fentanilo" , 0 , 0, 0 , 0.2f);
        this.recompensas.add(recompensa1);
        Ubicacion montanaHelada = new Ubicacion("Montañas Heladas", new ArrayList<>() , new ArrayList<>(List.of(dragon)) , null, recompensa1);

        Espectro espectro = new Espectro("Jeffrey Epstein" , 2 , 2, 12);
        Recompensa recompensa2 = new Recompensa("Aumenta la defensa en un 15%" , "Amuleto de Proteccion" , 0 , 0.15f, 0 , 0);
        this.recompensas.add(recompensa2);
        Ubicacion bosqueSusurros = new Ubicacion("Bosque susurros", new ArrayList<>() , new ArrayList<>(List.of(espectro)) , null, recompensa2);

        Espectro enemigo1 = new Espectro("Mangieri" , 3 , 4 , 999);
        Troll enemigo2 = new Troll("Diddy P" , 2 , 1, 999);
        Tesoro tesoro = new Tesoro("condicion VICTORIA");
        Ubicacion mansionDiddy = new Ubicacion("La fiesta blanca", new ArrayList<>() , new ArrayList<>(List.of(enemigo1 , enemigo2)) , tesoro, null);

        //Ubicacion cuevaEspectros = new Ubicacion("Cueva de espectros", new ArrayList<Ubicacion>() , new Espectro("pepe" , 5 , 2 , 3));

        puebloNeutral.agregarAdyacente(montanaHelada);

        puebloNeutral.agregarAdyacente(bosqueSusurros);
        montanaHelada.agregarAdyacente(puebloNeutral);

        bosqueSusurros.agregarAdyacente(puebloNeutral);
        bosqueSusurros.agregarAdyacente(mansionDiddy);

        mansionDiddy.agregarAdyacente(bosqueSusurros);
        
        this.actual = puebloNeutral;
        this.agregarUbicacion(puebloNeutral);
        this.agregarUbicacion(montanaHelada);
        this.agregarUbicacion(bosqueSusurros);
        this.agregarUbicacion(mansionDiddy);
    }

    public static Mapa iniciarMapa(){
        return new Mapa();
    }

    public List<Recompensa> getRecompensas(){
        return this.recompensas;
    }
    public void agregarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicaciones.add(nuevaUbicacion);
    }

    public List<Ubicacion> getUbicaciones(){
        return ubicaciones;
    }


    public void viajarUbicacion(String nombreUbicacion){
        for (Ubicacion ubicacion : ubicaciones) {
            if (ubicacion.getNombre().equalsIgnoreCase(nombreUbicacion)) {
                // Verificar si la ubicación es adyacente a la ubicación actual
                if (actual.getAdyacentes().contains(ubicacion)) {
                    this.actual = ubicacion; // Actualizar la ubicación actual
                }
                return; // Salir del método una vez encontrada la ubicación
            }
        }
    }

    public Ubicacion getActual(){return this.actual;}
}
