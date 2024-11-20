/*package reino.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mapa {
    private Ubicacion actual;
    private final List<Ubicacion> ubicaciones;

    private Mapa() {
        this.ubicaciones = new ArrayList<>();
        
        // 3 Ubicaciones Neutrales
        Ubicacion puebloNeutral = new Ubicacion("Pueblo Neutral", new ArrayList<>(), null, null, null);
        Ubicacion aldeaPacifica = new Ubicacion("Aldea Pacífica", new ArrayList<>(), null, null, null);
        Ubicacion campamentoValle = new Ubicacion("Campamento en el Valle", new ArrayList<>(), null, null, null);

        // 3 Ubicaciones Hostiles con enemigos
        Dragon dragon = new Dragon("Drogon del Norte", 15, 20, 120);
        Recompensa recompensa1 = new Recompensa("Aumenta el ataque un 20%", "Fentanilo", 0, 0, 0, 0.2f);
        Ubicacion montanaHelada = new Ubicacion("Montañas Heladas", new ArrayList<>(), new ArrayList<>(List.of(dragon)), null, recompensa1);

        Espectro espectro = new Espectro("Jeffrey Epstein", 35, 12, 12);
        Recompensa recompensa2 = new Recompensa("Aumenta la defensa en un 15%", "Amuleto de Protección", 0, 0.15f, 0, 0);
        Ubicacion bosqueSusurros = new Ubicacion("Bosque Susurros", new ArrayList<>(), new ArrayList<>(List.of(espectro)), null, recompensa2);

        Espectro enemigo1 = new Espectro("Mangieri", 234, 19, 999);
        Troll enemigo2 = new Troll("Diddy P", 35, 121, 999);
        Tesoro tesoro = new Tesoro("Condición VICTORIA");
        Ubicacion mansionDiddy = new Ubicacion("La Fiesta Blanca", new ArrayList<>(), new ArrayList<>(List.of(enemigo1, enemigo2)), tesoro, null);

        // Conexiones entre las ubicaciones
        puebloNeutral.agregarAdyacente(montanaHelada);
        puebloNeutral.agregarAdyacente(bosqueSusurros);

        montanaHelada.agregarAdyacente(bosqueSusurros);
        montanaHelada.agregarAdyacente(mansionDiddy);

        bosqueSusurros.agregarAdyacente(montanaHelada);
        bosqueSusurros.agregarAdyacente(mansionDiddy);

        mansionDiddy.agregarAdyacente(montanaHelada);
        mansionDiddy.agregarAdyacente(bosqueSusurros);

        aldeaPacifica.agregarAdyacente(puebloNeutral);
        aldeaPacifica.agregarAdyacente(campamentoValle);

        campamentoValle.agregarAdyacente(puebloNeutral);
        campamentoValle.agregarAdyacente(aldeaPacifica);

        
        // Asignación de la ubicación inicial
        this.actual = campamentoValle;

        // Añadir todas las ubicaciones al mapa
        this.agregarUbicacion(puebloNeutral);
        this.agregarUbicacion(aldeaPacifica);
        this.agregarUbicacion(campamentoValle);
        this.agregarUbicacion(montanaHelada);
        this.agregarUbicacion(bosqueSusurros);
        this.agregarUbicacion(mansionDiddy);
    }

    public static Mapa iniciarMapa() {
        return new Mapa();
    }

    public void agregarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicaciones.add(nuevaUbicacion);
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public Ubicacion getActual() {
        return this.actual;
    }

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
            // Si la ubicación es hostil y tiene enemigos vivos
            if (destino.getEnemigo() != null && destino.getEnemigo().get(0).estaVivo()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("La ubicación elegida es hostil. ¿Seguro que desea viajar (Y)?: ");
                String respuesta = scanner.nextLine().trim().toUpperCase(); // Convertir a mayúscula para evitar problemas de case
    
                if (!"Y".equals(respuesta)) {
                    System.out.println("Decides no viajar...");
                    return;
                }
            }
    
            // Cambiar ubicación actual al destino
            this.actual = destino;
            System.out.println("Te encuentras en " + this.actual.getNombre());
    
            // Verificar si hay un tesoro en la ubicación
            if (destino.getTesoro() != null) {
                System.out.println("¡Encontraste un tesoro! " + destino.getTesoro().getNombre());
                System.out.println("¡Has ganado el juego!");
                System.exit(0); // Finalizar el programa
            } else {
                System.out.println("No hay tesoro en esta ubicación. Regresando al mapa...");
            }
        } else {
            System.out.println("No se puede viajar a " + actual.getAdyacentes().get(opcion - 1).getNombre() + " desde aquí.");
        }
    }
    
}*/
package reino.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mapa {
    private Ubicacion actual;
    private final List<Ubicacion> ubicaciones;

    private Mapa() {
        this.ubicaciones = new ArrayList<>();

        // 3 Ubicaciones Neutrales
        Ubicacion puebloNeutral = new Ubicacion("Pueblo Neutral", new ArrayList<>(), null, null, null);
        Ubicacion aldeaPacifica = new Ubicacion("Aldea Pacífica", new ArrayList<>(), null, null, null);
        Ubicacion campamentoValle = new Ubicacion("Campamento en el Valle", new ArrayList<>(), null, null, null);

        // 3 Ubicaciones Hostiles con enemigos
        Dragon dragon = new Dragon("Drogon del Norte", 15, 20, 120);
        Recompensa recompensa1 = new Recompensa("Aumenta el ataque un 20%", "Fentanilo", 0, 0, 0, 0.2f);
        Ubicacion montanaHelada = new Ubicacion("Montañas Heladas", new ArrayList<>(), new ArrayList<>(List.of(dragon)), null, recompensa1);

        Espectro espectro = new Espectro("Jeffrey Epstein", 35, 12, 12);
        Recompensa recompensa2 = new Recompensa("Aumenta la defensa en un 15%", "Amuleto de Protección", 0, 0.15f, 0, 0);
        Ubicacion bosqueSusurros = new Ubicacion("Bosque Susurros", new ArrayList<>(), new ArrayList<>(List.of(espectro)), null, recompensa2);

        Espectro enemigo1 = new Espectro("Mangieri", 234, 19, 999);
        Troll enemigo2 = new Troll("Diddy P", 35, 121, 999);
        Tesoro tesoro = new Tesoro("Condición VICTORIA");
        Ubicacion mansionDiddy = new Ubicacion("La Fiesta Blanca", new ArrayList<>(), new ArrayList<>(List.of(enemigo1, enemigo2)), tesoro, null);

        // Conexiones entre las ubicaciones
        puebloNeutral.agregarAdyacente(montanaHelada);
        puebloNeutral.agregarAdyacente(bosqueSusurros);

        montanaHelada.agregarAdyacente(aldeaPacifica);
        montanaHelada.agregarAdyacente(mansionDiddy);

        bosqueSusurros.agregarAdyacente(montanaHelada);
        bosqueSusurros.agregarAdyacente(campamentoValle);

        mansionDiddy.agregarAdyacente(montanaHelada);
        mansionDiddy.agregarAdyacente(bosqueSusurros);

        aldeaPacifica.agregarAdyacente(puebloNeutral);
        aldeaPacifica.agregarAdyacente(campamentoValle);

        campamentoValle.agregarAdyacente(puebloNeutral);
        campamentoValle.agregarAdyacente(aldeaPacifica);

        // Asignación de la ubicación inicial
        this.actual = campamentoValle;

        // Añadir todas las ubicaciones al mapa
        this.agregarUbicacion(puebloNeutral);
        this.agregarUbicacion(aldeaPacifica);
        this.agregarUbicacion(campamentoValle);
        this.agregarUbicacion(montanaHelada);
        this.agregarUbicacion(bosqueSusurros);
        this.agregarUbicacion(mansionDiddy);
    }

    public static Mapa iniciarMapa() {
        return new Mapa();
    }

    public void agregarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicaciones.add(nuevaUbicacion);
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public Ubicacion getActual() {
        return this.actual;
    }

    public void viajar() {
        System.out.println("¿A dónde quieres viajar?");
        this.actual.verViajes();
        Scanner myObj = new Scanner(System.in);
        try {
            int destino = myObj.nextInt();
            this.viajarAUbicacion(destino);
        } catch (Exception e) {
            throw new RuntimeException("¡Elija un destino válido!");
        }
    }

    private void viajarAUbicacion(int opcion) {
        Ubicacion destino = this.actual.Viajar(opcion);
        
        if (destino != null) {
            if (destino.getEnemigo() != null && destino.getEnemigo().get(0).estaVivo()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("La ubicación elegida es hostil. ¿Seguro que desea viajar? (Y/N): ");
                String respuesta = scanner.nextLine().trim().toUpperCase(); // Convertir a mayúscula para evitar problemas de case

                if (!"Y".equals(respuesta)) {
                    System.out.println("Decides no viajar...");
                    return;
                }
            }

            this.actual = destino;

            if (destino.getTesoro() != null) {
                System.out.println("¡Encontraste el tesoro! ¡Ganaste el juego!");
                System.exit(0); // Terminar el juego
            } else {
                System.out.println("No hay ningún tesoro aquí. Volviendo al mapa...");
            }

            System.out.println("Te encuentras en " + this.actual.getNombre());
        } else {
            System.out.println("No se puede viajar a " + actual.getAdyacentes().get(opcion - 1).getNombre() + " desde aquí.");
        }
    }
}


