package dnd;

/**
 * Mazmorra
 */
public class MazmorraException extends Exception {

    // excepciones checked:
    // capturarlas ---> catch ----> captura el error y toma una decision
    // propagarlas ---> throws ----> delega responsabilidad

    public MazmorraException() {
    }

    public MazmorraException(String mensaje) {
        super(mensaje);
    }

    public MazmorraException(Throwable cause) {
        super(cause);
    }

    public MazmorraException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

}
