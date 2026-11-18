package dnd;

import java.util.ArrayList;
import java.util.List;

public class Mision {

    private List<Aventurero> completadaPor;
    private String nombre;

    public Mision(String nombre){
        this.nombre = nombre;
        this.completadaPor = new ArrayList<Aventurero>();
    }

    public void agregarAventurero(Aventurero avent){
        this.completadaPor.add(avent);
    }

    public String getNombre(){
        return this.nombre;
    }

}
