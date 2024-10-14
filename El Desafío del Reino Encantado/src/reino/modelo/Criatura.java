package reino.modelo;

public abstract class Criatura extends Personaje implements Atacable{
    private final int nivel;

    public Criatura(String nombre, int nivelAtaque, int nivelDefensa, int nivel) {
        super(nombre, nivelAtaque, nivelDefensa);
        this.nivel = nivel;
    }
    
    public int getNivel() {
        return nivel;
    }

    @Override
    public abstract int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes);
    @Override
    public abstract int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes);

}
