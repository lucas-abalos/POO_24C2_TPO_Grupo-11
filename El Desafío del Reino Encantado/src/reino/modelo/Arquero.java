package reino.modelo;

import java.util.Random;

public class Arquero extends Heroe{
    private int punteria;
    private int agilidad;

    public Arquero(String nombre, int vida, int nivelAtaque, int nivelDefensa, int punteria, int agilidad) {
        super(nombre, nivelAtaque, nivelDefensa);
        this.punteria = punteria;
        this.agilidad = agilidad;
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
