package reino.modelo;

import java.util.List;

public abstract class Ubicacion {
    protected String nombre;
    protected List<Ubicacion> adyacentes;

    public Ubicacion( String nombre , List<Ubicacion> adyacentes ){
        this.nombre = nombre;
        this.adyacentes = adyacentes;
    }

    public void agregarAdyacente (Ubicacion nuevoAdyacente) {
        this.adyacentes.add(nuevoAdyacente);
    }

    public void verViajes() { 
        int contador = 1;
        for (Ubicacion destino : adyacentes) {
            System.out.println(contador + " -- " + destino.getNombre());
            contador++;
        }
    }

    public Ubicacion Viajar(int destino){
        return this.adyacentes.get(destino-1);
    }

    public String getNombre(){
        return this.nombre;
    }
    
}
