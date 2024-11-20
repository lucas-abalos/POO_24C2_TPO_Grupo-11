package reino.modelo;

public class Troll extends Criatura{

    public Troll(String nombre, int nivelAtaque, int nivelDefensa, int nivel) {
        super(nombre, nivelAtaque, nivelDefensa, nivel);
    }

    @Override
    public int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes) {
        return 0;
    }

    @Override
    public int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes) {
        if (atacante instanceof Mago) {
            return (int)(this.getNivelDefensa() * 0.15);  // Aumenta la defensa en 15%
        }
        return 0;
    }
}
