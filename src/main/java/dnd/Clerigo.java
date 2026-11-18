package dnd;

public class Clerigo {

    public Clerigo() {
    }

    void lanzar(String hechizo) {
        System.out.println("A");
    }

    void lanzar(String hechizo, int nivel) {
        System.out.println("B");
    }

    void lanzar(int nivel, String hechizo) {
        System.out.println("C");
    }

    void lanzar(String hechizo, Aventurero obj) {
        System.out.println("D");
    }

}
