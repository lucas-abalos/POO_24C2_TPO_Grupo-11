package reino.main;

import reino.modelo.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Juego juego = Juego.getInstancia();
        Mapa mapa = Mapa.iniciarMapa();
        // preguntas heroe
//        Heroe heroe = new Arquero("Guerrero", 10, 2000, 5, 100, 3);
//        Jugador jugador = new Jugador(heroe);
//        heroe.setDuenio(jugador);
//        Scanner scanner = new Scanner(System.in);
//        while (jugador.devolverHeroe().estaVivo() && mapa.getActual().getTesoro() == null) {
//            try {
//
//                //ofrecer opciones
//                if (mapa.getActual().getEnemigo() == null) {
//                    menuNeutral(scanner, jugador);
//                    mapa.viajar();
//                } else {
//                    mapa.viajar(); // Pasar scanner y jugador
//                }
//                //si elige viaje, usar logica de viaje
//
//                List<Criatura> enemigos = mapa.getActual().getEnemigo();
//                if (enemigos != null) {
//                    for (Criatura enemigo : enemigos) {
//                        if (enemigo.estaVivo()) {
//                            Pelea pelea = new Pelea(jugador, enemigo);
//                            pelea.iniciarPelea();
//                            if (mapa.getActual().getRecompensa() != null) {
//                                jugador.agregarRecompensa(mapa.getActual().getRecompensa());
//                            }
//
//                        }
//                    }
//                }
//
//
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//        if(mapa.getActual().getTesoro() != null){
//        System.out.println("FELICIDADES! GANASTE");}

}

    public static void menuNeutral(Scanner scanner, Jugador jugador) {
        while (true) {
        System.out.println("Estás en una ubicación neutral. ¿Qué te gustaría hacer?");
        System.out.println("1. Mejorar ataque");
        System.out.println("2. Mejorar defensa");
        System.out.println("3. Canjear recompensas");
        System.out.println("4. Viajar");

            int opcion = scanner.nextInt();
            int cantidad;
            switch (opcion) {
                case 1:
                    System.out.println("Tienes " + jugador.getNivelExperiencia() + " puntos para gastar\nIngresa cuanto ataque quieres sumar: ");
                    cantidad = scanner.nextInt();
                    System.out.println("Mejorando personaje...");
                    jugador.mejorarAtaqueHeroe(cantidad , false); // Asumiendo que hay un método para mejorar
                    break;
                case 2:
                    System.out.println("Tienes " + jugador.getNivelExperiencia() + " puntos para gastar\nIngresa cuanto ataque quieres sumar: ");
                    cantidad = scanner.nextInt();
                    System.out.println("Mejorando personaje...");
                    jugador.mejorarDefensaHeroe(cantidad, false); // Asumiendo que hay un método para mejorar
                    break;
                case 3:
                    // Lógica para canjear recompensas
                    System.out.println("Canjeando recompensas...");
                    jugador.intercambiarRecompensas(); // Asumiendo que existe este método
                    break;
                case 4:
                    System.out.println("Eligiendo viajar...");
                    return; // Saldrá del menú y pasará a la lógica de viaje
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }



}
