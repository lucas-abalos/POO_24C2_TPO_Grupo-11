package reino.modelo;

public class Mago extends Heroe{
    public Mago() {super();}

    @Override
    public int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes) {
        return 0;
    }

    @Override
    public int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes) {
        if (atacante instanceof Troll) {
            return (int)(this.getNivelDefensa() * 1000);  // Aumenta la defensa MUCHO para ser inmune contra golpes de Trolls
        }
        return 0;
    }

    @Override
    public void ganoPelea(Criatura criatura){
		this.devolverDuenio().incrementarExperiencia(criatura.getNivel());
        this.setVida(100); 
    }
}
