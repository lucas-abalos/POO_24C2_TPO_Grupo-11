package reino.modelo;

public class Tesoro {
    private final String nombre;

    public Tesoro(String nombre) {
        this.nombre = nombre;
    }
    public String devolverDescripcion(){
        return nombre;
    }
}
