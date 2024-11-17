package reino.view;

import java.awt.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class MapaPantalla extends JFrame {

    private Map<String, List<String>> ubicacionesAdyacentes;
    private String ubicacionActual;

    public MapaPantalla(Map<String, List<String>> ubicacionesAdyacentes, String ubicacionActual) {
        this.ubicacionesAdyacentes = ubicacionesAdyacentes;
        this.ubicacionActual = ubicacionActual;

        setTitle("Pantalla de Mapa");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // BorderLayout para centrar el contenido

        mostrarBotones();
    }

    private void mostrarBotones() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)); 
        panelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar los elementos en el panel

        for (String nombreUbicacion : ubicacionesAdyacentes.keySet()) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton boton = new JButton(nombreUbicacion);

            // Verificar si la ubicación es adyacente a la ubicación actual
            if (ubicacionesAdyacentes.get(ubicacionActual).contains(nombreUbicacion)) {
                boton.setEnabled(true); // Habilitar el botón si es adyacente
            } else {
                if(!nombreUbicacion.equals(ubicacionActual)){
                    boton.setEnabled(false); // Deshabilitar el botón si no es adyacente
                    boton.setBackground(Color.GRAY); // Gris para las ubicaciones no adyacentes
                }
            }

            if (nombreUbicacion.equals(ubicacionActual)) {
                JLabel flechaLabel = new JLabel("<<<");
                panel.add(boton); 
                panel.add(flechaLabel);
            } else {
                panel.add(boton); // Solo añadir el botón si no es la ubicación actual
            }

            // Añadir el panel con el botón al panel principal
            panelPrincipal.add(panel);
        }

        // Añadir el panel principal al centro del JFrame
        add(panelPrincipal, BorderLayout.CENTER);
    }
}
