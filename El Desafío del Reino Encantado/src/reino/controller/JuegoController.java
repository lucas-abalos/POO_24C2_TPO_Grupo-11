package reino.controller;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.SwingUtilities;
import reino.modelo.Juego;
import reino.modelo.Ubicacion;
import reino.view.DerrotaPantalla;
import reino.view.EstadoPersonajePantalla;
import reino.view.JugadorPantalla;
import reino.view.MapaPantalla;
import reino.view.MejoraPersonajePantalla;
import reino.view.MisionesPantalla;
import reino.view.VictoriaPantalla;

public class JuegoController {

    public static void iniciarJuego() {
        SwingUtilities.invokeLater(() -> {
            JugadorPantalla pantalla = new JugadorPantalla();
            pantalla.setVisible(true);
        });
    }

    public static String viajar(String nombreUbicacion){
        var instancia = Juego.getInstancia();
        return instancia.viajar(nombreUbicacion);
    }

    public static void mostrarPantallaVictoria(){
        VictoriaPantalla pantallaVictoria = new VictoriaPantalla();
        pantallaVictoria.setVisible(true);
    }

    public static void mostrarPantallaDerrota(){
        DerrotaPantalla pantallaDerrota = new DerrotaPantalla();
        pantallaDerrota.setVisible(true);
    }

    public static void mostrarPantallaMap(){
        Map<String, List<String>> ubicacionesAdyacentes = Juego.getInstancia().getTodasUbicaciones()
            .stream()
            .collect(Collectors.toMap(
                Ubicacion::getNombre, // Clave: nombre de la ubicación
                ubicacion -> ubicacion.getAdyacentes().stream()
                    .map(Ubicacion::getNombre) // Valor: lista de nombres de ubicaciones adyacentes
                    .collect(Collectors.toList())
            ));
        MapaPantalla mapaPantalla = new MapaPantalla(ubicacionesAdyacentes, Juego.getInstancia().getUbicacionActual()); 
        mapaPantalla.setVisible(true);
    }

    public static void mostrarPantallaEstadoPersonaje(){
        var instancia = Juego.getInstancia();
        EstadoPersonajePantalla estadoPersonajePantalla = new EstadoPersonajePantalla(instancia.getVida(), instancia.getAtaque(), instancia.getDefensa() , instancia.getAgilidad() , instancia.getPunteria()); 
    }

    public static void mostrarPantallaMisiones(){
        var instancia = Juego.getInstancia();
        MisionesPantalla misionesPantalla = new MisionesPantalla(instancia.getDatosRecompensa()); 
    }

    public static void mostrarPantallaMejoraPersonaje(){
        var instancia = Juego.getInstancia();
        MejoraPersonajePantalla mejoraPersonajePantalla = new MejoraPersonajePantalla(instancia.getCantidadExperiencia()); 
    }
    
    public static void crearJugador(String nombre, String tipoHeroe, int ataque, int defensa, int agilidad, int punteria) {
        Juego.getInstancia().crearHeroe(nombre, tipoHeroe, ataque, defensa, agilidad, punteria);
    }

    public static boolean incrementarAtaque(int ataque){
        return Juego.getInstancia().incrementarAtaque(ataque);
    }

    public static boolean incrementarDefensa(int defensa){
        return Juego.getInstancia().incrementarDefensa(defensa);
    }

    public static boolean canjearRecompensas(){
        return Juego.getInstancia().canjearRecompensas();
    }
}
