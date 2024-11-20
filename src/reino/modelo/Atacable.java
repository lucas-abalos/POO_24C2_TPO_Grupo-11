package reino.modelo;

public interface Atacable {
    int usarHabilidadEspecialAtaque(Personaje defensor, int cantGolpes);
    int usarHabilidadEspecialDefensa(Personaje atacante, int cantGolpes);
}
