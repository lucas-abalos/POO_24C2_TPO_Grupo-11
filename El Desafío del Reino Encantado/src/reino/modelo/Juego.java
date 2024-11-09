package reino.modelo;

public class Juego {
    private static Juego instanciaUnica;
    private Mapa mapa;
    private Jugador jugador;
    private Pelea pelea;

    private Juego() {
        this.mapa = Mapa.iniciarMapa();
        this.jugador = Jugador.crearPersonaje();
    }

    public static Juego getInstancia() {
        if (instanciaUnica != null) {
            return instanciaUnica ;
        }
        return instanciaUnica = new Juego();
    }





}

