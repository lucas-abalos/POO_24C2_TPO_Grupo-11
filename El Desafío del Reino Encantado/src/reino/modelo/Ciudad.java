package reino.modelo;

import java.util.List;
import java.util.Scanner;

public class Ciudad extends Ubicacion{
    private String NPC;

    public Ciudad(String nombre, List<Ubicacion> adyacentes, String nombreNPC) {
        super(nombre, adyacentes);
        this.NPC = nombreNPC;
    }


    public String getNPC() {
        return NPC;
    }
}
