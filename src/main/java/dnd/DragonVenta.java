package dnd;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DragonVenta {

    private Map<String, Integer> listaPiezasPrecio;
    private String edad;
    private String raza;

    public DragonVenta(String edad, String raza) {
        this.edad = edad;
        this.raza = raza;
        this.listaPiezasPrecio = new HashMap<>();
    }

    void venderPieza(String pieza) {
    }

    void agregarPieza(String pieza) {
    }

    List<String> listarPiezas() {
        return new ArrayList<>(listaPiezasPrecio.keySet());       
    }
}
