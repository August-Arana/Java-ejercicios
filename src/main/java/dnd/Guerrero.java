package dnd;

public class Guerrero extends Personaje {

    private int armadura;

    public Guerrero(String nombre, int armadura) {
        super(nombre);
        this.armadura = armadura;
    }

    public Guerrero(String nombre, int hp, int nivel, int armadura) {
        super(nombre, hp, nivel);
        this.armadura = armadura;
    }

    /*
     * Esto hubiera estado mal:
     * public Guerrero(String nombre, int armadura) {
     * this.nombre = nombre;
     * this.armadura = armadura;
     * }
     * porque nombre es un atributo privado, es decir, fijate que Guerrero hereda de
     * Personaje y lo que _estaria_ haciendo ahi, es modificar nombre, que es un
     * atributo privado de perosnaje y solo puede ser usaro por la clase personaje,
     * por eso
     * super(nombre)
     * es correcto
     *
     */

    /*
     * 
     * Como se resuelve el error que aparece?
     * el error viene de this.nombre=nombre;
     * 1) agregando el super, quitando el this.nombre=nombre;
     * 2) agregando explicitamente el contructor base public Personaje(){}, asi
     * el compilador agrega el super() invisible antes de this.nombre=nombre;
     */

    public void cubrirAliado() {
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("... y luego con su hacha!");
    }

    // - Agregá `@Override` en todos los métodos sobreescritos. 💀 Equivocate a
    // propósito en el nombre (`atacr()`) con y sin `@Override`. ¿Qué te aporta la
    // anotación?
    // la anotacion override  provoca que, si el metodo esta mal nombrado la compilacion no se lleva a cabo ya que es el propio compilador quien "ve" que este metodo deberia sobre escribir al metodo de la lase padre.
    // Si no esta presente el @Override, sucede que el programa funciona sin ninguna advertencia
    // por otro lado, si en cambio @Override esta presente, entonces el compilador previene la ejecucion del metodo

    // public void atacar() {
    // atacar();
    // System.out.println("... y luego con su hacha!");
    // }
    // [ERROR] Failed to execute goal org.codehaus.mojo:exec-maven-plugin:3.5.0:java
    // (default-cli) on project DnD: An exception occurred while executing the Java
    // class. null: StackOverflowError -> [Help 1]
    // [ERROR]
    // [ERROR] To see the full stack trace of the errors, re-run Maven with the -e
    // switch.
    // [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    // [ERROR]
    // [ERROR] For more information about the errors and possible solutions, please
    // read the following articles:
    // [ERROR] [Help 1]
    // http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
    // sin el super.atacar() lo que tenes es un atacar() lo cual equivale a this.atacar
    // entonces, terminas con una funcion recursiva, por eso te da un stack overflow error

    // Agregá `@Override` en todos los métodos sobreescritos. 💀 Equivocate a
    // propósito en el nombre (`atacr()`) con y sin `@Override`. ¿Qué te aporta la
    // anotación?
}
