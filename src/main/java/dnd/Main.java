package dnd;

public class Main {

    public static void main(String[] args) {
        Aventurero thorin1 = new Aventurero("Thorin", "Enano", 5, 40);
        Aventurero thorin2 = new Aventurero("Thorin", "Enano", 5, 40);
        Aventurero Legolas = new Aventurero("legolas", "Elfo", 5, 20);
        Aventurero Aragorn = new Aventurero("Aragorn", "Humano", 5, 30);

        // Predecí : ¿qué devuelve `a1 == a2`? ¿Y `a1.equals(a2)`?
        // El primero va a dar false y el segundo... tambien?
        // En ambos casos se esta comparando la direccion de memoria donde se encuentra el objeto instanciado? 
        // == compara la direccion de memoria, no el contenido. como son instancias diferentes, da false

        System.out.println("¡La aventura comienza!\n");
        System.out.println("Aventureros creados");
        System.out.println(thorin1 == thorin2);
        System.out.println(thorin1.equals(thorin2));

        // - 📜 Explicá la diferencia entre objetos **iguales** e **idénticos** usando a
        // estos dos Thorins.
        // Dos objetos iguales poseen los mismos datos internos, es decir, las variables con las que se crearon
        // dos objetos son identicos cuando son el mismo objeto.
        // esto se da por como funciona java internamente, basicamente al crear dos veces un objeto va a tener dos direcciones de memoria.
    }
}
