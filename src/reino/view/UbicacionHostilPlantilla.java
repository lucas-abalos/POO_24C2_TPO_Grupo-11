package reino.view;

import java.awt.BorderLayout;
import javax.swing.*;



public class UbicacionHostilPlantilla extends JFrame {
    public UbicacionHostilPlantilla(String nombreUbicacion) {
        setTitle("Ubicación Hostil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Has llegado a una ubicación hostil: " + nombreUbicacion, SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
