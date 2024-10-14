package reino.modelo;

public class Espectro extends Criatura{
    public Espectro(String nombre, int nivelAtaque, int nivelDefensa, int nivel) {
        super(nombre, nivelAtaque, nivelDefensa, nivel);
    }

    @Override
    public int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes) {
        if (defensor instanceof Arquero) {
            return (int)(this.getNivelAtaque() * 0.20);  
        }
        return 0;
    }

    @Override
    public int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes) {
        return 0;
    }
}
