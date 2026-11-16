package dnd;

public class Item {

    private String nombre;
    private int peso;
    private float valor;

    public Item(String nombre, int peso, float valor){
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }

    public String getNombre(){
        return this.nombre;
    }
}
