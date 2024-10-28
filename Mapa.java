import java.util.List;
import java.util.Scanner;

public class Mapa {
    private Ubicacion actual;
    private List<Ubicacion> ubicaciones;

    public Mapa(Ubicacion actual, List<Ubicacion> ubicaciones) {
        this.actual = actual;
        this.ubicaciones = ubicaciones;
    }

    public void agregarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicaciones.add(nuevaUbicacion);
    }


    public void viajar(){
        System.out.println("A donde quieres viajar?");
        this.actual.verViajes();
        Scanner myObj = new Scanner(System.in);
        int destino = myObj.nextInt();
        this.viajarAUbicacion(destino);

    }

    private void viajarAUbicacion(int opcion) {
        Ubicacion destino = this.actual.Viajar(opcion);
        if (destino != null) {
            this.actual = destino;
            System.out.println("Viajaste a " + destino.getNombre() + "!");
        } else {
            System.out.println("No se puede viajar a " + destino.getNombre() + " desde aqui");
        }
    }

    public List<Ubicacion> getUbicaciones() {
        return this.ubicaciones;
    }
}
