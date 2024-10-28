package reino.modelo;

import java.util.List;

public class Ubicacion {
    private final String nombre;
    private final List<Ubicacion> adyacentes;
    private final List<Criatura> enemigos;
    private final Tesoro tesoro;
    private final Recompensa recompensa;


    public Ubicacion( String nombre , List<Ubicacion> adyacentes , List<Criatura> enemigos , Tesoro tesoro , Recompensa recompensa ) {
        this.nombre = nombre;
        this.adyacentes = adyacentes;
        this.enemigos = enemigos;
        this.tesoro = tesoro;
        this.recompensa = recompensa;
    }

    public List<Ubicacion> getAdyacentes() {
        return adyacentes;
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

    public List<Criatura> getEnemigo(){
        return this.enemigos;
    }

    public Tesoro getTesoro(){
        return this.tesoro;
    }

    public Recompensa getRecompensa(){
        return this.recompensa;
    }

    public String getNombre(){
        return this.nombre;
    }
    
}
