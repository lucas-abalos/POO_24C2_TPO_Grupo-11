package reino.main;

import reino.controller.JuegoController;
import reino.modelo.*;
import reino.view.JugadorPantalla;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JuegoController.iniciarJuego();
        SwingUtilities.invokeLater(() -> {
            JugadorPantalla pantalla = new JugadorPantalla();
            pantalla.setVisible(true);
        });
    }
}