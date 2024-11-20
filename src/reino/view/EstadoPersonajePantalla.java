package reino.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reino.controller.JuegoController;

public class EstadoPersonajePantalla extends JFrame {
    public EstadoPersonajePantalla(int vida, int ataque, int defensa) {
        // Configurar el frame principal
        setTitle("Niveles de Personaje");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null); // Layout absoluto para colocar los componentes manualmente

        // Crear las etiquetas y los valores
        JLabel labelVida = new JLabel("Nivel de Vida:");
        labelVida.setBounds(20, 20, 100, 25);
        add(labelVida);
        JLabel valorVida = new JLabel(String.valueOf(vida)); // Aquí reemplazarás por la variable necesaria
        valorVida.setBounds(150, 20, 50, 25);
        add(valorVida);

        JLabel labelAtaque = new JLabel("Nivel de Ataque:");
        labelAtaque.setBounds(20, 60, 100, 25);
        add(labelAtaque);
        JLabel valorAtaque = new JLabel(String.valueOf(ataque)); // Aquí reemplazarás por la variable necesaria
        valorAtaque.setBounds(150, 60, 50, 25);
        add(valorAtaque);

        JLabel labelDefensa = new JLabel("Nivel de Defensa:");
        labelDefensa.setBounds(20, 100, 100, 25);
        add(labelDefensa);
        JLabel valorDefensa = new JLabel(String.valueOf(defensa)); // Aquí reemplazarás por la variable necesaria
        valorDefensa.setBounds(150, 100, 50, 25);
        add(valorDefensa);

        // Crear el botón "Mapa" en la esquina superior derecha
        JButton botonMapa = new JButton("Mapa");
        botonMapa.setBounds(200, 10, 80, 25); // Posición y tamaño
        botonMapa.setBackground(new Color(144, 238, 144));
        add(botonMapa);

        // Añadir un ActionListener al botón "Mapa"
        botonMapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para mostrar la pantalla del mapa y cerrar esta ventana
                JuegoController.mostrarPantallaMap();
                dispose();
            }
        });

        // Configurar y mostrar el frame
        setVisible(true);
    }
}
