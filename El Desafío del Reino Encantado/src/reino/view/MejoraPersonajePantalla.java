package reino.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import reino.controller.JuegoController;

public class MejoraPersonajePantalla extends JFrame {
    private int experienciaActual;
    public MejoraPersonajePantalla(int cantidadExperiencia) {
        this.experienciaActual = cantidadExperiencia;
        // Configurar el frame principal
        setTitle("Mejora de Personaje");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());



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
        panelSuperior.add(botonVolverMapa);

        add(panelSuperior, BorderLayout.NORTH);


        // Panel principal con BoxLayout
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Etiqueta de experiencia actual
        JLabel labelExperiencia = new JLabel("Experiencia Actual: " + cantidadExperiencia);
        labelExperiencia.setFont(new Font("Arial", Font.BOLD, 16));
        labelExperiencia.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(labelExperiencia);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado

        // Sección para incrementar ataque
        JLabel labelAtaque = new JLabel("Incrementar Ataque:");
        labelAtaque.setFont(new Font("Arial", Font.PLAIN, 14));
        labelAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(labelAtaque);

        JTextField campoAtaque = new JTextField(10);
        campoAtaque.setMaximumSize(new Dimension(200, 30));
        campoAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(campoAtaque);

        JButton botonGuardarAtaque = new JButton("Guardar Ataque");
        botonGuardarAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonGuardarAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int incremento = Integer.parseInt(campoAtaque.getText());
                    if (incremento <= experienciaActual) {
                        if (!JuegoController.incrementarAtaque(incremento)) {
                            JOptionPane.showMessageDialog(null, "No puedes mejorar tu heroe desde esta ubicacion. Viaja a un pueblo neutral!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        };
                        experienciaActual -= incremento;
                        labelExperiencia.setText(String.valueOf(experienciaActual));
                        
                        JOptionPane.showMessageDialog(null, "Ataque incrementado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No tienes suficiente experiencia.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelPrincipal.add(botonGuardarAtaque);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado

        // Sección para incrementar defensa
        JLabel labelDefensa = new JLabel("Incrementar Defensa:");
        labelDefensa.setFont(new Font("Arial", Font.PLAIN, 14));
        labelDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(labelDefensa);

        JTextField campoDefensa = new JTextField(10);
        campoDefensa.setMaximumSize(new Dimension(200, 30));
        campoDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(campoDefensa);

        JButton botonGuardarDefensa = new JButton("Guardar Defensa");
        botonGuardarDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonGuardarDefensa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int incremento = Integer.parseInt(campoDefensa.getText());
                    if (incremento <= experienciaActual) {
                        if (!JuegoController.incrementarDefensa(incremento)) {
                            JOptionPane.showMessageDialog(null, "No puedes mejorar tu heroe desde esta ubicacion. Viaja a un pueblo neutral!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        };
                        experienciaActual -= incremento;
                        labelExperiencia.setText(String.valueOf(experienciaActual));
                        
                        JOptionPane.showMessageDialog(null, "Defensa incrementada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No tienes suficiente experiencia.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelPrincipal.add(botonGuardarDefensa);

        // Añadir el panel principal al centro del frame
        add(panelPrincipal, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     new MejoraPersonajePantalla(100); // Prueba con 100 de experiencia inicial
    // }
}
