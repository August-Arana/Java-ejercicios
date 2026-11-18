package dnd;

public class Mago extends Personaje {

    private String name;
    private int hp;
    private int mana;
    private String color;
    private final Familiar cuervo = new Familiar("Volador",10,"Majestic");
    //private -> desde afuera no se accede
    //final -> no se puede re asignar
    //static ->

    public Mago() {

    }
    public Mago(String name) {
        super(name);
    }

    @Override 
    public void atacar(){
        System.out.println("Lanza un proyectil magico");
    }
    
    public void lanzarHechizo(){
        // Lanzar hechizo
    }

    public void familiarAtaca(){
        this.cuervo.atacar();
    } 

}
