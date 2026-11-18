package dnd;

public class Familiar {

    private String tipo;
    private int hp;
    private String nombre;

    public Familiar(String tipo, int hp, String nombre) {
        this.tipo = tipo;
        this.hp = hp;
        this.nombre = nombre;
    }

    public void atacar() {
        System.out.println("Familiar clase ataca");
    }
}
