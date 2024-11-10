package reino.controller;

import reino.modelo.Heroe;
import reino.modelo.Juego;

public class JuegoController {
    static Juego juego;

    public static void iniciarJuego() {
        juego = Juego.getInstancia();

    }
    public static void crearJugador(String nombre, String tipoHeroe, int ataque, int defensa, int agilidad, int punteria) {
        Heroe heroe = juego.crearHeroe(nombre, tipoHeroe, ataque, defensa, agilidad, punteria);
        System.out.println(nombre);
        System.out.println("Héroe creado a través de Juego singleton:");
        System.out.println("Nombre: " + heroe.getNombre());
        System.out.println("Clase: " + tipoHeroe);
        System.out.println("Ataque: " + heroe.getNivelAtaque());
        System.out.println("Defensa: " + heroe.getNivelDefensa());
        juego.crearJugador(heroe);

    }
}

//heroe = crear heroe()
//jugador = crearJugador(heroe)
