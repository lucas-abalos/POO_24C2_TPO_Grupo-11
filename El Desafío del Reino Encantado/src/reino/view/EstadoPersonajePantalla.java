package reino.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reino.controller.JuegoController;

public class EstadoPersonajePantalla extends JFrame {
    public EstadoPersonajePantalla(int vida, int ataque, int defensa, int agilidad, int punteria) {
        // Configurar el frame principal
        setTitle("Estado del Personaje");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Calcular el tamaño de la ventana dinámicamente
        int alturaVentana = 200;
        if (agilidad > 0 || punteria > 0) {
            alturaVentana += 80; // Incrementar espacio para agilidad y puntería
        }
        setSize(300, alturaVentana);
        setLocationRelativeTo(null);
        setLayout(null); // Layout absoluto para colocar los componentes manualmente

        // Crear las etiquetas y los valores comunes
        JLabel labelVida = new JLabel("Nivel de Vida:");
        labelVida.setBounds(20, 20, 150, 25);
        add(labelVida);
        JLabel valorVida = new JLabel(String.valueOf(vida));
        valorVida.setBounds(150, 20, 100, 25);
        add(valorVida);

        JLabel labelAtaque = new JLabel("Nivel de Ataque:");
        labelAtaque.setBounds(20, 60, 150, 25);
        add(labelAtaque);
        JLabel valorAtaque = new JLabel(String.valueOf(ataque));
        valorAtaque.setBounds(150, 60, 100, 25);
        add(valorAtaque);

        JLabel labelDefensa = new JLabel("Nivel de Defensa:");
        labelDefensa.setBounds(20, 100, 150, 25);
        add(labelDefensa);
        JLabel valorDefensa = new JLabel(String.valueOf(defensa));
        valorDefensa.setBounds(150, 100, 100, 25);
        add(valorDefensa);

        // Mostrar Agilidad y Puntería solo si alguno de ellos es mayor que 0
        int y = 140; // Coordenada inicial para atributos adicionales
        if (agilidad > 0) {
            JLabel labelAgilidad = new JLabel("Nivel de Agilidad:");
            labelAgilidad.setBounds(20, y, 150, 25);
            add(labelAgilidad);
            JLabel valorAgilidad = new JLabel(String.valueOf(agilidad));
            valorAgilidad.setBounds(150, y, 100, 25);
            add(valorAgilidad);
            y += 40; // Incrementar para el siguiente atributo
        }

        if (punteria > 0) {
            JLabel labelPunteria = new JLabel("Nivel de Puntería:");
            labelPunteria.setBounds(20, y, 150, 25);
            add(labelPunteria);
            JLabel valorPunteria = new JLabel(String.valueOf(punteria));
            valorPunteria.setBounds(150, y, 100, 25);
            add(valorPunteria);
        }

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
