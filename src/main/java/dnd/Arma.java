package dnd;

public class Arma {

    private String tipo;
    private int danio;

    public Arma(String nombre, int danio){

        this.tipo = nombre;
        this.danio = danio;

    }

    public void setDanio(int damage){
        this.danio = damage;
    }

    public int getDanio(){
        return this.danio;
    }

    public String getNombre(){
        return this.tipo;
    }
}
