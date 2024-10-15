package reino.modelo;

public class Ubicacion {
    private String nombre;
    private Criatura criatura;
    private Tesoro tesoro;

    public boolean ubicacionNeutral(){
        return true;
    }
    public String devuelveNombre(){
        return nombre;
    }
    public boolean tieneCriatura(){
        return criatura != null;
    }
    public boolean tieneTesoro(){
        return tesoro != null;
    }
}
