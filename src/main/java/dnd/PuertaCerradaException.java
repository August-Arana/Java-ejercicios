package dnd;

public class PuertaCerradaException extends MazmorraException {
    // PuertaCerradaException → atributo String llaveNecesaria

    private final String llaveNecesaria;

    public PuertaCerradaException() {
        this.llaveNecesaria = "";
    }

    public PuertaCerradaException(String mensaje) {
        super(mensaje);
        this.llaveNecesaria = "";

    }

    public PuertaCerradaException(Throwable cause) {
        super(cause);
        this.llaveNecesaria = "";
    }

    public PuertaCerradaException(String mensaje, Throwable cause) {
        super(mensaje, cause);
        this.llaveNecesaria = "";
    }

    public PuertaCerradaException(Throwable cause, String llaveNecesaria) {
        super(cause);
        this.llaveNecesaria = llaveNecesaria;
    }

    public PuertaCerradaException(String mensaje, String llaveNecesaria) {
        super(mensaje);
        this.llaveNecesaria = llaveNecesaria;
    }

    public String getLlaveNecesaria() {
        return this.llaveNecesaria;
    }

}
