package reino.controller;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.SwingUtilities;
import reino.modelo.Juego;
import reino.modelo.Ubicacion;
import reino.view.EstadoPersonajePantalla;
import reino.view.JugadorPantalla;
import reino.view.MapaPantalla;

public class JuegoController {

    public static void iniciarJuego() {
        SwingUtilities.invokeLater(() -> {
            JugadorPantalla pantalla = new JugadorPantalla();
            pantalla.setVisible(true);
        });
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
        MapaPantalla mapaPantalla = new MapaPantalla(ubicacionesAdyacentes, Juego.getInstancia().getUbicacionActual(), null); 
        mapaPantalla.setVisible(true);
    }

    public static void mostrarPantallaEstadoPersonaje(){
        var instancia = Juego.getInstancia();
        EstadoPersonajePantalla estadoPersonajePantalla = new EstadoPersonajePantalla(instancia.getVida(), instancia.getAtaque(), instancia.getDefensa()); 
    }

    public static void crearJugador(String nombre, String tipoHeroe, int ataque, int defensa, int agilidad, int punteria) {
        Juego.getInstancia().crearHeroe(nombre, tipoHeroe, ataque, defensa, agilidad, punteria);
    }
}
