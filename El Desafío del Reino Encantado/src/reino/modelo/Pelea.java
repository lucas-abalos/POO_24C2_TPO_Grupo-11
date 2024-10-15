package reino.modelo;

public class Pelea {
    private final Heroe heroe;
    private final Criatura criatura;

    public Pelea(Heroe heroe, Criatura criatura) {
        this.heroe = heroe;
        this.criatura = criatura;
    }

    public boolean iniciarPelea() {
        System.out.println("¡La pelea ha comenzado!");
        boolean peleaEnCurso = true;
        int cantGolpesHeroe = 0;
        int cantGolpesCriatura = 0;

        while (peleaEnCurso) {
            peleaEnCurso = turnoHeroe(cantGolpesHeroe);
            cantGolpesHeroe++;
            if (!peleaEnCurso) break;
            peleaEnCurso = turnoCriatura(cantGolpesCriatura);
            cantGolpesCriatura++;
        }

        if (heroe.getVida() <= 0) {
            System.out.println("El héroe ha sido derrotado por la " + criatura.getNombre() + "!");
        } else if (criatura.getVida() <= 0) {
            System.out.println("¡El héroe " + heroe.getNombre() + " ha derrotado a la " + criatura.getNombre() + "!");
            heroe.ganoPelea(criatura); 
        }
        return heroe.getVida() > 0; // Si gano el heroe devuelvo True y sigue el curso del juego, si es false se termina la partida
    }

    private boolean turnoHeroe(int cantGolpes) {
        System.out.println(heroe.getNombre() + " ataca a la " + criatura.getNombre());
        atacar(heroe, criatura, cantGolpes);
        return criatura.getVida() > 0; 
    }

    private boolean turnoCriatura(int cantGolpes) {
        System.out.println(criatura.getNombre() + " ataca a " + heroe.getNombre());
        atacar(criatura, heroe, cantGolpes);
        return heroe.getVida() > 0; 
    }

    private void atacar(Personaje atacante, Personaje defensor, int cantGolpes) {
        int restarVida = 0;
        int ataqueHabEspecial = ((Atacable) atacante).usarHabilidadEspecialAtaque(defensor, cantGolpes);
        int defensaHabEspecial = ((Atacable) defensor).usarHabilidadEspecialDefensa(atacante, cantGolpes);
        int danio = atacante.getNivelAtaque() + ataqueHabEspecial - defensaHabEspecial;

        if(danio < 0){// Si daño es negativo significa que el defensor bloqueó el ataque. Esto pasa cuando la defensaHabEspecial es muy alta
            System.out.println(defensor.getNombre() + " bloquea el ataque de " + atacante.getNombre());
        }
        else{
            if (defensor.getNivelDefensa() > 0) {
                if(atacante.getNivelAtaque() + ataqueHabEspecial > defensaHabEspecial){ // Si el ataque es mayor al poder de DEFENSA por HABILIDAD ESPECIAL resto defensa
                    if(danio > defensor.getNivelDefensa()){ // En este caso además de bajarle toda la defensa tengo que bajarle la vida
                        restarVida = Math.abs(defensor.getNivelDefensa() - danio);
                    }
                    defensor.setNivelDefensa(defensor.getNivelDefensa() - danio);
                }
            }
            if (defensor.getNivelDefensa() == 0) {
                if(restarVida > 0){ // Si restarVida es mayor a 0 es porq le dieron una piña que le bajo toda la defensa y también le tiene que bajar vida
                    defensor.setVida(defensor.getVida() - restarVida);
                }
                else{ // En este caso caso entra cuando ya tenía toda la defensa bajo previo al ataque actual
                    defensor.setVida(defensor.getVida() - danio);
                }
                System.out.println(atacante.getNombre() + " inflige " + danio + " puntos de daño a " + defensor.getNombre());
            } else {
                System.out.println(defensor.getNombre() + " bloquea el ataque de " + atacante.getNombre());
            }
        }
    }
}
