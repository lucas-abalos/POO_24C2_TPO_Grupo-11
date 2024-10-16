package reino.modelo;

import java.util.List;
import java.util.Scanner;

public class ZonaEnemiga extends Ubicacion{
    private Criatura enemigo;

    public ZonaEnemiga(String nombre, List<Ubicacion> adyacentes, Criatura enemigo) {
        super(nombre, adyacentes);
        this.enemigo = enemigo;
    }
// posible implementacion
//    public void pelea(Heroe heroe) {
//        if (enemigo.estaVivo()) {
//            Pelea pelea = new Pelea(heroe, this.enemigo);
//        }
//    }


    public Criatura getEnemigo() {
        return enemigo;
    }
}
