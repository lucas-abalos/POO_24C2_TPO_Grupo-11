package reino.modelo;

public class Guerrero extends Heroe {
    public Guerrero(String nombre, int nivelAtaque, int nivelDefensa) {
        super(nombre, nivelAtaque, nivelDefensa);
    }

    @Override
    public int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes) {
        if (defensor instanceof Troll) {            
            return (int)(this.getNivelAtaque() * 1000);  // Aumenta el ataque MUCHO para que a la primera piña lo haga bosta
        }
        if(cantGolpes >= 3){
            return (int)(this.getNivelAtaque() * 0.5); // Después del tercer golpe aumenta el ataque un 50% por el resto de la pelea
        }
        return 0;
    }

    @Override
    public int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes) {
        return 0;
    }

    @Override
    public void ganoPelea(Criatura criatura){
		this.devolverDuenio().incrementarExperiencia(criatura.getNivel());
    }
}
