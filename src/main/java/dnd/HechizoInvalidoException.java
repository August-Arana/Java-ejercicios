package dnd;

public class HechizoInvalidoException extends RuntimeException {

    public HechizoInvalidoException() {
    }

    public HechizoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public HechizoInvalidoException(Throwable cause) {
        super(cause);
    }

    public HechizoInvalidoException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

}
