package dnd;

public class Personaje {

    private String nombre;
    private int hp;
    private int nivel;

    public Personaje() {

    }

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje(String nombre, int hp, int nivel) {
        this.nombre = nombre;
        this.hp = hp;
        this.nivel = nivel;
    }

    public void atacar() {
        System.out.println("ataca con punios");
    }

    public void presentarse() {
        System.out.println("Hola mi nombre es " + this.nombre);
    }

}
