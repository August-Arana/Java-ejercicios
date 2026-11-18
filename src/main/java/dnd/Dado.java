package dnd;

public class Dado {

    public int tirar() {
        return tirar(20);
    }

    public int tirar(int caras) {
        return (int) (Math.random() * (caras )) + 1;
    }

    public int tirar(int cantidad, int caras) {
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += tirar(caras);
        }
        return total;
    }

    public int tirar(int cantidad, int caras, int modificador) {
        return tirar(cantidad, caras) + modificador;
    }

    // - 💀 Agregá `tirar(int caras, int cantidad)`. ¿Compila? Explicalo con la
    // definición de **firma**.
    // - 💀 Agregá `int tirar(int caras)` además de una versión `long tirar(int
    // caras)`. ¿Compila? ¿El tipo de retorno forma parte de la firma?
    //
    // agregue los dos metodos y sucede que de ambas formas, la firma del metodo es
    // la misma, por lo tanto:
    // 1 - lo que importa es el tipo de dato dentro de los parentesis, no como se
    // llame la variable
    // 2 - El tipo de dato de return no forma parte de la firma
}
