package dnd;

public class DragonCombate {

    private int hp;
    private int armor;
    private int speed;
    private int ataque;
    private String raza;
    private String edad;
//  ¿Qué atributos u operaciones aparecen en un contexto y no en el otro? ¿Por qué tus notas dicen que el contexto es el factor más importante al abstraer?
//  El de combate tiene habilidades, obviamente, relacionadas al propio sistema de combate de DnD
//  El otro es mas un sistema de comercio y no tiene, por ejemplo, un atributo de vida
//  Abstraer es quedarse con lo esencial y segun las notas, lo esencial lo define el propio contexto. Fuera de un contexto, no hay forma de saber que es lo importante y que es ruido

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
