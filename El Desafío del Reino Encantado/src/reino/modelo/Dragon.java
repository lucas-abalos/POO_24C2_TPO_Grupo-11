package reino.modelo;

public class Dragon extends Criatura {

    public Dragon(String nombre, int nivelAtaque, int nivelDefensa, int nivel) {
        super(nombre, nivelAtaque, nivelDefensa, nivel);
    }

    @Override
    public int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes) {
        if (defensor instanceof Guerrero) {
            return (int)(this.getNivelAtaque() * 0.30);  // Aumenta el ataque en 30%
        }
        return 0;
    }

    @Override
    public int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes) {
        return 0;
    }
}
