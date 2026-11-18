package dnd;

public class TrampaException extends MazmorraException {

    private final int danio;
    /*
     * final, algo importante
     * algo que acabo de aprender es que en las clases PODES tener un atributo
     * final, pero el tema es que ese final se tiene que declarar y explicitar en
     * todos los constructores si no tiene un valor inicial asignado en la
     * declaracion
     * por eso antes no te funcionaba y no entendias porque sucedia
     * esto sirve para evitar cambiar el valor de la variable, fijate que ni
     * siquiera el propio objeto lo va a poder cambiar y por eso no tiene sentido
     * que haya setters, es mas de hecho si los hay, no compila!
     * una vez creado el objeto, ya esta, tiene un atributo inmutable;
     *
     * Finalmente:
     * una exception describe algo que ya paso, y es por esto que los hechos no
     * deberian poder ser modificables, por eso usas constantes!
     */

    public TrampaException() {
        super();
        this.danio = 0;
    }

    public TrampaException(String mensaje) {
        super(mensaje);
        this.danio = 0;
    }

    public TrampaException(Throwable cause) {
        super(cause);
        this.danio = 0;
    }

    public TrampaException(String mensaje, Throwable cause) {
        super(mensaje, cause);
        this.danio = 0;
    }

    public TrampaException(String mensaje, int danio) {
        super(mensaje);
        this.danio = danio;
    }

    public int getDanio() {
        return this.danio;
    }
}
