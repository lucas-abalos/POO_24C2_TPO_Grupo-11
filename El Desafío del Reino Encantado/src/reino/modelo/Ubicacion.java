package reino.modelo;

import java.util.List;

public class Ubicacion {
    private final String nombre;
    private final List<Ubicacion> adyacentes;
    private final List<Criatura> enemigos;
    private final Tesoro tesoro;
    private Recompensa recompensa;


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

    public void vaciarEnemigos() {
        if (enemigos != null) {
            enemigos.clear();
        }
    }
    public void vaciarRecompensa() {
        if (recompensa != null) {
            recompensa = null;
        }
    }

    public boolean esPacifica(){
        return enemigos == null || enemigos.size() < 1;
    }

    public boolean esNeutral(){
        return (this.nombre.toLowerCase().contains("neutral"));
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

    public String obtenerDescripcionCompleta() {
        StringBuilder descripcion = new StringBuilder();
    
        // Nombre de la ubicación
        descripcion.append("Ubicación: ").append(nombre).append("\n");
    
        // Información sobre enemigos
        if (enemigos == null || enemigos.isEmpty()) {
            descripcion.append("No hay enemigos a la vista en esta ubicación.\n");
        } else {
            descripcion.append("Enemigos presentes: ").append(enemigos.size()).append("\n");
            for (Criatura enemigo : enemigos) {
                descripcion.append("- ").append(enemigo.getNombre())
                    .append(" (Tipo de Criatura: ").append(enemigo.getClass().getSimpleName()).append(")\n");
            }
        }
    
        // Información sobre la recompensa
        if (recompensa != null) {
            descripcion.append("Recompensa recogida: ").append(recompensa.toString()).append("\n");
        } else {
            descripcion.append("No hay recompensas en esta ubicación.\n");
        }
    
        // Información sobre el tesoro
        if (tesoro != null) {
            descripcion.append("¡Aquí se encuentra el tesoro! ").append(tesoro.devolverDescripcion()).append("\n");
        } else {
            descripcion.append("El tesoro no se encuentra en esta habitación.\n");
        }
    
        return descripcion.toString();
    }
    
    
}
