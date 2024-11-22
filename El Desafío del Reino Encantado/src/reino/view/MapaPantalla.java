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

    public MapaPantalla(Map<String, List<String>> ubicacionesAdyacentes, String ubicacionActual) {
        this.ubicacionesAdyacentes = ubicacionesAdyacentes;
        this.ubicacionActual = ubicacionActual;

        setTitle("Pantalla de Mapa");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // BorderLayout para organizar la ventana

        mostrarBotones();
    }

    private void mostrarBotones() {
        // Crear un panel para la parte superior (arriba a la derecha)
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonEstado = new JButton("Estado Personaje");
        botonEstado.setEnabled(true);
        botonEstado.setBackground(new Color(144, 238, 144)); // Verde claro (Light Green)

        JButton botonMisiones = new JButton("Misiones y Recompensas");
        botonMisiones.setEnabled(true);
        botonMisiones.setBackground(new Color(144, 238, 144)); // Verde claro (Light Green)

        JButton botonMejoraPersonaje = new JButton("Mejora Personaje");
        botonMejoraPersonaje.setEnabled(true);
        botonMejoraPersonaje.setBackground(new Color(144, 238, 144)); // Verde claro (Light Green)

        botonMisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoController.mostrarPantallaMisiones();
                dispose();
            }
        });

        botonMejoraPersonaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoController.mostrarPantallaMejoraPersonaje();
                dispose();
            }
        });

        botonEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoController.mostrarPantallaEstadoPersonaje();
                dispose();
            }
        });
        panelSuperior.add(botonMisiones);
        panelSuperior.add(botonEstado);
        panelSuperior.add(botonMejoraPersonaje);
        add(panelSuperior, BorderLayout.NORTH); // Añadir el panel superior al norte del layout

        // Crear el panel principal para los botones de ubicaciones
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)); 
        panelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar los elementos en el panel

        // Etiqueta de experiencia actual
        JLabel labelExperiencia = new JLabel("Seleccioná la posición a la cual viajar");
        labelExperiencia.setFont(new Font("Arial", Font.BOLD, 16));
        labelExperiencia.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(labelExperiencia);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado

        for (String nombreUbicacion : ubicacionesAdyacentes.keySet()) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton boton = new JButton(nombreUbicacion);

            // Verificar si la ubicación es adyacente a la ubicación actual
            if (ubicacionesAdyacentes.get(ubicacionActual).contains(nombreUbicacion)) {
                boton.setEnabled(true); // Habilitar el botón si es adyacente
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String resultadoDelViaje = JuegoController.viajar(nombreUbicacion); 
                        dispose(); // Cerrar la pantalla actual

                        switch (resultadoDelViaje) {
                            case "GANASTE":
                                JuegoController.mostrarPantallaVictoria();
                                break;
                            case "PERDISTE":
                                JuegoController.mostrarPantallaDerrota();
                                break;
                            default:
                                JuegoController.mostrarPantallaMap();
                                // Mostrar el mensaje en un JOptionPane
                                JTextArea textArea = new JTextArea(resultadoDelViaje);
                                textArea.setEditable(false);
                                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                                textArea.setWrapStyleWord(true);
                                textArea.setLineWrap(true);
                                textArea.setBackground(null);
        
                                JScrollPane scrollPane = new JScrollPane(textArea);
                                scrollPane.setPreferredSize(new Dimension(400, 200));
        
                                JOptionPane.showMessageDialog(
                                    MapaPantalla.this, // Correctly pass the parent component, or null if no parent
                                    scrollPane, // The content of the dialog
                                    "Resultado del Viaje", // The title of the dialog
                                    JOptionPane.INFORMATION_MESSAGE // The message type
                                );
                        }
                    }
                });
            } else {
                if (!nombreUbicacion.equals(ubicacionActual)) {
                    boton.setEnabled(false); // Deshabilitar el botón si no es adyacente
                    boton.setBackground(Color.GRAY); // Gris para las ubicaciones no adyacentes
                }
            }

            if (nombreUbicacion.equals(ubicacionActual)) {
                JLabel flechaLabel = new JLabel("<<< Posición Actual");
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
