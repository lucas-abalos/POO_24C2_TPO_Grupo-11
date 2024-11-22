package reino.modelo;

public abstract class Heroe extends Personaje implements Atacable{
    private Jugador duenio;

    public Heroe(String nombre, int nivelAtaque , int nivelDefensa) {
        super(nombre,nivelAtaque,nivelDefensa);

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


    public int getAgilidad(){return 0;}
    public int getPunteria(){return 0;}
}
