package reino.modelo;

import java.util.Random;
import java.util.Scanner;

public class Arquero extends Heroe{
    private int punteria;
    private int agilidad;

    public Arquero() {
		super();
		asignarPuntosEspeciales();
	}
	private void asignarPuntosEspeciales() {
		Scanner scanner = new Scanner(System.in);

		// Asignación de puntos especiales para Arquero: Agilidad y Puntería
		int puntosRestantes = 10;  // Este valor se ajusta si se desea diferente distribución

		System.out.println("\n\nComo arquero tienes " + puntosRestantes + " puntos adicionales para asignar a agilidad y puntería.");

		while (puntosRestantes > 0) {
			// Asignar puntos a agilidad
			System.out.print("¿Cuántos puntos quieres asignar a agilidad? ");
			int puntosAgilidad = scanner.nextInt();
			if (puntosAgilidad <= puntosRestantes) {
				agilidad += puntosAgilidad;
				puntosRestantes -= puntosAgilidad;
			} else {
				System.out.println("No tienes suficientes puntos. Intenta de nuevo.");
				continue;  // Vuelve a preguntar si los puntos son insuficientes
			}

			// Asignar puntos a puntería
			if (puntosRestantes > 0) {
				System.out.print("¿Cuántos puntos quieres asignar a puntería? ");
				int puntosPunteria = scanner.nextInt();
				if (puntosPunteria <= puntosRestantes) {
					punteria += puntosPunteria;
					puntosRestantes -= puntosPunteria;
				} else {
					System.out.println("No tienes suficientes puntos. Intenta de nuevo.");
					continue;  // Vuelve a preguntar si los puntos son insuficientes
				}
			}

			if (puntosRestantes > 0) {
				System.out.println("Te quedan " + puntosRestantes + " puntos para asignar. Puedes redistribuir si deseas.");
			}
		}


		System.out.println("Agilidad: " + agilidad);
		System.out.println("Puntería: " + punteria);
	}

	// Método para calcular precisión adicional basada en la puntería del arquero
	public int calcularPrecision() {
		return punteria * 2; // Cada punto de puntería añade 2 puntos de ataque
	}

	public int getPunteria() {
		return punteria;
	}

	public void setPunteria(int punteria) {
		this.punteria = punteria;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

    @Override
    public int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100); // Generar un número aleatorio entre 0 y 99
		if(numeroAleatorio > punteria){ // Si entra aca NO acierta el golpe		
			return -99999; // Seteo un número muy chico para que erre el golpe en la implementación de la clase Pelea.
		}
        return 0;
    }

    @Override
    public int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100); // Generar un número aleatorio entre 0 y 99
		if(numeroAleatorio < agilidad){ // Si entra aca esquiva el golpe
			return 9999;  // Setea un número alto para para ser inmune contra el siguiente golpe
		}
        return 0;
    }

	@Override
    public void ganoPelea(Criatura criatura){
		this.devolverDuenio().incrementarExperiencia(criatura.getNivel());
    }
}
