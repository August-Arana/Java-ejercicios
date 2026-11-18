package dnd;

public class Main3 {

    public static void main(String[] args) {

        Aventurero thorin = new Aventurero("Thorin");
        Clerigo c = new Clerigo();

        c.lanzar("Curar heridas"); // imprime A, coincide con la primera firma
        c.lanzar("Curar heridas", 3); // imprime B, coincide con la segunda firma
        c.lanzar(3, "Curar heridas"); // imprime C, coincide con la tercera firma
        c.lanzar("Bendición", thorin); // para mi imprime D
        c.lanzar("Bendición", null); // igual que el caso anterior, para mi... imprime en D? pero no lo se con
                                     // certeza
        // correctas todas!
        // - 📜 La elección del método sobrecargado, ¿se decide en **compilación** o en
        // **ejecución**? (Ver la sección de correcciones al final.)
        // Para mi... se decide en ejecucion!
        // no, mal
        // la sobrecarga es tener varios metodos con el mismo nombre y distinta firma.
        // el COMPILADOR elige cual llamar en base a la firma del metodo.
        // esto se hace evidente por el caso D, donde el compilador elige D sin ejecutar
        // nada;
    }
}
