package reino.modelo;

import java.util.Scanner;

public abstract class Heroe extends Personaje implements Atacable{
    private Jugador duenio;

    public Heroe() {
        super("",0,0);
        this.crearHeroe();
    }
    protected void crearHeroe() {
        Scanner scanner = new Scanner(System.in);

        // 1. Pedir el nombre del héroe
        System.out.print("Ingresa el nombre de tu héroe: ");
        String nombre = scanner.nextLine();
        this.setNombre(nombre);

        // 3. Distribuir puntos iniciales
        int puntosRestantes = 10;
        int ataque = 0, defensa = 0;
        while (puntosRestantes > 0) {

            System.out.println("Tienes " + puntosRestantes + " puntos para distribuir.");
            System.out.print("¿Cuántos puntos quieres asignar a ataque? ");
            int puntosAtaque = scanner.nextInt();
            if (puntosAtaque <= puntosRestantes) {
                ataque += puntosAtaque;
                puntosRestantes -= puntosAtaque;
            } else {
                System.out.println("No tienes suficientes puntos. Intenta de nuevo.");
                continue;
            }

            System.out.print("¿Cuántos puntos quieres asignar a defensa? ");
            int puntosDefensa = scanner.nextInt();
            if (puntosDefensa <= puntosRestantes) {
                this.setNivelDefensa(getNivelAtaque() + puntosDefensa);
                defensa += puntosDefensa;
                puntosRestantes -= puntosDefensa;
            } else {
                System.out.println("No tienes suficientes puntos. Intenta de nuevo.");
                continue;
            }
            if (puntosRestantes > 0) {
                System.out.println("Te quedan " + puntosRestantes + " puntos para asignar. Puedes redistribuir si deseas.");
            }
        }
        this.setNivelAtaque(ataque);
        this.setNivelDefensa(defensa);
        System.out.println("Creación del héroe completada:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Clase: " + this.getClass().getSimpleName());
        System.out.println("Ataque: " + this.getNivelAtaque());
        System.out.println("Defensa: " + this.getNivelDefensa());


    }

    public void setDuenio(Jugador duenio){
        this.duenio = duenio;
    }

    public Jugador devolverDuenio(){
        return duenio;
    }

    @Override
    public abstract int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes);

    @Override
    public abstract int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes);

    public abstract void ganoPelea(Criatura criatura);
}
