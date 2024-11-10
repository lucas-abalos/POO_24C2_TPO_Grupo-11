package reino.modelo;

public class Juego {
    private static Juego instanciaUnica;
    private Mapa mapa;
    private Jugador jugador;
    private Pelea pelea;

    private Juego() {
        this.mapa = Mapa.iniciarMapa();
    }

    public static Juego getInstancia() {
        if (instanciaUnica != null) {
            return instanciaUnica ;
        }
        return instanciaUnica = new Juego();
    }



    public Heroe crearHeroe(String nombre , String tipoHeroe , int puntosAtaque , int puntosDefensa, Integer agilidad, Integer punteria) {
        switch (tipoHeroe) {
            case "Guerrero":
                return new Guerrero(nombre , puntosAtaque , puntosDefensa);
            case "Mago":
                return new Mago(nombre , puntosAtaque , puntosDefensa);
            case "Arquero":
                return new Arquero(nombre , puntosAtaque , puntosDefensa , agilidad , punteria);
                default:
                    throw new RuntimeException("Error al crear el Heroe");
        }

    }

    public void crearJugador(Heroe heroe){
        this.jugador = new Jugador(heroe);
        this.jugador.devolverHeroe().setDuenio(this.jugador);
    }

    public Jugador devolverJugador(){
        return this.jugador;
    }


}

