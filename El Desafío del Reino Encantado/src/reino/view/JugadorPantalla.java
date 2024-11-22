package reino.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.RuntimeErrorException;
import javax.swing.*;
import reino.controller.JuegoController;



public class JugadorPantalla extends JFrame {
    private JTextField nombreField;
    private JComboBox<String> claseCombo;
    private JTextField ataqueField;
    private JTextField defensaField;
    private JTextField agilidadField;
    private JTextField punteriaField;
    private JButton crearButton;
    private JLabel mensajePuntos;

    public JugadorPantalla() {
        setTitle("Creación de Héroe");
        setSize(400, 400);  // Ajuste del tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear componentes
        JLabel nombreLabel = new JLabel("Nombre del héroe:");
        nombreField = new JTextField(15);

        JLabel claseLabel = new JLabel("Clase del héroe:");
        String[] clases = {"Guerrero", "Mago", "Arquero"};
        claseCombo = new JComboBox<>(clases);

        JLabel ataqueLabel = new JLabel("Puntos de Ataque:");
        ataqueField = new JTextField(5);
        JLabel defensaLabel = new JLabel("Puntos de Defensa:");
        defensaField = new JTextField(5);

        // Puntos para Arquero (solo si se selecciona esa clase)
        JLabel agilidadLabel = new JLabel("Puntos de Agilidad:");
        agilidadField = new JTextField(5);
        JLabel punteriaLabel = new JLabel("Puntos de Puntería:");
        punteriaField = new JTextField(5);

        // Mostrar los puntos disponibles
        mensajePuntos = new JLabel("Tienes 10 puntos para distribuir entre Ataque y Defensa.");

        // Crear el botón de creación
        crearButton = new JButton("Crear Héroe");

        // Configurar el panel con BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout vertical
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(claseLabel);
        panel.add(claseCombo);
        panel.add(mensajePuntos);  // Mostrar mensaje de puntos disponibles
        panel.add(ataqueLabel);
        panel.add(ataqueField);
        panel.add(defensaLabel);
        panel.add(defensaField);
        panel.add(agilidadLabel);
        panel.add(agilidadField);
        panel.add(punteriaLabel);
        panel.add(punteriaField);
        panel.add(crearButton);

        add(panel);

        // Deshabilitar todos los campos al inicio
        deshabilitarCampos();

        // Acción del selector de clase
        claseCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Deshabilitar todos los campos al inicio
                deshabilitarCampos();

                // Habilitar campos según la clase seleccionada
                String claseSeleccionada = (String) claseCombo.getSelectedItem();
                if (claseSeleccionada.equals("Arquero")) {
                    mensajePuntos.setText("Tienes 10 puntos para distribuir entre Agilidad y Puntería.");
                    agilidadField.setEnabled(true);
                    punteriaField.setEnabled(true);
                    ataqueField.setEnabled(true);
                    defensaField.setEnabled(true);
                } else {
                    mensajePuntos.setText("Tienes 10 puntos para distribuir entre Ataque y Defensa.");
                    agilidadField.setEnabled(false);
                    punteriaField.setEnabled(false);
                    ataqueField.setEnabled(true);
                    defensaField.setEnabled(true);
                }
            }
        });

        // Acción del botón de creación
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String claseSeleccionada = (String) claseCombo.getSelectedItem();
                try {
                    int ataque = 0, defensa = 0, agilidad = 0, punteria = 0;

                    if (claseSeleccionada.equals("Arquero")) {
                        agilidad = Integer.parseInt(agilidadField.getText());
                        punteria = Integer.parseInt(punteriaField.getText());
                        if (agilidad + punteria != 10) {
                            throw new Exception("Los puntos de Agilidad y Puntería deben sumar 10.");
                        }
                    }
                    ataque = Integer.parseInt(ataqueField.getText());
                    defensa = Integer.parseInt(defensaField.getText());
                    if (ataque + defensa != 10) {throw new Exception("Los puntos de Ataque y Defensa deben sumar 10.");}



                    // Crear el héroe y asignarlo al jugador a través del JuegoController
                    if (ataque == 0 || defensa  == 0 || ((agilidad  == 0 || punteria == 0) && claseSeleccionada.equals("Arquero"))) {
                        throw new NumberFormatException();
                    }
                    JuegoController.crearJugador(nombre, claseSeleccionada, ataque, defensa, agilidad, punteria);

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(JugadorPantalla.this, "Héroe creado exitosamente!");
                    JuegoController.mostrarPantallaMap();
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(JugadorPantalla.this, "Por favor ingresa números válidos en los campos.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(JugadorPantalla.this, ex.getMessage());
                }
            }
        });
    }

    // Método para deshabilitar todos los campos de entrada
    private void deshabilitarCampos() {
        ataqueField.setEnabled(false);
        defensaField.setEnabled(false);
        agilidadField.setEnabled(false);
        punteriaField.setEnabled(false);
    }
}
