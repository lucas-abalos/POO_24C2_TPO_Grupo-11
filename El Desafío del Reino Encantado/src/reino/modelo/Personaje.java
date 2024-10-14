package reino.modelo;

public class Personaje {
    private String nombre;
    private int vida;
    private int nivelAtaque;
    private int nivelDefensa;

    public Personaje(String nombre, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.vida = 100;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
    }

    public boolean mejorarAtaque(int cantidad) {
        if (cantidad > 0) {
            nivelAtaque += cantidad;
            System.out.println(nombre + " ha mejorado su ataque en " + cantidad + " puntos.");
            return true;
        } else {
            System.out.println("Cantidad inválida para mejorar ataque.");
            return false;
        }
    }

    public boolean mejorarDefensa(int cantidad) {
        if (cantidad > 0) {
            nivelDefensa += cantidad;
            System.out.println(nombre + " ha mejorado su defensa en " + cantidad + " puntos.");
            return true;
        } else {
            System.out.println("Cantidad inválida para mejorar defensa.");
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(int nivelDefensa) {    
        this.nivelDefensa = nivelDefensa;
        if(this.nivelDefensa < 0) this.nivelDefensa = 0;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void mostrarEstado() {
        System.out.println("Estado de " + nombre + ":");
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + nivelAtaque);
        System.out.println("Defensa: " + nivelDefensa);
    }
}
