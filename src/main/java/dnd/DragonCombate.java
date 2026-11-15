package dnd;

public class DragonCombate {

    private int hp;
    private int armor;
    private int speed;
    private int ataque;
    private String raza;
    private String edad;

    public DragonCombate(int hp, int armor, int speed, int ataque, String raza, String edad) {
        this.hp = hp;
        this.armor = armor;
        this.speed = speed;
        this.ataque = ataque;
        this.raza = raza;
        this.edad = edad;
    }

    void mover(int x, int y) {
    }

    void atacar(String objetivo) {
    }

    void recibirDanio(int cantidad) {
    }

    void curar(int cantidad) {
    }
}
