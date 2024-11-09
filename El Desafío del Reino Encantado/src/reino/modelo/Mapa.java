package reino.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mapa {
    private Ubicacion actual;
    private final List<Ubicacion> ubicaciones;

    private Mapa() {
        this.ubicaciones = new ArrayList<>();
        Ubicacion puebloNeutral = new Ubicacion( "Pueblo Neutral", new ArrayList<>(), null , null ,null) ;

        Dragon dragon = new Dragon("Drogon del Norte" , 15 , 20 , 120);
        Recompensa recompensa1 = new Recompensa("Aumenta el ataque un 20%" , "Fentanilo" , 0 , 0, 0 , 0.2f);
        Ubicacion montanaHelada = new Ubicacion("Montañas Heladas", new ArrayList<>() , new ArrayList<>(List.of(dragon)) , null, recompensa1);

        Espectro espectro = new Espectro("Jeffrey Epstein" , 35 , 12 , 12);
        Recompensa recompensa2 = new Recompensa("Aumenta la defensa en un 15%" , "Amuleto de Proteccion" , 0 , 0.15f, 0 , 0);
        Ubicacion bosqueSusurros = new Ubicacion("Bosque susurros", new ArrayList<>() , new ArrayList<>(List.of(espectro)) , null, recompensa2);

        Espectro enemigo1 = new Espectro("Mangieri" , 234 , 19 , 999);
        Troll enemigo2 = new Troll("Diddy P" , 35 , 121 , 999);
        Tesoro tesoro = new Tesoro("condicion VICTORIA");
        Ubicacion mansionDiddy = new Ubicacion("La fiesta blanca", new ArrayList<>() , new ArrayList<>(List.of(enemigo1 , enemigo2)) , tesoro, null);

        //Ubicacion cuevaEspectros = new Ubicacion("Cueva de espectros", new ArrayList<Ubicacion>() , new Espectro("pepe" , 5 , 2 , 3));

        puebloNeutral.agregarAdyacente(montanaHelada);

        puebloNeutral.agregarAdyacente(bosqueSusurros);
        montanaHelada.agregarAdyacente(puebloNeutral);

        bosqueSusurros.agregarAdyacente(puebloNeutral);
        bosqueSusurros.agregarAdyacente(mansionDiddy);
        this.actual = puebloNeutral;
        this.agregarUbicacion(puebloNeutral);
        this.agregarUbicacion(montanaHelada);
        this.agregarUbicacion(bosqueSusurros);
        this.agregarUbicacion(mansionDiddy);
    }

    public static Mapa iniciarMapa(){
        return new Mapa();
    }

    public void agregarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicaciones.add(nuevaUbicacion);
    }

    public Ubicacion getActual(){return this.actual;}


    public void viajar(){
        System.out.println("A donde quieres viajar?");
        this.actual.verViajes();
        Scanner myObj = new Scanner(System.in);
        try {
            int destino = myObj.nextInt();
            this.viajarAUbicacion(destino);
        } catch (Exception e) {
            throw new RuntimeException("Elija un destino valido!");
        }

    }

    private void viajarAUbicacion(int opcion) {
        Ubicacion destino = this.actual.Viajar(opcion);
        if (destino != null) {
            if (destino.getEnemigo() != null && destino.getEnemigo().getFirst().estaVivo()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("La ubicación elegida es hostil. ¿Seguro que desea viajar (Y)?: ");
                String respuesta = scanner.nextLine().trim().toUpperCase(); // Convertir a mayúscula para evitar problemas de case

                if (!"Y".equals(respuesta)) {
                    System.out.println("Decides no viajar...");
                    return;
               }

            }

            this.actual = destino;
            System.out.println("Te encuentras en " + this.actual.getNombre());
        } else {
            System.out.println("No se puede viajar a " + actual.getAdyacentes().get(opcion-1).getNombre() + " desde aqui");
        }
    }



}
