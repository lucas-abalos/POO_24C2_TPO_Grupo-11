package reino.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {
    private static Juego instanciaUnica;
    private Mapa mapa;
    private Jugador jugador;
    private Heroe heroe;

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

    public String viajar(String nombreUbicacion){
        Ubicacion ubicacionActual;

        mapa.viajarUbicacion(nombreUbicacion);

        ubicacionActual = mapa.getActual();
        String mensajeUbicacion = mapa.getActual().obtenerDescripcionCompleta();

        // Si viajo a una ubicación Hostil inicio la pelea
        if(!ubicacionActual.esPacifica()){
            try {
                List<Criatura> enemigos = mapa.getActual().getEnemigo();
                if (enemigos != null) {
                    for (Criatura enemigo : enemigos) {
                        if (enemigo.estaVivo()) {
                            Pelea pelea = new Pelea(jugador, enemigo);
                            pelea.iniciarPelea();
                        }
                    }
                    if (mapa.getActual().getRecompensa() != null) {
                        jugador.agregarRecompensa(mapa.getActual().getRecompensa());
                    }
                    mapa.getActual().vaciarEnemigos();
                    mapa.getActual().vaciarRecompensa();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if(mapa.getActual().getTesoro() != null){
            mensajeUbicacion = "GANASTE";
        }
        if(!heroe.estaVivo()){
            mensajeUbicacion = "PERDISTE";
        }
        return mensajeUbicacion;
    }

    public Map<String, Boolean> getDatosRecompensa() {
        List<Recompensa> recompensas = mapa.getRecompensas(); 
        Map<String, Boolean> listaMisiones = new HashMap<>(); 
        
        for (Recompensa recompensa : recompensas) {
            listaMisiones.put(recompensa.toString(), recompensa.getEstadoUso());
        }
        return listaMisiones;
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

    public int getCantidadExperiencia(){
        return jugador.getNivelExperiencia();
    }

    public boolean canjearRecompensas(){
        return jugador.intercambiarRecompensas();
    }

    public boolean incrementarAtaque(int ataque){
        if(!this.mapa.getActual().esNeutral()){
            return false;
        }
        return jugador.mejorarAtaqueHeroe(ataque, false);
    }

    public boolean incrementarDefensa(int defensa){
        if(!this.mapa.getActual().esNeutral()){
            return false;
        }
        return jugador.mejorarDefensaHeroe(defensa, false);
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

