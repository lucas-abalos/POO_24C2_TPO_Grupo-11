package reino.view;

import java.awt.*;
import javax.swing.*;

public class VictoriaPantalla extends JFrame {

    public VictoriaPantalla() {
        setTitle("¡Victoria!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Configuración del layout
        setLayout(new BorderLayout());

        // Panel superior para el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(0, 102, 204)); // Azul vibrante
        JLabel titulo = new JLabel("¡Has ganado!");
        titulo.setFont(new Font("Serif", Font.BOLD, 36));
        titulo.setForeground(Color.WHITE);
        panelTitulo.add(titulo);

        // Panel central para el mensaje
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(new Color(173, 216, 230)); // Azul claro

        // Etiqueta de emojis decorativos
        JLabel emojis = new JLabel("🏆 🎉 ✨ 🌟 🎉 🏆");
        emojis.setFont(new Font("SansSerif", Font.BOLD, 24));
        emojis.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Etiqueta de mensaje
        JLabel mensaje = new JLabel("<html><center>¡Felicidades! Has encontrado el tesoro y derrotado a todos los enemigos.<br>¡El reino está a salvo gracias a ti!</center></html>");
        mensaje.setFont(new Font("Arial", Font.PLAIN, 18));
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar componentes al panel central
        panelCentral.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        panelCentral.add(emojis);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        panelCentral.add(mensaje);

        // Botón para salir
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(0, 102, 204)); // Azul vibrante
        JButton botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 16));
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setBackground(new Color(220, 20, 60)); // Rojo carmesí
        botonSalir.setFocusPainted(false);
        botonSalir.addActionListener(e -> System.exit(0));
        panelInferior.add(botonSalir);

        // Agregar paneles al JFrame
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // public static void main(String[] args) {
    //     // Mostrar la pantalla de victoria
    //     SwingUtilities.invokeLater(() -> {
    //         VictoriaPantalla pantallaVictoria = new VictoriaPantalla();
    //         pantallaVictoria.setVisible(true);
    //     });
    // }
}
