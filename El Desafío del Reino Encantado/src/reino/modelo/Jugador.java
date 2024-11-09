package reino.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Jugador {
    private int nivelExperiencia;
    private final Heroe heroe;
    private List<Recompensa> recompensas;

    private Jugador(Heroe heroe) {
        this.nivelExperiencia = 0;
        this.heroe = heroe;
        this.recompensas = new ArrayList<>();
    }

    public static Jugador crearPersonaje() {

        Scanner scanner = new Scanner(System.in);
        // 2. Elegir la clase del personaje
        System.out.println("Elige una clase para tu héroe:");
        System.out.println("1 - Guerrero");
        System.out.println("2 - Mago");
        System.out.println("3 - Arquero");
        int claseSeleccionada = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea



        Heroe heroe;
        switch (claseSeleccionada) {
            case 1:
                heroe = new Guerrero();
                break;
            case 2:
                heroe = new Mago();
                break;
            case 3:
                heroe = new Arquero();
                break;
            default:
                System.out.println("Opción inválida, se asignará una clase al azar por defecto.");
                heroe = new Guerrero();
                break;
        }


        Jugador jugador  = new Jugador(heroe);
        // Configurar las estadísticas iniciales del héroe

                // Imprimir resumen del personaje

        return new Jugador(heroe);
    }

    public int getNivelExperiencia(){
        return nivelExperiencia;
    }
    public Heroe devolverHeroe(){
        return heroe;
    }

    public void agregarRecompensa(Recompensa recompensa) {
        if (recompensas == null) {
            recompensas = new ArrayList<>();  // Inicializa la lista si es la primera recompensa que obtiene
        }
        if (recompensa != null) {
            recompensas.add(recompensa);  // Añade la recompensa a la lista
        }
        System.out.println("Conseguiste la siguiente recompensa: " + recompensa);
    }

    public void intercambiarRecompensas() {
        if (recompensas == null || recompensas.isEmpty()) {
            return;  // No hay recompensas para intercambiar
        }
        // Uso Iterator para eliminar recompensas mientras itera
        Iterator<Recompensa> iterator = recompensas.iterator();
        while (iterator.hasNext()) {
            Recompensa recompensa = iterator.next();
    
            if(recompensa.getCantidadAtaque() > 0){
                mejorarAtaqueHeroe(recompensa.getCantidadAtaque() , true);
            }
            if(recompensa.getPorcentajeAtaque() > 0){
                int cantIncrementar = (int)(heroe.getNivelAtaque() * recompensa.getPorcentajeAtaque());
                if(cantIncrementar < 1) {
                    cantIncrementar = 1;
                }
                mejorarAtaqueHeroe(cantIncrementar , true);
            }
            if(recompensa.getCantidadDefensa() > 0){
                mejorarDefensaHeroe(recompensa.getCantidadDefensa() , true);
            }
            if(recompensa.getPorcentajeDefensa() > 0){
                int cantIncrementar = (int)(heroe.getNivelDefensa() * recompensa.getPorcentajeDefensa());
                if (cantIncrementar < 1) {
                    cantIncrementar = 1;
                }
                mejorarDefensaHeroe(cantIncrementar , true);
            }
            System.out.println("Se recolectó la recompensa: " + recompensa.getDescipcion());
            System.out.println("Esta otorgaba el siguiente premio: " + recompensa.getPremio());
            // Eliminar la recompensa una vez utilizada
            iterator.remove();
        }
    }

    public void incrementarExperiencia(int cantidad){
        this.nivelExperiencia += cantidad;
        System.out.println("Tu experiencia ha aumentado " + cantidad + " puntos! \nAhora tienes " + this.nivelExperiencia);
    }

    public boolean mejorarAtaqueHeroe(int cantidad, boolean isRecompensa) {
        if (isRecompensa) {
            heroe.setNivelAtaque(heroe.getNivelAtaque() + cantidad);
            System.out.println("Ha mejorado su defensa en " + cantidad + ". Alcanzando los " + heroe.getNivelDefensa() + " puntos.");
            return true;
        }
        if(cantidad > nivelExperiencia || cantidad <= 0){
            System.out.println("La cantidad ingresada es incorrecta o supera el nivel de experiencia actual, Nivel Experiencia actual: " + nivelExperiencia);
            return false;
        }
        else{
            heroe.setNivelAtaque(heroe.getNivelAtaque() + cantidad);
            nivelExperiencia -= cantidad;
            System.out.println("Ha mejorado su ataque en " + cantidad + ". Alcanzando los " + heroe.getNivelAtaque() + " puntos.");
            return true;
        }
    }

    public boolean mejorarDefensaHeroe(int cantidad, boolean isRecompensa) {
        if (isRecompensa) {
            heroe.setNivelAtaque(heroe.getNivelAtaque() + cantidad);
            System.out.println("Ha mejorado su defensa en " + cantidad + ". Alcanzando los " + heroe.getNivelDefensa() + " puntos.");
            return true;
        }
        if(cantidad > nivelExperiencia || cantidad <= 0){
            System.out.println("La cantidad ingresada es incorrecta o supera el nivel de experiencia actual, Nivel Experiencia actual: " + nivelExperiencia);
            return false;
        }
        else{
            heroe.setNivelDefensa(heroe.getNivelDefensa() + cantidad);
            nivelExperiencia -= cantidad;
            System.out.println("Ha mejorado su defensa en " + cantidad + ". Alcanzando los " + heroe.getNivelDefensa() + " puntos.");
            return true;
        }
    }

}
