package reino.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import reino.controller.JuegoController;

public class MapaPantalla extends JFrame {

    private Map<String, List<String>> ubicacionesAdyacentes;
    private String ubicacionActual;
    private String ubicacionConTesoro; // La ubicación donde está el tesoro

    public MapaPantalla(Map<String, List<String>> ubicacionesAdyacentes, String ubicacionActual, String ubicacionConTesoro) {
        this.ubicacionesAdyacentes = ubicacionesAdyacentes;
        this.ubicacionActual = ubicacionActual;
        this.ubicacionConTesoro = ubicacionConTesoro;

        setTitle("Pantalla de Mapa");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // BorderLayout para centrar el contenido

        mostrarBotones();
    }

    private void mostrarBotones() {
        // Crear un panel para la parte superior (arriba a la derecha)
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonEstado = new JButton("Estado Personaje");
        botonEstado.setEnabled(true);
        botonEstado.setBackground(new Color(144, 238, 144)); // Verde claro (Light Green)

        botonEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoController.mostrarPantallaEstadoPersonaje();
                dispose();
            }
        });

        panelSuperior.add(botonEstado);
        add(panelSuperior, BorderLayout.NORTH); // Añadir el panel superior al norte del layout

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar los elementos en el panel

        for (String nombreUbicacion : ubicacionesAdyacentes.keySet()) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton boton = new JButton(nombreUbicacion);

            // Crear una copia final de nombreUbicacion para usar dentro del ActionListener
            final String ubicacionSeleccionada = nombreUbicacion;

            // Verificar si la ubicación es adyacente a la ubicación actual
            boolean esAdyacente = ubicacionesAdyacentes.get(ubicacionActual).contains(nombreUbicacion);

            if (esAdyacente) {
                boton.setEnabled(true); // Habilitar el botón si es adyacente
                JLabel adyacenteLabel = new JLabel("<<< puedes viajar a estos lugares");
                adyacenteLabel.setForeground(Color.BLUE); // Opcional: Estilo visual
                panel.add(boton);
                panel.add(adyacenteLabel); // Agregar el texto al lado del botón
            } else {
                if (!nombreUbicacion.equals(ubicacionActual)) {
                    boton.setEnabled(false); // Deshabilitar el botón si no es adyacente
                    boton.setBackground(Color.GRAY); // Gris para las ubicaciones no adyacentes
                }
                panel.add(boton);
            }

            if (nombreUbicacion.equals(ubicacionActual)) {
                JLabel flechaLabel = new JLabel("<<< ubicación Actual");
                flechaLabel.setForeground(Color.RED); // Opcional: Estilo visual
                panel.add(boton);
                panel.add(flechaLabel);

                // Mostrar el mensaje de información al hacer clic en el botón
                boton.addActionListener(e -> mostrarInformacionDeUbicacion());
            }

            // Añadir el ActionListener al botón
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manejarDestino(ubicacionSeleccionada);
                }
            });

            // Añadir el panel con el botón al panel principal
            panelPrincipal.add(panel);
        }

        // Añadir el panel principal al centro del JFrame
        add(panelPrincipal, BorderLayout.CENTER);
    }

    // Método para mostrar la información de la ubicación actual
    private void mostrarInformacionDeUbicacion() {
        List<String> adyacentes = ubicacionesAdyacentes.get(ubicacionActual);
        String mensaje = "Estás en la ubicación: " + ubicacionActual + ".\n";
        mensaje += "Puedes ir a las siguientes ubicaciones:\n";
        for (String ubicacion : adyacentes) {
            mensaje += "- " + ubicacion + "\n";
        }
        JOptionPane.showMessageDialog(this, mensaje, "Información de Ubicación", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para manejar el destino seleccionado
    private void manejarDestino(String ubicacionSeleccionada) {
        if (ubicacionSeleccionada != null) {
            if (ubicacionSeleccionada.equals(ubicacionConTesoro)) {
                JOptionPane.showMessageDialog(this, "¡Ganaste el juego! Encontraste el tesoro en " + ubicacionSeleccionada + "!", "Victoria", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0); // Finalizar el juego
            } else {
                JOptionPane.showMessageDialog(this, "No hay tesoro en " + ubicacionSeleccionada + ". Volviendo al mapa.", "Sin Tesoro", JOptionPane.INFORMATION_MESSAGE);
                new MapaPantalla(ubicacionesAdyacentes, ubicacionSeleccionada, ubicacionConTesoro).setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        }
    }
}
