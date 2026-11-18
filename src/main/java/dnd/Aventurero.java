package dnd;

import java.util.ArrayList;
import java.util.List;

public class Aventurero {
    private String nombre;
    private String raza;
    private int nivel;
    private int hp;
    private int max_hp;
    private int strength;
    private int strength_mod;
    private Mochila mochila;
    private Gremio gremio;
    private List<Mision> misionesCompletadas;


    public Aventurero(String nombre, String raza, int nivel, int hp, int strength) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.hp = hp;
        this.max_hp = hp;
        this.strength = strength;
        this.strength_mod = (strength - 10) / 2;
        this.misionesCompletadas = new ArrayList<Mision>();
    }

    void recibirDano(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println("El personaje ha muerto");
        }
    }

    // ¿Por qué `recibirDanio` es mejor que un `setHp` público? Relacionalo con
    // **encapsulamiento** y **ocultamiento de información**.
    // Es mejor que un setHP publico ya que nos aseguramos que sea el propio objeto
    // el cual modifica sus datos, ademas el metodo protege las reglas del objeto al
    // ejecutarse, un setHP me permite hacer cualquier cosa. Recibir danio valida.
    // Lo de encapsulamiento se relaciona en el sentido de que el dato del hp es
    // propio de la clase y mediante el metodo recibirDanio
    // tengo el dato + el metodo_del_dato y eso es la encapsulacion.
    // Lo de ocultamiento de la informacion se da en que no mostramos la logica
    // interna de los metodos para el exterior.

    void heal(int healing) {
        this.hp += healing;
        if (this.hp > this.max_hp) {
            this.hp = this.max_hp;
        }
    }

    boolean estaVivo() {
        return this.hp > 0;
    }

    // - Esto es el ejemplo de la "edad" de tus notas. ¿Qué es lo que queda
    // oculto? ¿Qué gana quien usa la clase?
    // Lo que gana quien usa la clase es que no tiene el codigo acoplado, por lo
    // tanto,
    // al usuario de la clase no le importa como internamente la clase incorpora el
    // codigo
    // o si calcula o guarda el valor, lo importante es que lo devuelve y listo

    // version 1
    int getStrMod_V1() {
        return (int) Math.floor((this.strength - 10) / 2);
    }

    // version 2
    int getStrMod_V2() {
        return strength_mod;
    }

    void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    void agregarItemEnMochila(Item item) {
        if (this.mochila != null) {
            this.mochila.addItem(item);
        } else {
            System.out.println("El aventurero no tiene una mochila puesta");
        }
    }

    void listarItems() {
        if (this.mochila != null) {
            this.mochila.listarItems();
        } else {
            System.out.println("El aventurero no tiene una mochila puesta");
        }
    }

    void quitarItemDeMochila(Item item) {
        if (this.mochila != null) {
            this.mochila.removeItem(item);
        } else {
            System.out.println("El aventurero no tiene una mochila puesta");
        }
    }

    Mochila quitarMochila() {
        Mochila estaMochila = this.mochila;
        this.mochila = null;
        return estaMochila;
    }

    public void setGremio(Gremio gremio) {
        if (!tieneGremio()) {
            this.gremio = gremio;
            gremio.agregarMiembro(this);
        } else {
            if (this.gremio == gremio) {
                return;
            } else {
                System.out.println("El aventurero se encuentra en otro gremio, primero debe abandonar el corriente");
            }
        }
    }

    public Boolean tieneGremio() {
        return !(this.gremio == null);
    }

    public String getGremio() {

        String gremio;

        if (this.gremio != null) {
            gremio = this.gremio.getNombre();
        } else {
            gremio = "El aventurero no esta en ningun gremio";
        }
        return gremio;
    }

    public void abandonarGremio() {
        this.gremio.hecharMiembro(this);
        this.gremio = null;
    }

    public void agregarMision(Mision completada) {
        this.misionesCompletadas.add(completada);
    }

    public void mostrarCompletadas() {
        for (Mision mision : misionesCompletadas) {
            System.out.println(mision.getNombre());
        }
    }

    public String getNombre() {
        return this.nombre;
    }
}
