package reino.view;

import java.awt.BorderLayout;
import javax.swing.*;



public class UbicacionNeutralPlantilla extends JFrame {
    public UbicacionNeutralPlantilla(String nombreUbicacion) {
        setTitle("Ubicación Neutral");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Has llegado a una ubicación neutral: " + nombreUbicacion, SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
