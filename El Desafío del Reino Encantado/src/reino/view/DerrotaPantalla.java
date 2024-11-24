package reino.view;

import java.awt.*;
import javax.swing.*;

public class DerrotaPantalla extends JFrame {

    public DerrotaPantalla() {
        setTitle("¡Derrota!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Configuración del layout
        setLayout(new BorderLayout());

        // Panel superior para el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(255, 69, 0)); // Naranja oscuro (tono fuerte de derrota)
        JLabel titulo = new JLabel("¡Derrota!");
        titulo.setFont(new Font("Serif", Font.BOLD, 36));
        titulo.setForeground(Color.WHITE);
        panelTitulo.add(titulo);

        // Panel central para el mensaje
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(new Color(255, 228, 225)); // Rosa claro

        // Etiqueta de emojis decorativos
        JLabel emojis = new JLabel("💀 ⚔️ 😞 💔 ⚔️ 💀");
        emojis.setFont(new Font("SansSerif", Font.BOLD, 24));
        emojis.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Etiqueta de mensaje
        JLabel mensaje = new JLabel("<html><center>Lo siento, no has logrado cumplir tu misión.<br>¡El reino está en peligro! Intenta de nuevo.</center></html>");
        mensaje.setFont(new Font("Arial", Font.PLAIN, 18));
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar componentes al panel central
        panelCentral.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        panelCentral.add(emojis);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        panelCentral.add(mensaje);

        // Botón para intentar de nuevo
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(255, 69, 0)); // Naranja oscuro
        JButton botonReintentar = new JButton("Reintentar");
        botonReintentar.setFont(new Font("Arial", Font.BOLD, 16));
        botonReintentar.setForeground(Color.WHITE);
        botonReintentar.setBackground(new Color(220, 20, 60)); // Rojo carmesí
        botonReintentar.setFocusPainted(false);
        botonReintentar.addActionListener(e -> System.exit(0));
        panelInferior.add(botonReintentar);

        // Agregar paneles al JFrame
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // public static void main(String[] args) {
    //     // Mostrar la pantalla de derrota
    //     SwingUtilities.invokeLater(() -> {
    //         DerrotaPantalla pantallaDerrota = new DerrotaPantalla();
    //         pantallaDerrota.setVisible(true);
    //     });
    // }
}
