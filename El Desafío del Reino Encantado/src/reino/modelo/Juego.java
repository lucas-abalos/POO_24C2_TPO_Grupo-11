package reino.modelo;

import java.util.List;

public class Juego {
    private static Juego instanciaUnica;
    private Mapa mapa;
    private Jugador jugador;
    private Heroe heroe;
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

    public String getUbicacionActual(){
        return this.mapa.getActual().getNombre();
    }

    public int getVida(){
        return heroe.getVida(); 
    }

    public int getAtaque(){
        return heroe.getNivelAtaque(); 
    }
    public int getDefensa(){
        return heroe.getNivelDefensa(); 
    }    


    public void crearHeroe(String nombre , String tipoHeroe , int puntosAtaque , int puntosDefensa, Integer agilidad, Integer punteria) {
        Heroe heroe;
        switch (tipoHeroe) {
            case "Guerrero":
                heroe = new Guerrero(nombre , puntosAtaque , puntosDefensa);
                break;
            case "Mago":
                heroe = new  Mago(nombre , puntosAtaque , puntosDefensa);
                break;
            case "Arquero":
                heroe = new  Arquero(nombre , puntosAtaque , puntosDefensa , agilidad , punteria);
                break;
                default:
                    throw new RuntimeException("Error al crear el Heroe");
        }
        this.heroe = heroe;
        crearJugador(heroe);
        System.out.println(nombre);
        System.out.println("Héroe creado a través de Juego singleton:");
        System.out.println("Nombre: " + heroe.getNombre());
        System.out.println("Clase: " + tipoHeroe);
        System.out.println("Ataque: " + heroe.getNivelAtaque());
        System.out.println("Defensa: " + heroe.getNivelDefensa());

    }

    public void crearJugador(Heroe heroe){
        this.jugador = new Jugador(heroe);
        this.jugador.devolverHeroe().setDuenio(this.jugador);
    }

    public Jugador devolverJugador(){
        return this.jugador;
    }

    public List<Ubicacion> getTodasUbicaciones(){
        return this.mapa.getUbicaciones();
    }
}

