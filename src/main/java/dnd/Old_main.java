package dnd;

public class Old_main {

    public static void main(String[] args) {
        Aventurero thorin1 = new Aventurero("Thorin", "Enano", 5, 40, 10);
        Aventurero thorin2 = new Aventurero("Thorin", "Enano", 5, 40, 10);
        Aventurero Legolas = new Aventurero("legolas", "Elfo", 5, 20, 10);
        Aventurero Aragorn = new Aventurero("Aragorn", "Humano", 5, 30, 10);

        // Predecí : ¿qué devuelve `a1 == a2`? ¿Y `a1.equals(a2)`?
        // El primero va a dar false y el segundo... tambien?
        // En ambos casos se esta comparando la direccion de memoria donde se encuentra
        // el objeto instanciado?
        // == compara la direccion de memoria, no el contenido. como son instancias
        // diferentes, da false

        System.out.println("¡La aventura comienza!\n");
        System.out.println("Aventureros creados");
        System.out.println(thorin1 == thorin2);
        System.out.println(thorin1.equals(thorin2));

        // - 📜 Explicá la diferencia entre objetos **iguales** e **idénticos** usando a
        // estos dos Thorins.
        // Dos objetos iguales poseen los mismos datos internos, es decir, las variables
        // con las que se crearon
        // dos objetos son identicos cuando son el mismo objeto.
        // esto se da por como funciona java internamente, basicamente al crear dos
        // veces un objeto va a tener dos direcciones de memoria.
        //
        //
        //

        Arma espada = new Arma("Espada larga", 8);
        Arma otra = espada;
        otra.setDanio(12);
        System.out.println(espada.getDanio()); // esto para mi va a devolver 12, ya que las dos variables estan
                                               // apuntando al mismo objeto, entonces le estamos indicando a ese objeto
                                               // que modifique su valor de danio;

        otra = new Arma("Daga", 4);
        System.out.println(espada.getNombre()); // Aca si, ahora otra comienza a apuntar a una nueva arma, pero espada
                                                // sigue a donde estaba, por lo tanto, para mi, lo que va a suceder es
                                                // que espada.getNombre va a devolver espada larga//correcto :)
                                                //
                                                //
        //
        //
        Herrero Sergio = new Herrero();

        System.out.println("Danio antes de sergio con mejorarNumero");
        System.out.println(espada.getDanio());

        Sergio.mejorarNumero(espada.getDanio()); // esto para mi no hace nada

        System.out.println("Danio despues de sergio con mejorarNumero");
        System.out.println(espada.getDanio());

        System.out.println("-----------------");

        System.out.println("Danio antes de sergio con mejorarArma");
        System.out.println(espada.getDanio());

        Sergio.mejorarArma(espada); // esto si va a dar un cambio verdadero, va a dar 5 mas que el anterior

        System.out.println("Danio despues de sergio con mejorarArma");
        System.out.println(espada.getDanio());

        System.out.println("-----------------");
        System.out.println("Danio antes de sergio con reemplazarArma");
        System.out.println(espada.getDanio());
        Sergio.reemplazarArma(espada);
        // esto para mi si va a funcionar, lo que va a terminar pasando es que la misma
        // variablo ahora va a apuntar al arma nueva, que en este caso, es el martillo
        // de guerra

        // no, eso no produce cambio ya que la funcion reemplazar solo crea un objeto
        // que es interno al metodo y este no sale por fuera del mismo, entonces no hace
        // nada realmente, lo que si hubiere funcionado es lo siguiente:
        // espada = herrero.reemplazarArma()
        // y para eso:
        // public Arma reemplazarArma(){
        // return new Arma("marti", 20);
        // }
        // y ahi si, hubiera modificado
        // public void reemplazarArma(Arma a){
        // a = new Arma("Martillo de guerra", 20); // <-- sólo cambia la copia local
        // }

        System.out.println("Danio despues de sergio con reemplazarArma");
        System.out.println(espada.getDanio());
        System.out.println(espada.getNombre());

        Mochila mochila = new Mochila();
        Legolas.setMochila(mochila);
        Item carpa = new Item("carpa", 1, 20);
        // ojo aca, fijate que lo que estas haciendo es algo muy imperativo de alguna
        // manera, el codigo aca esta agregando el item a la mochila. Nosotros en este
        // lado nos estamos metiendo en la mochila del aventurero en lugar de hacer que
        // el aventurero sea quien administre su propia mochila, dejo comentado el
        // codigo viejo.
        // Legolas.getMochila().addItem(carpa);
        // Legolas.getMochila().listarItems();
        // y ahora si, hagamos que el aventurero administre su mochila
        Legolas.agregarItemEnMochila(carpa);
        Legolas.listarItems();
        Legolas.recibirDano(100);
        if (!Legolas.estaVivo()) {
            Aragorn.setMochila(Legolas.quitarMochila());
            Aragorn.listarItems();
        }

        // ¿Por qué esto es agregación y no composición?
        // Esto es agregacion ya que un aventurero _usa_ una mochila y la mochila en si
        // misma no forma parte del aventurero, es decir, aunque el aventurero no
        // exista, la mochila si puede hacerlo de forma independiente.

        // ------------- Ejercicio 9-------------//

        // da error
        // Familiar2 cuervo = new Familiar2();

        // Familiar cuervo = new Familiar();
        Mago2 mago2 = new Mago2();

        mago2.crearFamiliar("fuego",10,"Edgardo");
        mago2.atacarConFamiliar();

        Mago mago = new Mago();

        mago.familiarAtaca();

        // Desde un `main` en otra clase, intentá `new Familiar()` en ambas versiones.
        // ¿En cuál compila y en cuál no?
        // Familiar(...) compila, pero Familiar2(...) no compila, lo cual es correcto!
    }
}
