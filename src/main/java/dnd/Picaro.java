package dnd;

public class Picaro extends Personaje {

    private Boolean estaEscondido;

    public Picaro(String nombre, int hp, int nivel) {
        super(nombre, hp, nivel);
        this.estaEscondido = false;
    }

    public void esconderse() {
        this.estaEscondido = true;
    }

    @Override 
    public void atacar() {
        if (estaEscondido) {
            System.out.println("Ataque furtivo x2!");
        } else {
            super.atacar();
        }
    }

}
