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

        Espectro enemigo1 = new Espectro("Mangieri" , 99 , 50 , 999);
        Troll enemigo2 = new Troll("Diddy P" , 99 , 50, 999);
        Tesoro tesoro = new Tesoro("condicion VICTORIA");
        Ubicacion mansionDiddy = new Ubicacion("La fiesta blanca", new ArrayList<>() , new ArrayList<>(List.of(enemigo1 , enemigo2)) , tesoro, null);

        //Ubicacion cuevaEspectros = new Ubicacion("Cueva de espectros", new ArrayList<Ubicacion>() , new Espectro("pepe" , 5 , 2 , 3));
        // Ubicación 1: Pantano Oscuro
Troll trollPantano = new Troll("Grogg el Impasible", 15, 5, 50);
Recompensa recompensaPantano = new Recompensa("Incrementa la vida un 25%", "Elixir de Vitalidad", 25, 0, 0, 0);
this.recompensas.add(recompensaPantano);
Ubicacion pantanoOscuro = new Ubicacion(
    "Pantano Oscuro",
    new ArrayList<>(),
    new ArrayList<>(List.of(trollPantano)),
    null,
    recompensaPantano
);

// Ubicación 2: Aldea de los Sirith
Espectro espectroAldea = new Espectro("Sirith el Eterno", 10, 8, 40);
Recompensa recompensaSirith = new Recompensa("Incrementa la agilidad un 10%", "Botas de Sirith", 0, 0, 10, 0);
this.recompensas.add(recompensaSirith);
Ubicacion aldeaSirith = new Ubicacion(
    "Aldea de los Sirith",
    new ArrayList<>(),
    new ArrayList<>(List.of(espectroAldea)),
    null,
    recompensaSirith
);

// Ubicación 3: Caverna de Fuego
Dragon dragonCaverna = new Dragon("Pyroclasto", 20, 10, 150);
Recompensa recompensaCaverna = new Recompensa("Incrementa el ataque un 30%", "Espada Llameante", 0, 0, 0, 0.3f);
this.recompensas.add(recompensaCaverna);
Ubicacion cavernaFuego = new Ubicacion(
    "Caverna de Fuego",
    new ArrayList<>(),
    new ArrayList<>(List.of(dragonCaverna)),
    null,
    recompensaCaverna
);

// Ubicación 4: Valle Sombrío
Espectro espectroValle = new Espectro("Sombra Errante", 8, 6, 35);
Troll trollValle = new Troll("Rugido Oscuro", 12, 7, 60);
Recompensa recompensaValle = new Recompensa("Incrementa la puntería un 20%", "Arco de las Sombras", 0, 0, 0, 0);
this.recompensas.add(recompensaValle);
Ubicacion valleSombrio = new Ubicacion(
    "Valle Sombrío",
    new ArrayList<>(),
    new ArrayList<>(List.of(espectroValle, trollValle)),
    null,
    recompensaValle
);

// Ubicación 5: Torre de los Vientos
Dragon dragonTorre = new Dragon("Tempus", 25, 15, 200);
Recompensa recompensaTorre = new Recompensa("Incrementa todos los atributos en un 5%", "Anillo del Viento", 5, 5, 3, 2);
this.recompensas.add(recompensaTorre);
Ubicacion torreVientos = new Ubicacion(
    "Torre de los Vientos",
    new ArrayList<>(),
    new ArrayList<>(List.of(dragonTorre)),
    null,
    null
);


        puebloNeutral.agregarAdyacente(montanaHelada);
        montanaHelada.agregarAdyacente(aldeaSirith);
        aldeaSirith.agregarAdyacente(montanaHelada);

        puebloNeutral.agregarAdyacente(bosqueSusurros);
        montanaHelada.agregarAdyacente(puebloNeutral);

        bosqueSusurros.agregarAdyacente(puebloNeutral);
        bosqueSusurros.agregarAdyacente(torreVientos);
        torreVientos.agregarAdyacente(valleSombrio);
        valleSombrio.agregarAdyacente(cavernaFuego);
        cavernaFuego.agregarAdyacente(pantanoOscuro);
        pantanoOscuro.agregarAdyacente(mansionDiddy);
        mansionDiddy.agregarAdyacente(aldeaSirith);  
        
        this.actual = puebloNeutral;
        this.agregarUbicacion(puebloNeutral);
        this.agregarUbicacion(montanaHelada);
        this.agregarUbicacion(bosqueSusurros);
        this.agregarUbicacion(mansionDiddy);
        this.agregarUbicacion(torreVientos);
        this.agregarUbicacion(cavernaFuego);
        this.agregarUbicacion(pantanoOscuro);
        this.agregarUbicacion(aldeaSirith);
        this.agregarUbicacion(valleSombrio);
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
