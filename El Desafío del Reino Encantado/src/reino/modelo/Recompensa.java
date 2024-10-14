package reino.modelo;

public class Recompensa {
    private final String descripcion;
    private final String premio;
    private final int cantidadDefensa;
    private final float porcentajeDefensa;
    private final int cantidadAtaque;
    private final float porcentajeAtaque;

    public Recompensa(String descripcion, String premio, int cantidadDefensa, float porcentajeDefensa, int cantidadAtaque, float porcentajeAtaque) {
        this.descripcion = descripcion;
        this.premio = premio;
        this.cantidadDefensa = cantidadDefensa;
        this.porcentajeDefensa = porcentajeDefensa;
        this.cantidadAtaque = cantidadAtaque;
        this.porcentajeAtaque = porcentajeAtaque;
    }

    public String getDescipcion(){
        return descripcion;
    }
    public String getPremio(){
        return premio;
    }
    public int getCantidadDefensa(){
        return cantidadDefensa;
    }
    public float getPorcentajeDefensa(){
        return porcentajeDefensa;
    }
    public int getCantidadAtaque(){
        return cantidadAtaque;
    }
    public float getPorcentajeAtaque(){
        return porcentajeAtaque;
    }
}
