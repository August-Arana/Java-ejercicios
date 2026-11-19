package dnd;

/**
 * Sala
 */
public class Sala {

    Dado dado = new Dado();

    public Sala() {
    }

    public void entrar(Personaje a) throws MazmorraException {
        int resultado = dado.tirar(20);
        int danio = dado.tirar(6);

        if (resultado < 5) {
            throw new TrampaException("Se activa una trampa de flechas!", danio);
        } else if (resultado >= 5 && resultado <= 8) {
            throw new PuertaCerradaException(
                    "La puerta del dungeon acaba de cerrarse, necesitas una llave!", "Llave calavera");
        } else {
            System.out.println("El aventurero ha entrado al dungeon");
        }
    }
}
