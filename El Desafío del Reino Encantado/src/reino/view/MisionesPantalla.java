package reino.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Map;
import javax.swing.*;

import reino.controller.JuegoController;

public class MisionesPantalla extends JFrame {
    public MisionesPantalla(Map<String, Boolean> recompensas) {
        // Configurar el frame principal
        setTitle("Recompensas de Misiones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500); 
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); 

        // Crear un panel para el botón en la parte superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton botonVolverMapa = new JButton("Volver a Mapa");
        botonVolverMapa.setPreferredSize(new Dimension(200, 30));
        botonVolverMapa.setBackground(new Color(173, 216, 230)); // Azul claro
        botonVolverMapa.setFont(new Font("Arial", Font.BOLD, 14));
        botonVolverMapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoController.mostrarPantallaMap();
                dispose();
            }
        });

        // Botón "Canjear Recompensas"
        JButton botonCanjear = new JButton("Canjear Recompensas");
        botonCanjear.setPreferredSize(new Dimension(200, 30));
        botonCanjear.setBackground(new Color(144, 238, 144)); // Verde claro
        botonCanjear.setFont(new Font("Arial", Font.BOLD, 14));
        botonCanjear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean intercambio = JuegoController.canjearRecompensas();
                if (intercambio) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Se intercambiaron recompensas.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    dispose(); 
                    JuegoController.mostrarPantallaMisiones(); 
                } else {
                    JOptionPane.showMessageDialog(
                        null,
                        "No hay recompensas disponibles para intercambiar.",
                        "Información",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });
        
        panelSuperior.add(botonVolverMapa);
        panelSuperior.add(botonCanjear, BorderLayout.EAST); 

        // Añadir el panel superior al frame
        
        add(panelSuperior, BorderLayout.NORTH);

        // Crear un panel para mostrar las recompensas en formato de lista
        JPanel panelRecompensas = new JPanel();
        panelRecompensas.setLayout(new GridLayout(0, 2, 1, 1)); // 2 columnas: descripción y estado

        // Recorrer las recompensas y añadirlas al panel
        for (Map.Entry<String, Boolean> entrada : recompensas.entrySet()) {
            String descripcion = entrada.getKey();
            Boolean canjeado = entrada.getValue();

            // Etiqueta para la descripción
            JLabel labelDescripcion = new JLabel(descripcion);
            labelDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));

            // Etiqueta para el estado
            JLabel labelEstado = new JLabel(canjeado ? "CANJEADA" : "SIN USAR");
            labelEstado.setFont(new Font("Arial", Font.PLAIN, 14));
            labelEstado.setHorizontalAlignment(SwingConstants.CENTER);
            labelEstado.setForeground(canjeado ? Color.GREEN : Color.RED); // Cambia el color según el estado

            // Añadir las etiquetas al panel
            panelRecompensas.add(labelDescripcion);
            panelRecompensas.add(labelEstado);
        }

        // Añadir el panel de recompensas al centro del frame
        add(new JScrollPane(panelRecompensas), BorderLayout.CENTER);

        // Configurar y mostrar el frame
        setVisible(true);
    }
}
