package dnd;

public class Main {

    public static void main(String[] args) {
        Personaje p1 = new Guerrero("Conan", 3);
        Personaje p2 = new Mago("Elminster");

        p1.atacar(); // ¿qué versión se ejecuta? ----> se ejecuta la version de ataque de personaje
//        p1.cubrirAliado(); //                  ----> se ejecutaria la version de ataque de guerrero, para mi esto no se puede hacer. ya que en el "control remoto" de tipo personaje no tengo un boton de cubrir aliado
        ((Guerrero) p1).cubrirAliado(); //     ----> Esto si va a funcionar, porque ahora estoy casteando el tipo de puntero a guerrero y ese puntero si posee acceso al metodo cubrir aliado
        ((Guerrero) p2).cubrirAliado(); //     ----> Esto no va a funcionar, porque ahora estoy apuntando a un mago y el mago no tiene un metodo asi;
        Guerrero g = new Personaje("x"); //      ----> esto... no lo recuerdo!
         // todo guerrero es un personaje, pero no todo personaje es un guerrero;
         // dado esto, no se puede hacer esa conversion
    }

    //correcciones
    // p1.atacar esta mal lo que dije, porque el "control" tiene el boton atacar, pero cuando llega la senial de ataque, llega a guerrero y este guerrero ejecuta SU accion de atacar
    // ((Guerrero) p2).cubrirAliado(); aca:
    // compila, porque p2 es un personaje. No falla en compilacion, falla en ejecucion.
    // segun claude, esto falla porque el objeto real es un mago y un mago NO ES-UN guerrero
    // y el problema no esta en que el mago no tiene el metodo, sino que el casteo de por si no es correcto
    // una variable tipo X solo puede apuntar a un objeto que SEA-UN tipo x;
    // guerrero es un personaje, cumple
    // pero un personaje PUEDE ser un guerrero, pero no lo hace un guerrero
    // por eso esta mal
    // guerrero ES-UN personaje
    // personaje NO ES-UN guerrero;

}
