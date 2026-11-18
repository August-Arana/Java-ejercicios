package dnd;

public class Mago2 {

    private String name;
    private int hp;
    private int mana;
    private String color;
    private Familiar2 cuervo;

    public Mago2() {
    }

    public void lanzarHechizo() {
        // Lanzar hechizo
    }

    public void crearFamiliar(String tipo, int hp, String nombre) {
        this.cuervo = new Familiar2(tipo, hp, nombre);
    }
    //No se puede asignar en un método común como crearFamiliar(...). Un método se puede llamar muchas veces, y eso contradice el "una sola vez". Por eso el compilador te marca error en la línea 19. esto es por el "final" en familiar 2

    public void atacarConFamiliar() {
        if (cuervo != null) {
            cuervo.attack();
        } else {
            System.out.println("El mago no posee un familiar creado");
        }
    }

    private class Familiar2 {
        // hay que poner el static para que familiar2 sea una clase perteneciente
        // exclusivamente a la clase de mago. Yo entiendo que sin el static, podriamos
        // instancias de forma independiente a mago 2
        // no, la nota anterior es incorrecta. Poner static en una clase anidada lo que
        // hace es... lo explico al reves
        // si vos no pones static, lo sucede es que la clase anidada depende
        // exclusivamente de la clase madre, es como si estuviera atada a su existencia
        // y no puede comportarse como una clase independiente.
        // ahora, si pones el static, esto se de vuelta, el static permite que la clase
        // anidado se comporte como si fuera una clase independiente y puede incluso ser
        // instanciada por cualquier lugar del codigo SI LA CLASE ES PUBLICA. Si es privada, no
        // por lo tanto, para que el ejercicio sea como quiero, lo que tengo que hacer
        // es quitar el static y mantener la clase privada
        private String tipo;
        private int hp;
        private String nombre;

        public Familiar2(String tipo, int hp, String nombre) {
            this.tipo = tipo;
            this.hp = hp;
            this.nombre = nombre;
        }

        void attack() {
            // famliliar ataca
            System.out.println("Ataque de familiar");
        }
    }

}
