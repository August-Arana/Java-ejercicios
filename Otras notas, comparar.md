# Curso objetos Java

## Clases, objetos e instancias. Estado y comportamiento

### Clases

- Son los planos sobre los cuales nosotros luego construimos

### Objetos

- Es lo que representa en software a una entidad del mundo real

### Instancias

- Una instancia es la creacion de objeto desde una clase, pues por definicion 'un objeto es una instancia de clase'.
- Cabe destacar dos objetos pueden ser iguales, pero nunca van a ser identicos. Esto es, pueden ser dos autos iguales en software pero no son el mismo auto.

## Proceso de abstracción. Encapsulamiento y ocultamiento de información

- Abstraer es modelar y lo que queremos obtener es un modelo.
- Lo que tenemos que pensar es en los modelos y en como estos interacturan entre si.
- El contexto tambien es muy importante

Esto pasa por las siguientes preguntas:

- ¿Qué modelos necesito? ¿Qué clases debo definir?
- ¿Cómo interactuarán los objetos entre sí? ¿Qué interfaz pública tendrá cada uno?
- ¿Cuál es el problema a resolver? ¿En qué contexto funcionarán mis objetos?

Donde, el contexto, es el factor mas importante, ya que afectara fuertemente la forma en la que pensemos el modelo.

No es lo mismo modelar una persona en el contexto de una clinica que en el contexto de un banco.

### Encapsulamiento

Aca planteamos, que operaciones permanecen expuestas y cuales no.

Interfaz publica: comportamientos del objeto que estan expuestos hacia otros objetos.

¿cuáles operaciones deben permanecer expuestas y cuáles no? ==> encapsulamiento y ocultamiento de la informacion.

Rebecca wirfs-Brock
Encapsulamiento: poner en la misma entidad los datos y las operaciones sobre esos datos.
En lenguajes estructurados se opera con funciones o rutinas sobre estructuras de datos, las rutinas estan en un lugar de la memoria y los datos estan en otro lugar de la memoria.

En java, encapsulamos mediante clases. Otros lenguajes pueden encapsular de otras maneras.

### Ocultamiento de la informacion

La principal idea es proveer un mecanismo controlado para acceder a los valores de los atributos de los objetos.
Entiendo que, esto significa que no deberiamos poder acceder o modificar los datos asi como asi, sino que deben existir metodos intervinientes para esto.

Antes de ver o cambiar un valor, debemos ejecutar una accion.

Fijate que se deduce que el ocultamiento de la informacion es el mecanismo mediante el cual obtenemos el encapsulamiento.

Ocultar es esconder informacion de alguna manera, no revelarla para el exterior. Asi por ejemplo, vos podes tener informacion que esta encapsulada en el objeto, pero no necesariamente va a estar escondida para el resto de los objetos (pues el dato, se puede VER Y SE PUEDE SABER)

Lo de ocultar es un poco mas enredado. Por ejemplo, en el dato de la edad, el 'como' sea el funcionamiento del objeto para decirte la edad ES LO QUE ESTA OCULTO. Pues no sabemos si lo que esta almacenado sea el numero o un calculo cuantico (exagerando...) que determina la edad del individuo mediante su fecha de nacimiento.

Asi entonces, daber el dato de la edad no te dice nada del metodo interno. Es publico, pero se revela lo menos posible del funcionamiento interno.

### Modularidad

Gracias a los conceptos de encapsulamiento y ocultamiento de la informacion, se puede lograr dividir al software en modulos intercambiables. La idea es pensar lo que termina haciendo un modulo por si mismo y lograr su independencia del resto del sistema.

Lo que esperamos es que las partes de un software puedan ser intercambiables como los repuestos de un motor.

## Acoplamiento y cohesion

La modularidad exige tener entidades de software autocontenidas o lo mas autocontenidas posible. Esto es, de forma tal que se pueden intercambiar sin afectar a otros modulos del sistema.

Una clase autocontenida es una clase que hace solo aquello para lo que fue pensada, sin meterse en el funcionamiento de otras clases. De esto se termina destilando que cada objeto puede realizar un accion hasta cierto punto, tenemos control sobre esto. Todo tiene una responsabilidad estrictamente definida.

Obs: dada la importancia del encapsulamiento y el ocultamiento de la informacion, asumimos que cada vez que queremos acceder a un valor, se debe hacer usando una operacion.

Si queremos que un objeto acceda a los atributos de otros, habra entonces al menos una operacion para acceder al valor de ese atributo.

Las clases, dentro de sus metodos pueden requerir otros objetos en algun momento. En estos casos, esas relaciones deben estar delimitadas. De aca lo anterior, es importante que una clase haga solo aquello para lo que fue pensada y no se meta en el trabajo de otras clases.

Ejemplo calculadora:
Si pudieras cambiar partes de una calculadora, que pasaria si dos partes se encargan de hacer las cuentas? Bueno, si uno se rompe se rompe toda la calculadora, pues la parte de hacer las cuentas depende de dos modulos juntos.

No nos conviene complejizar modulos. Cada uno hace su cosa, como las piezas de un auto o de una calculadora, la impresora no debe calcular. Si el fabricante de calculadores tiene varios modelos, puede entonce siempre usar el mismo modulo de pantalla en todas las calculadoras.

Modularidad => Cohesion
Mas cohesion, modulo mas autocontenido, mejor calidad de codigo.

Acoplamiento: medida de interdependencia entre las clases que interactuan en nuestro programa orientado a objetos.

Esto no solo se aplica a clases. Las clases son la unidad de encapsulamiento mas pequenias, pero lo mismo aplica a cosas mas grandes. Cuando planteamos un sistema, no debemos tampoco acoplar subsistemas.

### Relacion

Cohesion y acoplamiento siempre estan relacionados entre ellos. Idealmente: alta cohesion y bajo acoplamiento.
Es imposible tener acoplamiento 0 y cohesion absoluta, necesariamente debe existir alguna relacion entre los objetos para que el sistema funcione.

### Justificacion

Costos. Al tener componentes puedo re utilizar componentes. Con esto yo no tengo que volver a desarrollar componentes especificos de mi sistema, simplemente uso los que ya tengo desarrollados.

## Referencias, pase de Argumentos en Java

Tenemos tipos de datos primitivos y tipos de datos de referencia. En java se utilizan punteros, pero los mismos son implicitos. Es decir, no nos tenemos que encargar del trabajo con punteros, pero siempre van a estar involucrados en nuestro programa durante su ejecucion.
Ejemplo:

```java
public class Car {
    private String brand;
    private String model;
    // getters & setters
}
```

y luego:

```java
public void static main(String[] args) {
    Car c = new Car();
    c.setBrand(“Ford”);
    c.setModel(“Focus”);
}
```

Bueno, aca viene lo importante. La variable C no esta almacenando un objeto auto, sino una referencia a ese objeto. A modo de analogia, en c estamos guardando un control remoto para acceder a los metodos del auto. El objeto tiene su direccion de memoria propia, pero nosotros almacenamos un puntero hacia esa direccion, no el objeto en si mismo.

c -> objeto

Y al momento de ejecutar los metodos? como es el movimiento de la informacion? Veamoslo bien claro:

```java
public class Car {
    private String brand;
    private String model;
    private Engine engine;

    public void setEngine(Engine e) {
        this.engine = e;
    }

    public Engine getEngine() {
        return this.engine;
    }
    // other getters & setters
}

public class Engine {
    private started;

    public void start() {
        //brooom
        this.started = true;
    }

    public boolean isRunning() {
        return this.started;
    }
}
```

Luego de esto se hace un puntero en una variable x a un motor. A continuacion, se hace un setEngine de esta variable x.

Lo que termina sucediendo entonces es que this.engine en Car tiene una referencia al objeto engine, no guarda el objeto, sino que guarda una referencia al objeto.

Dicho de forma mas amigable, cada objeto, al referir a otros objetos, lo hace con un puntero, un "control remoto" de otros objetos. Lo interesante es como terminamos invocando la funcion is Running:

```java
Car c = new Car();
c.setBrand(“Ford”);
c.setModel(“Focus”);
Engine x = new Engine();
c.setEngine(x);
x.start();
c.getEngine().isRunning()
```

### Parametros

Los parametros son llamados "parametros formales" son aquellos definidos al momento de escribir codigo (los parametros de una funcion)

Los argumentos son llamados "Parametros reales" son los que se pasan a la funcion al momento de la ejecucion.

Dato de color: al resultado de una ejecucion de una operacion suele llamarse "parametro de resultado"

### Pasaje de Parametros

Esto es central a todos los lenguajes de programacion (es incluso... Basico y fundamental, lo tenes que saber bien)

#### Pasaje por valor

Al metodo o funcion se le suministran copias exactas de los valores.
Todo cambio generado en los objetos suministrados, no afectara el valor original.

Java: Esto sucede con los valores primitivos

#### Pasaje por referencia

En este caso se pasa la direccion del valor (nos referimos al mismo). Cualquier modificacion se vera reflejada en la variable original.

Entonces, a modo de recordar: Java no pasa por referencia, sino que siempre lo hace estrictamente por valor.

Ahora, lo interesante es preguntar, como es entonces que si pasa por valor, java es capaz de referir a una direccion de un objeto en vez de una copia de ese objeto?

Aca viene la parte teorica importante de java:

Java pasa el valor de la referencia

Esto implica entonces que java para objetos siempre va a provocar que los objetos externos sufran modificaciones (estas pasando el valor de la referencia, ergo, es tas practicamente dandole el objeto, pero el mismo se puede modificar porque no es una copia sino que es... el valor de la referencia)

Existen casos donde no, donde java no va a pasar objetos por valor de referencia, sino estrictamente por valor.

## Relaciones entre objetos

Los objetos se comunicac entre ellos enviandose mensajes. Cuando uno envia, le pide al otro que ejecute una operacion y el que lo ejecuto, le responde con el resultado de la ejecucion realizada.

- El mensaje tiene un payload, lo cual hace que el receptor reaccione
- Reacciona al mensaje, opera sobre la carga y devuelve el resultado -> el payload tiene los argumentos.

----> Esto es lo que se conoce como que un objeto llama a un metodo de otro objeto.

Cuando un objeto se manda mensajes con otro, denota una relacion de tipo asociacion o dependencia y de agregacion.

Un objeto puede colaborar libremente con otro para llevar a cabo una tarea

- O puede formar parte de otro para llevar a cabo esa tarea.

La relaciones se pueden clasificar en:

- Direccionalidad
  Unidireccional: Analiza la direccion de la relacion, es decir, hacia donde. No es lo mismo que el perro mueva la cola, a que la cola mueva al perro.
  Bi direccional: No son muy comunes, para cad aobjeto de un lado de la relacion le corresponde uno o mas objetos del otro lado y viceersa.

- Cardinalidad
  Cuantos objetos existen de cada lado de la relacion.

  - Uno a uno
    - Un auto tiene un solo motor, o cero motores so es que esta roto
  - Uno a muchos
    - Una persona puede tener 0 o mas autos
    - Con direccionalidad al revez, seria de muchos a uno. Un auto puede tener 0 o muchos duenios.
  - Muchos a muchos
    - para un sistema de infracciones, necesito conocer los autos de una persona, o los duenios de un auto.
kkkkk
- Ordinalidad
  Como dice el nombre, es un indicador de orden, peso e importancia de la relacion entre los objetos.

  - Importancia - Agregacion: Un objeto A 'usa' un objeto B para funcionar - Composicion: Un objeto A 'es duenio' de un objeto B y B no tiene razon de existir sin A.
    La relacion de composicion es mucho mas fuerte que la de agregacion, ya que B no tiene sentido sin el todo.

  Agregacion -> un computadora tiene un mouse
  Composicion -> un engranaje tiene dientes, los dientes por si solos no tienen sentido de existencia

### UML

unified modeling language: Es un lenguaje bastante amplio que cubre muchas cosas de sistemas, pero en la materia se usa principalmente para explicar cuestiones de desarrollo orientado a objetos.

Diagramas utilizados:

#### Clases

#### Relaciones

##### Libre

En las asociaciones libres, donde un objeto interactúa con otro, decimos que un objeto “colabora-con”.

##### Parte/todo

###### Agregacion

Por su lado, en las relaciones todo/parte (o parte/todo) hablamos de una relación de tipo “tiene-un”. Entonces, “Un auto ‘tiene-un’ motor”.
esta es relativamente debil.

###### Composicion

Si la parte se separa del todo, deja de existir.
“es-dueño-de” -> denota la fuerza de la relacion.

Las flechas denotan diferencia entre agregacion y composicion

### Relaciones en codigo java

#### Relacion de Agregacion

```java
public class Car {
    private Engine engine;  // El auto 'tiene un' motor

    // getters y setters
}

public class Engine {
     private int displacement;
     private String manufacturer;
}

```

#### Relacion de composicion

```java
private class Car {
    private String brand;
    // el auto es "duenio de" su motor y lo "crea"

    private final Engine engine = new Engine();

    // getters and setters, but not for engine attr;

    public accelerate(){
        this.engine.moreRpm();
    }
}
```

Con lo anterior, sucede que al instanciar un auto, ahi adentro se instancia el motor, por eso el motor no existe sin el auto

Aca viene algo interesante, si no usamos setters, evitamos que haya motores por fuera que le podamos dar al auto.
Si no usamos Getters, el motor nunca va a salir del auto.

Ahora, a esto que hicimos hasta ahora se le puede plantear lo siguiente: A mi nadie me evita hacer

```java
Engine e = new Engine();
```

Entonces, una aproximacion muchisimo mas purista implicaria que la clase engine exista dentro de car, es decir, tener una clase adentro de otra:

```java
public class Car {
    private String brand;
    private final Engine engine = new Engine();
    public accelerate() {
        this.engine.moreRpm();
    }

    class Engine {
        int displacement;
        Stringmanufacturer;
        void moreRpm(){
            //broooom
        }
    }
}
```

Con eso explicitamos que el motor solo va a vivir dentro del auto, interesante no?
Lo anterior se puede mostrar mas explicito:

```java
public class Test {

    public static void main(String[] args){
        Car c = new Car(); // funciona sin problemas
        Engine e = new Engine(); //compile error! Engine is not THAT accesible
    }
}
```

Todo esto tiene sentido solo si es necesario para resolver el problema.

La mayoria del codigo que se va a trabajar, lo sera en forma de agregacion, ya que, por ejemplo en un auto, puede ser necesario quitar el motor para repararlo y si, por ejemplo, el auto tiene el capo cerrado, no nos enteramos que le falta el motor y el auto no pierde su esencia, es decir, nos podemos independizar del motor.


## Constructores en java

Vamos desde el principio, un constructor es una funcion de la clase que, justamente, construye el objeto:

```java
public class car{

    public Car(){ // constructor default, o constructor vacio o implicitos
    // siempre esta presente, por mas que no lo coloquemos, el compilador lo agrega por nosotros sin avisarnos

    }
    
}
```

No tiene ni nombre ni tipo de retorno. La idea es crear constructores adicionales, que usemos por alguna razon.
"Alguna razon" significa, crear constructores diferentes que nos puedan servir para diferentes cosas

Luego de algunas pruebas: el constructor esta implicito.

Ahora, yo puedo definir constructores con parametros, pero desde el momento que hago esto, pierdo el constructor implicito y estoy obligado a escribirlo si quiero usarlo en algun momento.

Lo cual esta bien, java sabe que estoy agregando un constructor y entonces no va a agregar codigo por mi, el cual probablemente no utilice.


#### Identidad de constructores / firma del metodo:
Cada vez que se llama un 'new' nuevo, java en su runtime analiza:

- Cantidad de parametros
- Tipo de parametros
- Orden enque fueron llamados

Si hay un constructor que coincida con esto, ese es el que se ejecuta.

NO SE ANALIZA EL NOMBRE DE LOS PARAMETROS.

Dos constructores que coincidad en cantidad, tipo y orden, son identicos para java.

#### Re utilizar constructores
Al tener varios constructores, resulta que vos podes 'reciclar' los mas basicos y usarlos en los mas avanzados:

```java
public User(String name, String pass){
    this.name = name;
    this.pass = pass;
}

public User(String name, String pass, int age){
    this(name, pass);
    this.age = age;
}
```
ese "this(name, pass)" estaria llamando al constructor anterior, con lo cual podemos tener dos constructores diferentes y reciclar codigo. Importante, el llamado a un constructor anterior siempre se debe hacer en la primera linea, esto es porque en esa linea se crea un objeto nuevo, y en las siguientes lo que hacemos es agregar propiedades sobre ese mismo.


## El mecanismo de sobrecarga

### Firma de metodos
Analicemos lo siguiente:

public static int multiply(int a, int b) {}

| Number | Information             |
|--------|-------------------------|
| 1      | `public`                |
| 2      | `static`                |
| 3      | `int`                   |
| 4      | `multiply`              |
| 5      | `(int a, int b)`        |
| 6      | `{ }`                   |

#### 1 Modificador de visibilidad
Indica si el metodo es accesible a otros objetos.

#### 2 Indicador de clase
Modificador opcional, se usa para indicar cuando el metodo corresponde a una operacion de clase.
static -> metodo de clase

#### 3 Tipo de dato de retorno
Nada nuevo aqui

#### 4 Nombre del metodo

#### 5 Parametros

#### 6 Cuerpo del metodo

Teniendo la anatomia estudiada, definimos a la firma de un metodo como la forma de identificarlo mediante:

- Su nombre
- Sus parametros

Hacemos incapie en los parametros del metodo. Pues para la firma es de enorme importancia la cantidad, el tipo y el orden de parametros, pero no el nombre de cada uno. Estas dos firmas son diferentes:

```java
void someOperation(int someInt, int otherInt, boolean b)
void someOperation(int someInt, boolean b, int otherInt)
```

y estas dos son identicas:

```java
void someOperation(int someInt, int otherInt, boolean b)
void someOperation(int otherInt, int someInt, boolean b)
```

### Variantes de comportamiento
En esta seccion, lo que se hace es invitarnos a pensar inicialmente en todas las formas en las que podriamos dibujar un circulo en pantalla desde java.
Al principio podriamos pensar en varios diferentes metodos con diferentes nombres donde cada uno va a hacer algo diferente:

public void drawCircle()
public void drawCircleCentered()
public void drawCirclePosition(int x, int y)
drawCirclePositionWithColor(int x, int y, String color)

Y asi: Podriamos pensar todas las combinaciones posible? NO!

La filosofia es completamente distinta, lo que hacemos es tener un metodo con muchas diferentes versiones:

public void drawCircle (int x, int y)
public void drawCircle (int x, int y, String color)
public void drawCircle (int x, int y, String color, int radius)

Estos metodos son reciclables y, por ejemplo, para (int x, int y, String color) podemos antes basarnos en (int x, int y) (reciclando funcionalidad anterior!)

### Sobrecarga / overloading

La diferenciacion en cada metodo se da... adivina!
- Cantidad de parametros
- Tipo de parametros
- Orden de parametros

Igual que sucedia en los constructores. Estos es lo que se conoce como sobrecarga u overloading de metodos.

### Conclusion
Los objetos se comunican mandandose mensajes entre ellos, cada mensaje es un estimulo ocn un payload. Segun cual sea el payload, se va a ejecutar uno u otro metodo dentro del objeto y esto es opsible gracias al overloading. logramos que un objeto reaccione de manera diferente segun los estimulos suministrados.

En otros lenguajes esto se llama "polimorfismo de funciones" (igual comportamiento, diferente forma de llevar a cabo segun parametros).

## Garbage colection
Mas adelante TO_DO


## Herencias er interfaces
Esto es: Comportamiento heredado y comportamiento adquirido, son dos cosas diferentes

Algunas clases dentro de nuestro modelo pueden llegar a ser muy parecidas. Puede ser tambien que tengamos clases con diferencias muy marcadas, pero algun punto en comun.
Dada esta multiplicidad de factores, es necesario dar algun tipo de orden. Podemos agrupar todo lo que sea parecido y dejar aislado del resto, es decir, todos los atributos y operaciones similares, los ordenamos todos juntos de alguna manera.

Se define un orden Jerarquico, desde las clases mas abstractas, genericas y conceptuales hasta las mas concretas.

Por otro: las que especifican atributos y comportamientos.


### Relacion ES-UN
Atencion a los verbos. De a poco vamos a ver que son mas importantes las operaciones de las clases que aquello que almacena.

Aca se hace ejemplos con los perros. Podemos pensar que los perros, generalmente, tienen edad y nombre, ademas, ladran y juegan.
Distintas razas juegan y ladran (rottweiler, yorkie, caniche). Podria asumirse que si tienen y hacen todo lo que hace un perro entonces ES-UN perro.

El conjunto de operaciones publicas se conoce como la "interfaz publica" de la clase.

Analicemos algo distinto. Un profesor es un empleado y un empleado es una persona, por ende, un profesor ES UNA persona.

![Diagrama herencia perros](/home/august/Dropbox/Final Labo 1/images/)

En la imagen anterior, introducimos UML con herencia. En ese diagrama, las tres razas heredan de perro.


### Para que sirve la herencia?
Heredar es simplemente implementar codigo anterior:

```java
public class Perro {

    private int edad;
    private String nombre;

    public String ladrar(){
        return "wof";
    }
    public String jugar(){
        return "Jugar";
    }

    // Getters y Setters

}
```

Dijimos que la clase yorkie hereda de perro. Esto en el codigo es asi:

```java
public class Yorkie extends Perro {

}
```

"extends" en java lo uso para indicar herencia. Yorkie es un perro y por tanto hereda todo su comportamiento.
Ahora, atencion, heredara todos los atributos y metodos no privados. Todo lo que este definido como Private solo quedara en esa clase especificamente y no pasa a ninguna otra.

Dada la herencia entonces, sucede lo siguiente:

```java
Perro p = new Perro();
System.out.println(d.ladrar()); // < GUAU!

Yorkie y = new Yorkie();
System.out.println(y.ladrar());// < GUAU!
```
El compilador trabaja asi:
¿La operación ladrar, sin parámetros, está definida en Yorkie?
    a. Sí, entonces se compila correctamente y se puede ejecutar luego.
    b. No, intento ir a buscarla a la clase de la que extiende Yorkie, es decir, en Dog.
    c. ¿Está la operación (método) ladrar, que no recibe parámetros en Perro?
        Sí, entonces la sintaxis es correcta.
        No, intento buscarla en la clase de la que extiende Dog.

¿Está en esa clase?... Y repetir así sucesivamente hasta encontrar el método buscado
Si no esta en ninguna parte de toda la cadena de clases, entonces el codigo no se puede compilar correctamente.

Al momento de ejecucion, sucede algo similar. Este proceso se repite en cada esalon de la jerarquia y escala hasta encontrar la operacion que coincide con la firma del metodo llamado.

- Primera consecuencia: Reutilizamos codigo

### Operaciones. Interfaz publica
Lo que podemos hacer siempre es agregar operaciones a las clases que heredan. Un labrador hace todo lo que hace un perro, ladra y juega, por lo tanto ES-UN perro. Como tal, el mismo se lleva muy bien con los ninios, por tanto podemos agregarle el comportamiento cuidarNinos().
Un rottweiler podria tambien agregar el metodo cuidarCasa().

Un labrador/rottweiler es-un perro porque "cumple con la interfaz publica" de perro. Esto es importante de distinguir.

Una consecuencia de esto:

```java
    Perro p = new Perro();
    p.ladrar();
    Perro x = new Rottweiler();// Rottweiler ES UN Perro
    x.ladrar();
```

recordar que x es una variable que almacena un puntero, una referencia a un objeto que es un perro y rottweiler extiende de perro.

A lo sumo no podremos hacer x.cuidarCasa (porque no es un puntero tipo rottweiler, es un puntero tipo perro y este no tiene el metodo mencionado)

### Keyword Super
Ya vimos el uso de la palabra this() en constructores, para referenciar constructores dentro de la propia clase.
Ahora, resulta que nosotros podemos referenciar al constructor de la clase padre mediante herencia, usando super(), con o sin argumentos, tal cual era en el uso de this():

```java
public class Perro{
    public String nombre;
    
    public Perro(String nombre){
        this.nombre = nombre;
    }

    public String ladrar(){
        return super.ladrar();
    }
}

public class Rottweiler extends Perro {
    private int agresividad;

    public Rottweiler(String nombre, int Agresividad){
        super(nombre); //Esto esta llamando al constructor de Perro, fijate que la firma coincide.
        this.agresividad = agresividad;
    }
}
```

Observaciones:
- El atributo "nombre" privado en Perro no se hereda, entonces hacer:

```java
// esto es un constructor

public Rottweiler(String nombre, int agresividad) {\
    // En esta linea el compilador agregaria super() por nosotros, pero no puede hacerlo
    this.nombre = nombre;   // no compila
    this.agresividad = agresividad;
}
```
No compila

- Al definir en Perro un constructor con parametros, hemos perdido el constructor por default y este TAMPOCO puede usarse en rottweiler.
Un rottweiler antes de rottweiler es un perro, esta en su esencia. Cuando se crea un objeto asi, el compilador hace un llamado al constructor por default de la clase padre, es decir, hace un super(). Pero en Perro hemos perdido este constructor, por lo que no se puede hacer un super() en el rottweiler.
De nuevo, esto tiene sentido. Vos en Perro no tenes el constructor por default porque lo perdiste al hacer `public Perro(String nombre)`. LA CONSECUENCIA: no se puede usar super() (y no compila), pero si se puede usar super(nombre);

Alternativas? Si, dos: explicitar el constructor por default en perro o bien usar super(nombre).

Ojo, son 2 razones por las que no compila, no una sola.

Codigo correcto:

```java
public class Perro {
    private String nombre;

    public Perro () {

    }

    public Perro (String nombre) {
        this.nombre = nombre;
    }
}

public class Rottweiler extends Perro {
    private int agresividad;

    public Rottweiler (int agresividad) {
        // super() no tiene problemas aca
        this.agresividad = agresividad;
    }

    public Rottweiler (String nombre) {
        //this.nombre = nombre -> estoy repitiendo codigo! (si, hilamos muy fino)
        super(nombre); // Ahora si, uso esto, lo cual tiene sentido y es util para constructores mucho mas grandes
    }

    // sobrecarga de constructor
    public Rottweiler (String nombre, int nivelAgresividad) {
        super(nombre);
        this.agresividad = nivelAgresividad;
    }
}

```

## Sobreescritura y casteo

Volviendo al ejemplo de los perros, pensemos en un yorkie. Cuando un yorki ladra, lo hace distinto a un Rottweiler o un Husky. Como podemos marcar esa diferencia en nuestra jerarquia de clases de perros?

La idea es que cuando el Yorkie vaya a ejecutar el metodo heredado de ladrar, tendra que aplicarlo alguna modificacion. Para esto utilizamos un mecanismo llamado sobreescritura de metodos.

Todo lo que hereda de perro, puede ladrar, incluso sin escribir codigo para ello:

```java
public class Yorkie extends Perro {

}

public static void main (String[] a){
    
    Yorkie y = new Yorkie();
    y.ladrar(); // GUAU

    //ademas
    Perro p = new Yorkie();
    p.ladrar(); // GUAU

}
```

Sobreescritura es volver a escribir el metodo con la misma firma y el mismo nombre. Lo que terminamos haciendo es "pisar" el comportamiento heredado.

```java
public class Yorkie extends Perro {
    public String ladrar () {
        return "WIF WIF";
    }
}
// y en el main entonces:

public static void main (String[] a){
    Yorkie y = new Yorkie();
    y.ladrar() // WIF WIF
}
```

Entonces el compilador “piensa”: “A ver. El método ladrar, sin parámetros, ¿está definido en Yorkie?”:
1. Sí, entonces la sintaxis es correcta.
2. No, Yorkie hereda de Perro. ¿Está definido en Perro? a) Sí, entonces la sintaxis es correcta; b) No, entonces no existe el método ladrar(). La sintaxis no es correcta

Luego, es el turno de la ejecución del programa. Al momento de la ejecución, nuevamente, el runtime analiza: ¿el método ladrar sin parámetros está definido en Yorkie?
1. Sí, la ejecuto.
2. No, debo ejecutar el código que corresponde a la operación ladrar que se hereda de Perro.


### Sobreescritura y reutilizacion de codigo
Ahora, podemos pensas en un Husky. Esta raza de perros ladra de forma similar, pero estirando el ladrido:

```java
public class Husky extends Perro {
    public String ladrar() {
        return “GUAU GUAUUOOUU”;// ladra como los ladran los Huskies
    }
}
```
Pero hay algo importante para notar ahi, "GUAU" es algo que hace un perro comun. No podemos reciclar esa funcionalidad? Si! Se puede:

```java
public class Husky extends Perro {
    public String ladrar() {
        String ladrido = super.ladrar();
        return ladrido + " GUAUUOOUU";
    }
}
```

Para un rottweiler podemos hacer una sobreescritura diferente:

```java
public class Rottweiler extends Perro {
    public String ladrar() {
        return super.ladrar() + " GRRR"
    }
}
```

Entonces, todo el main quedaria una cosa asi:

```java
public static void main (String[] args){
    Yorkie y = new Yorkie()
    Husky h = new Husky()
    Rottweiler r = new Rottweiler()

    System.out.println(y.ladrar()) // GUAU
    System.out.println(h.ladrar()) // GUAU GUAUUOOUU
    System.out.println(r.ladrar()) // GUAU GRRR
}
```

### Uso de la keywork 'super'
Super hace denominacion al ingles de 'superclass' que es lo que entendemos nosotros como clase padre.

Aca el apunte hace un refresh del significado de this, que se asemeja al super en el sentido de que se usa para llamar al propio objeto. El this era usado para desambiguar cuando se reciben parametros con el mismo nombre de un atributo, con lo cual nos aseguramos que el compilador entiende lo que queremos decirle.

Con super pasa algo similar:
super() -> Constructor de clase padre
super.method() -> un metodo concreto de la clase padre

La utilidad esta en evitar esto:

```java
public class Rottweiler extends Perro {
    public String ladrar() {
        return ladrar() + " GRRRR"; // Recursion infinita!
    }
}
```

Pero con super...
```java
public class Rottweiler extends Perro {
    public String ladrar() {
        return super.ladrar() + " GRRR"
    }
}
```

## Exceptions in Java

Las excepciones son un mecanismo utilizado para evitar llegar a errores. De una excepcion yo me puedo recuperar, de un error ya no, el error es mucho mas grave y critico que la excepcion. Entonces, un correcto manejo de excepciones me permite:

- Tener un codigo mas robusto y confiable
- Administrar los errores y recuperarme de ellos
- Separacion de responsabilidades. Puedo separar la logica de errores del curso normal del programa
- Reporte de errores mas limpio

### Checked and unchecked exceptions

Checked => Son excepciones que el compilador te obliga a administrar. si un methodo tira una checked exception, debes hacer un catch de ella o delcarar que tu methodo la arroja.

Unchecked => Son excepciones que el compilador no requiere que vos administres. Son tipicamente errores de programacion.

#### Checked Exceptions
A continuacion se muestra como se puede incorporar esto con un ejemplo muy plano en checked exceptions

```java
// Option 1
public void unMetodoQuePuedeFallar() throws otraCheckedException {
    try {
        // codigo que podria lanzar la excepcion
    } catch(miCheckedException e) {
        // Atrapo y manejo una nueva excepcion
        throw new otraCheckedException();
    }
}

// Option 2
public void unMetodoQuePuedeFallar(){
    try{
        // Codigo que puede lanzar un achecked exception
    }catch(miCheckedException e){
        // Atrapo y administro
        this.mailClient.enviarMail("soporte@abc.com", "Error!");
    }
}

// Option 3
public void unMetodoQuePuedeFallar() throws MiCheckedException {
    // Codigo que puede tirar exception
    // en este caso no hago nada, solo 
    // aviso al llamador de la eventual excepcion
}
```

#### Unchecked Exceptions

Las opciones son excatamente las mismas. En el caso de las unchecked no estamos obligados a poner ni el try ni el catch, pero si queremos hacerlo, podemos usar cualquiera de las tres opciones anteriores.
De no hacerlo, todo se reduce a lo siguiente:

```java
public void unMetodoQuePuedeFallar(){
    // Codigo que puede lanzar unchecked exception
}
```

Como no estoy obligado a chequear ni manejar, puedo seguir todo como si no hubiera ninguna problema

### Mejor opcion
La mejor? Depende de:
- El negocio
- El problema que queremos resolver
- El grado de control que queremos tener sobre las eventualidades

### Construir nuestras propias excepciones

Se extiende Exception o RuntimeException:

```java
public class BebidaException extends Exception{
    //...
}

public class SinGasException extends BebidaException{
    //...
}

public class TemperaturaException extends BebidaException{
    //...
}

// Sobreescribir los 4 constructores mas comunes:
// - No es obligatorio, porque siempre esta el constructor por default

public BebidaException(){
    // Constructor por Default
}

public BebidaException(String message){
    super(message); //Creo una excepcion con un mensaje
}

public BebidaException(Throwable cause){
    // Creo una excepcion, e indico que la provoco
    // por eso el argumento es un Trowable
    super(cause)
}

public BebidaException(String message, Throwable cause){
    // Esta el mensaje de esta excepcion y que la provoco
    super(message, cause);
}
```

#### Ejemplo de manejo y uso

```java
public void consumirBebida() throws SingGasException, TemperaturaException{
    if(this.gas < 100) {
        throw new SinGasException();
    }
    if(this.temperatura > 20) {
        throw new TemperaturaException();
    }
}
```
Y a continuacion, algo interesante con herencia!

```java
public void consumirBebida() throws BebidaException {
    if(this.gas < 100){
        throw new SinGasException(); //SinGasException es una bebidaException
    }
    if(this.temperatura > 20){
        throw new TemperaturaException(); // TemperaturaException es una BebidaException
    }
}
```

## Apunte excepciones (mas completo)

A modo de repaso, esta es la incorporacion de una excepcion:
```java
public void readSomeText(String path) throws FileNotFoundException{
    FileReader fr = null;
    try{
        File f = new File(...);
        FileReader fr = new FileReader(f);
    }catch(FileNotFoundException e){
            System.out.println("No file found at " + path);
            throw e;
    } finally {
        fr.close(); // we free resources
    }
}
```

### Excepciones propias
Si hacemos tanto chequeadas como no chequeados, senializamos errores que se consideran fuera del camino feliz. Ademas, es interesante no estar limitado a las excepciones que java nos brinda de forma vanilla.

Utilizar herencia nos da una relacion es-un. entonces para crear cualquier excepcion, como viste antes:

```java
// Checked
public class MyCustomCheckedException extends Exception {
    // ...
}

// Unchecked
public class MyCustomUncheckedException extends RuntimeException {
    // ...
}
```

DESDE AHORA podes usar ambas.

Las excepciones son clases, podemos incluir atributos y metodos que nos sean de utilidad para trabajar en esa excepcion.

Creemos una excepcion chequeada con un codigo que indica la naturaleza del problema:
```java
public class CustomCodeException extends Exception{
    private int code;
    public CustomCodeException(int code) {
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
}

// Entonces para usar esta exception hacemos:
public void readSomeText(String path) throws CustomCodeException{
    FilerReader fr = null;
    try {
        File f = new File(path);
        fr = new FileReader(f);
        // ...
    } catch (FileNotFoundException e){
        throws new CustomCodeException(1001);
    } finally {
        try {
            fr.close();
        } catch (IOException e){
            // nothing
        }
    }
}
```

todas las excepciones al extender de exception heredan la posibilidad de contener dos cosas fundamentales:
- Un mensaje que se puede usar para transmitir informacion adicional
    Cada vez que se muestra un error, se muestra un mensaje. Ejemplo en casteo de perros anterior:
    "Exception in thread "main" java.lang.ClassCastException: **Perro cannot be cast to Rottweiler**
        at Test.main(Test.java:15)"
    **Perro cannot be cast to Rottweiler** es el mensaje adosado a la excepcion.
    Siempre podemos acceder a getMessage() para ver el mensaje, si es que al momento de lanzar la excepcion elegimos incluir un mensaje.
- La causa de la excepcion.
    La causa de una excepcion es tipicamente otra excepcion. Estrictamente, la causa es un throwable. Utilizar la causa, al
    momento de lanzarla, ayuda a identificar mas facilmente el problema.

#### Ejemplo de error:
CustomCodeException
at Test.readSomeText(Test.java:39)
at Test.main(Test.java:27)
Caused by: java.io.FileNotFoundException: /home/user/data.txt (No
such file or directory)
at java.io.FileInputStream.open0(Native Method)
at java.io.FileInputStream.open(FileInputStream.java:195)
at java.io.FileInputStream.<init>(FileInputStream.java:138)
at java.io.FileReader.<init>(FileReader.java:72)
at Test.readSomeText(Test.java:37)
... 1 more

**Caused By** es lo que nos ayuda a encontrar el problema mas facilmente.

### Codigo
Tipicamente, cada vez que creamos una excepcion, se le agregan cuatro constructores tipicos, los que codeamos antes:
1. Constructor vacio
2. Constructor con mensaje
3. Constructor con causa
4. Constructor con mensaje y causa

Podemos tener atributos adicionales y entonces estos los agregariamos en los constructores que necesitemos para tenerlos en cuenta.
Con atributos privados usamos getters, pero no setters (no queremos cambiar algo sin querer).
Me voy a repetir, pero aca queda una CustomCodeException completa:
```java
public class CustomCodeException extends Throwable {
        private int code;
        public CustomCodeException(){
        }

        public CustomCodeException(String s){
            super (s);
        }

        public CustomCodeException (Throwable throwable){
            super(throwable);
        }

        public CustomCodeException(String s, Throwable throwable) {
            super(s, throwable);
            this.code = code;
        }

        public CustomCodeException (int code){
            this.code = code;
        }

        public CustomCodeException(int code, String s, Throwable throwable){
            super(s, throwable);
            this.code = code;
        }

        public int getCode(){
            return code;
        }
}
```


Y este es un ejemplo de como se usaria en un main:

```java
public class Test {
    public void readSomeText(String path) throws CustomCodeException{
        FileReader fr = null;
        try {
            File f = new File(path);
            fr = new FileReader(f);
        } catch (FileNotFoundException e){
            // contructor con codigo, mensaje y causa:
            throw new CustomCodeException(1001, 'no file at ' + path, e); // throw te lo arroja
        } finally {
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStacTrace();
            }
        }
    }
}

public static void main (String[] args){
    try{
        Test t = new Test();
        t.readSomeText("/home.../text.txt");
    } catch (CustomCodeException e) { // catch lo captura
        System.out.println("CODE: " + e.getCode()); // Aca aparece el llamado de getCode() definido en la clase
        e.printStacTrace();
    }
}

```

La utilidad de todo esto? desacoplar. Test pide leer un archivo y main nunca se entera como se lee el archivo, no es su responsabilidad.

El usuario de test pidio leer un archivo, pero quedo desacoplado de la solucion de almacenamiento.

#### Ultimo ejemplo para entender el desacoplamiento

```java
public void readSomeText(String path) throws CustomCodeException {
    File f = new File(path);
    try {
        if(f.exists()){
            this.readSomeFile(path);
        }else{
            this.readSomeCloud(path);
        }
    }catch (Exception e) {
        throw new CustomCodeException(10001, e, "no file at: " + path, e);
    }
}

public void readSomeFile (String path) throws FileNotFoundException {
    FileReader fr = null;
    try {
        File f = new File(path);
        fr = new FileReader(f);
    } catch (FileNotFoundException e){
        System.out.println(e.getMessage());
        throw e;
    } finally {
        try {
            if(fr != null) {
                fr.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

public void readSomeCloud(String path) throws MyResourceNotFoundException {
    // conectarse a AWS y leer el archivo
    // si hay problemas, lanzar MyResourceNotFoundException
}
```


## Atributos y metodos de clase y de instancia, ambientes estaticos

Todo lo que estuvimos viendo en objetos hasta ahora, lo llamamos "Atributos de instancia". Esto es, una vez que haya un objeto, este puede almacenar un valor, es decir, cada objeto tiene 'su' valor en ese atributo. Lo mismo sucede con los metodos de instancia, son metodos que se ejecutan sobre un objeto.
Hacer mencion al 'this' implica trabajar sobre el obj en el que se esta ejecutando el codigo "este" en particular, no otro.

Por otro lado, existen atributos y metodos de clase, estos trascienden al objeto. son atributos y operaciones que afectan a todo el universe de instancias de esa clase. Estos atributos y metodos de clase se los dneomina "estaticos". Se les dice asi porque no son dinamicos, no cambian en cada objeto.

### Ejemplo reactor

```java
public class ReactorNuclear {
    private String proveedor;
    private int salidaMW;
    private int temperaturaOperacion;

    // constructores
    // setters y getters
}
```

Cada vez que instalamos un reactor nuclear en el mundo, seria algo asi:

```java
public class Mundo {
    public static void main(String args) {
        ReactorNuclear r1 = new ReactorNuclear("Rusia", 1100, 280);
        ReactorNuclear r2 = new ReactorNuclear("Argentina", 1800, 230);
    }
}
```
Existe una agencia que regula la temperatura de operacion en todos los reactores. Cuando ellos dictaminan algo, esto se debe aplicar a todos los reactores del mundo.

Entonces:
```java
public class ReactorNuclear {
    public static int temperaturaSeguridad;
    private String proveedor;
    private int salidaMW;
    private int temperaturaOperacion;

    // constructores
    // setters y getters
}
```

Copn lo que seteariamos luego la temperatura interna de cada reactor, lo cual es correcto. Aun asi, queremos algo que sea mas global, sin tener que hacerlo uno por uno. la filosofia no es reglamentar reactor por reactor, sino reglamentar EL REACTOR NUCLEAR, es decir, reglamentar la clase reactornuclear. Para esto usamos los atributos estaticos.

```java
    // Some code
        ReactorNuclear.temperaturaSeguridad = 300;
    // Some more code
```

Este cambio de clase, afectara a las instancias. Los atributos de clase se pueden tambien acceder a traves de los objetos, pero esto no es recomendable, ya que puede confundir a quien este leyendo el codigo.

Ahora hay una observacion importante, porque el atributo temperatura seguridad esta como publico? Respuesta corta: por comodidad. Respuesta larga:

### Metodos de clase (Respuesta larga)
Estos no dependen de una instancia para ejecutarse. Simplemente se agrega un static al metodo y ya esta definido como de clase.
Estos metodos tienen dos funciones principales:

1. Actuar como funciones tradicionales
2. Actuar como metodos de acceso a atributos de clase

Modifiquemos y corrijamos el ejemplo anterior:

```java
public class ReactorNuclear {
    private static int temperaturaSeguridad;
    private String proveedor;
    private int salidaMW;
    private int temperaturaOperacion;

    // constructores
    // setters y getters

    public static void setTemperaturaSeguridad(int grados) {
        //this.temperaturaSeguridad = grados; // NO (*2)
        temperaturaSeguridad = grados;
    }

    public static int getTemperaturaSeguridad(){
        //return this.temperaturaSeguridad; // NO (*2)
        return temperaturaSeguridad;
    }
}
```

Usar this (\*2) no es correcto debido a que estamos lidiando con atributos y metodos de la clase. en (\*3) estamos dentro de un metodo estatico, accediendo directo al atributo estatico. Si quisieramos hacer como antes, entonces:

```java
    public static void setTemperaturaSeguridad(int temperaturaSeguridad) {
        //this.temperaturaSeguridad = grados; // NO (*2)
        ReactorNuclear.temperaturaSeguridad = temperaturaSeguridad; // no tenemos el this para desambiguar, usamos la clase!
    }
```

### Constantes
Dados los atributos estaticos, es facil definir constantes o constantes globales. Para esto se agregar el modificador final en la definicion del atributo:

```java
    public static final int TEMPERATURA_SEGURIDAD = 300;
```
1. El valor de temperatura de seguridad se establece cuando escribimos el codigo en tiempo de compilacion.
2. Como consecuencia: no hay manera de que se pueda cambiar en tiempo de ejecucion

Interesante!


### Ambientes
En un ambiente estatico no existen las instancias. Antes vimos que un metodo estatico no puede hacer uso del this, ya que no hay acceso a instancias de la clase. En un ambiente estatico no podemos acceder al mundo "no estatico".
Por el contrario, con un metodo regular, un metodo de instancia, siempre podremos acceder al contexto estatico, haciendo referencia al atributo o metodo estatido de la clase correspondiente.

#### Ambiente estatico
```java
public static int getTemperaturaSeguridad(){
    if(this.salidaMW){ //Error de comiplacion, no hay acceso al this
        return ReactorNuclear.temperaturaSeguridad;
    }
}
```

#### Ambiente de instancia
```java
    public int setTemperaturaOperacion(int tempOperacion) {
        if(tempOperacion > ReactorNuclear.temperaturaSeguridad){
            // err?
        } else {
            // ok
        }
    }
```

## Clases abstractas
### Repaso
- Gracias a la herencia podemos agrupar atributos y comportamientos en comun a ciertas clases, creando una clase padre.
- Cualquier modificacion en padre, hara que todas las subclases vean la modificacion.
- Subclases heredan todo comportamiento no privado y todo puede re definirse.

### Static y Dynamic Binding

Hay dos formas de "atar" un tipo de dato de la variable con el objeto creado que va a almacenar:
- Static binding: ocurre en tiempo de compilacion, estatico en el sentdo que se analiza la atadura sin ejecutar el programa
- Dynamic Binding: Se realiza durante la ejecucion. Se observa cuando falla el programa al momento de un casteo incorrecto, lo que obliga a usar instanceof.

Analicemos la siguiente instruccion:

public static int multiply(int a, int b) {}

Perro p = new Perro();

| Number | Information             |
|--------|-------------------------|
| 1      | `Perro P`               |
| 2      | `new Perro()`           |
| 3      | `=`                     |

1.  - Declaramos una referencia, es una variable
    - Hasta aca no se creo ningun objeto.
    - reservamos espacio para almacenar una referencia
    - p tiene un tipo de dato, puede almacenar objetos de ese tipo.
2.  - Llamamos al constructor y crea un objeto.
    - Se le indica a la VM que destine espacio suficiente en la memoria para guardar un objeto perro.
3.  - se ata la referencia al objeto
    - hacemos que la referencia apunte al objeto

Cualquier objeto que respete la premisa ES UN respecto de la referencia, puede ser apuntado por esta

P puede apuntar a cualquier perro.

Todo lo que extienda del tipo de referencia, puede ser apuntado por la misma.

Y en tiempo de ejecucion que pasa? se ejecuta el metodo correspondiente al objeto referenciado:

```java
Perro d = new Rottweiler();
d.ladrar();//ladra como un rottweiler
d = new Husky();
d.ladrar();//ladra como un husky
d = new Yorkie();
d.ladrar();//ladra como un yorkie
```

### Clases abstractas

Ver ejemplo de presentacion de perros. Todos los perros comen igual. Todos los perros ladran, pero cada uno lo hace a su manera.

La pregunta importante:

**Como representamos que el perro tiene un comportamiento "ladrar" pero solo las hijas de perro deben decir como ladrar?**

Para eso se introduce el concepto de **clase abstracta**.

Con las clases abstractas podemos definir comportamiento, QUE ES lo que debe hacer la clase, pero no definimos COMO debe hacerlo. Esto se denomina **comportamiento abstracto** y cada metodo definido por este comportamiento se llama **metodo abstracto**.

En codigo, definimos clases y comportamientos abstractos con la palabra clave "abstract". Como el comportamiento es abstracto, los metodos abstractos no tienen codigo asociado, se dice que "no tienen cuerpo":

```java
public abstract class Perro {
    public abstract String ladrar(); // No hay {}
}

```

La clase ahora tiene metodos que dicen que hacer, pero no como. Las clases abstractas parecen incompletas, como que no pudieran ejecutarse. Y esto es asi, ya que **no se pueden instanciar**. Solo pueden instanciarse hijas de esa clase.

De aca surge otro termino: **Clase Concreta** es aquella que no es abstracta.

De esta manera, podemos usar una clase abstracta como referencia, "atandole" una instancia de una clase concreta.


#### Uso de clases abstractas

```java
    public Rottweiler extends Perro {

    }
```

Y no es nada mas que eso. PERO en ese caso Rottweiler arrojara un error de compilacion. Porque no esta indicando como llevar a cabo el comportamiento que la clase Perro establece. Rottweiler esta obligado a respetar la definicion de lo que los perros hacen, debe implementar un metodo que se llame ladrar, que devuelva un string y que no reciba parametros. dicho de otra manera:

**Debe sobreescribir todos los metodos abstractos definidos en Perro**

```java
    public Rottweiler extends Perro {
        public String ladrar(){
            return "WOOF";
        }
    }
```
Y lo mismo para el resto de los perros. Las reglas de sobreescritura son las de sobreescribir la firma.

Creo util repasar lo que sucedia antes:
Antes Rott extendia de Perro y heredaba todo el copmportamiento no privado. Rottweiles es un perro porque hace lo que hacen todos los perros. En este caso pasa lo mismo, solo que siempre se debe implementar y sobreescribir lo abstracto. En si, las clases abstractas son clases como todas las otras:

```java
public abstract class Perro {
    private String nombre;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre; // correcta observacion, aca podrias haber usado tambien return nombre, sin el this.
    }

    public abstract String ladrar();
}

public Rottweiler extends Perro {
    public String ladrar() {
        return “WOOF”;
    }
}
```
Los metodos concretos en la clase abstracta son puramente existentes para reutilizacion en sus hijas. Lo mismo sucede con los constructores

Veamos un ejemplo mas:

```java
public abstract class Perro {
    private String nombre;

    public Perro(){} //   **1!!!!

    public Perro(String nombre){
        this.nombre = nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public abstract String ladrar();
}

public class Rottweiler extends Perro {
    int nivelAgresividad;

    public Rottweiler(int nivelAgresividad) {
        // llamado implicito de super();
        this.nivelAgresividad = nivelAgresividad; // MUY BIEN! Aca se usa **1, porque sin ese constructor no te va a fuincionar nada.
    }

    public Rottweiler(String nombre, int agresividad){
        super(nombre);
        this.nivelAgresividad = agresividad;
    }

    public String ladrar(){
        return "WOOF";
    }
}

```

#### Algo mas aceca de las clases abstractas y los metodos abstractos

- Si la clase tiene al menos un metodo abstracto, debe ser declarada como abstracta, sino, error de compilacion. 
- Al reves no, si la clase es abstracta, no es necesario definir un metodo abstracto.
- A veces resulta util tener una clase abstracta con el solo hecho de contener metodos para ser reutilizados, sin tener instancias de esa clase. Ejemplo "electrodomestico" con metodos comunes.
- Las clases hijas pueden sobreescribir metodos concretos a voluntad. (pero no significa que vamos a zafar de los metodos abstractos)
- La primer subclase concreta debera implementar todos los metodos abstractos.
- si NO se cumple lo anterior, entonces esa clase debe declararse como abstracta tambien


##### Clases abstractas intermedias

Pueden optar por:
- Implementar algunos metodos abstractos
- Dejar la implementacion de otros metodos abstractos para sus propias subclases

Es decir, estas clases intermeditas pueden:
- hacer concretos algunos metodos
- dejarlos abstractos
- Crear nuevos metodos abstractos

Esto da una flexibilidad enorme.

Ultimo ejemplo:

```java

public abstract class Canino {
    public abstract String ladrar();
    public abstract void jugar();
}

public abstract class Perro extends Canino {

    public void jugar(){ // implemento jugar
        System.out.println("Perro jugando con pelota");
    }

    // no implemento ladrar, lo dejo flotando como abstracto
    // compila correctamente PORQUE PERRO ES ABSTRACTO

}

public class Rottweiler extends Perro {
    // no puedo dejar metodos sin cuerpo, heredo jugar que ya esta ok entonces tengo que implementar la que falta:
    
    public String ladrar(){
        return "WOOF!";
    }
} 


```

## Interfases y polimorfismo

### polimorfismo
Esto es la capacidad de un objeto de funcionar de diversas formas; La capacidad de un objeto de comportarse como otro. Como vimos antes, un perro se puede comportar como otras especies de perros, las otras tres especies que vimos pasan la prueba de "ES un" perro. El polimorfismo no solo se da cuando usamos un objeto que hereda de otro, sucede lo mismo si el objeto polimorfico es el recibido por un metodo como parametro.

Ejemplo, a continuacion hay una funcion que recibe un objeto perro como parametro:

```java
public class Nino {
    molestarPerro(Perro p){
        System.out.println("Voy a molestar al perro");
        System.out.println(p.ladrar());
    }
}

public class Test {
    public static void main (String[] args){
        Nene n = new Nene();
        Perro d = new Rotweiler();
        Perro c = new Yorkie();

        n.molestarPerro(d); // Se escucha ladrido rottweiler
        n.molestarPerro(c); // Se escucha ladrido de un yorkie
    }
}
```

La ventaja de lo anterior es que al usar subclases de perro, no se rompe el disenio ni el codigo existente. Si el codigo usa perros, cualqueir cosa que sea un perro funcionara sin problemas.

### Contratos
Para ver en accion el polimorfismo, dependemos de la "buena conducta" del programador. Dependemos de que quien escriba el codigo conozca exactamente que metodos debe sobreescribir y como hacerlo. Esto es:
- Conocer firmas
- Tipos de retorno
- Excepciones lanzadas
- Todo

Entonces, el problema surge por el desconocimiento del programador sobre como escribir metodos en nuestro sistema. Por ejemplo, si el programador no tuviera información sobre qué métodos debe sobrescribir y por tal motivo no sobrescribirá el ladrar(), nuestro sistema Niño quedaría bastante aburrido: cada perro que el Niño moleste solo dirá “GUAU” y nada más, no notaremos cuando el niño molesta a un perro o a otro.

**Para solucionar esto?** Podemos usar documentacion, pero este es un enfoque un poco ingenuo, ya que no necesariamente el programador va a leer la documentacion y ademas, incluso si la lee, no hay nada que obligue al programador a seguir esas reglas. Podriamos meter sanciones al programador por no respetar las reglas? (Descontar algo de sueldo?) pero aun asi, lo que nos interesa es el sistema, sobretodo en tiempo de ejecucion!

POdemos asumir la exitencia de algun mecanismo que:
- Obligue al programador a sobreescribir metodos especificos
- Respetando sus firmas
- Sin depender de factores externos

Tan estricto, que hara que el codigo no compile correctamente. Para esto usamos las clases abstractas o las interfaces.

Si sobreescribimos los metodos de la superclase, lo hacemos respetando sus firmas. Con lo cual respetamos comportamiento heredado y por tanto respetamos el 'contrato' impuesto por la superclase.

**El polimorfismo solo es posible respetando los contratos**

Y para que los contratos se respeten, nuevamente, usamos definiciones de comportamiento en abstractol. Por lo tanto:

**En java definimos contratos mediante clases abstractas** mecanismo ya analizado y **Mediante interfaces** que lo analizaremos pronto.

Pero antes, analicemos un problema de los contratos y la herencia

### El problema con los contratos y la herencia

Lo que perdemos, es flexibilidad al dejar el comportamiento "Atrapado" en una jerarquia. Que pasaria si queremos definir comportamiento abstracto por fuera de la jerarquia? Que pasaria con un comportamiento tan abstracto que ni siquiera fuera parte de la super clase animal? (Citando los ejemplos que vimos antes de Husky -> Perro -> Animal)

Si quisieramos vestir() a nuestras mascotas... Como hacemos? (La gente viste a uss mascotas con ropa). Podemos incluir el comportamiento vestir() en la clase perro como una primera solucion. Pero, no todos los perros visten, porque algunos perros de campo no presentan la conveniencia de ser vestidos, estan todo el dia arreando ganado y se ensucian muy rapido.

La alternativa seria hacer el metodo vestir() abstracto (Recordar, esto es que cada clase hija defina como debe vestirse. Entonces para perros de campo definiriamos que no hay que vestirse).

###### **PERO** (Y aca aparece un GRAN pero)

Va a suceder que llege a una clase concreta de mi jerarquia de perros en donde voy a estar obligado a implementar un metodo que ni siquiera deberia tener, es decir, los perros de campo ni siquiera deberian plantearse la posiblidad de vestirse. O sea, esto vas mas alla. No es que implemento un metodo de vestimenta que "no hace nada" Y evita que el perro se vista cuando ejecute PastorAleman.vestir(), Lo correcto seria evitar de cuajo que si quiera el PastorAleman tuviera el metodo.

Y es en este punto donde aparecen los problemas.

- Podriamos implementar vestir en cada raza de perro que lo requiera... Pero empezamos a repetir codigo
- Podriamos tener herencia multiple, pero esto trae otros problemas y java solo soporta herencia simple.

Agreguemos otro supuesto: No solo los perros se pueden vestir, los gatros tambien llevan ropa,existen accesorios para loros y... los humanos tambien nos vestimos!

**Vestir()** no necesariamente es exclkusivo de los perros. y el comportamiento esta compartido por variedad de clases que corresponden a muchas jerarquias distintas.

Como hacemos?

### Solucion: Las Interfases
Son similares a las clases abstractas, se definen con "interface" en lugar de "class" y por defecto todos sus metodos son abstractos. Igual que las abstractas, las interfases no se pueden instanciar.

Para utilizarlas, utilizamos la palabra clave "implements". Aquellas clases que imlementen una interfaz qudan obligadas a darle cuerpo a todos los metodos definidos de la interfaz, de lo contrario, error de compilacion. Obtuvimos un contrato!

```java
public interface Perro {
    String ladrar();
}

public class Rottweiler implements Perro {
    // implements me va a obligar cumplir el contrato
    public String ladrar(){
        return "WOOF";
    }
}

public class Test {
    public static void main (String [] args){
        //Perro x = new Perro(); // no se puede instanciar, va a dar error
        Perro p = new Rottweiler();
        p.ladar(); // WOOF  
    }
}
```

La interfaz perro dice que deben hacer. cualquier clase que haga al menos lo que hace un perro es-un perro, con lo cual se gana el tipo de dato Perro.

Para que sirve esto? nos independizamos de las jerarquias. Gracias a este "enchufe" que nos dan las interfaces, podemos incluso mezclar cosas:

```java

public class Perro {
    public String ladrar(){
        return "WOF";
    }
}

public interface Elegante {
    String vestir();
}

public class Yorkie extends Perro implements Elegante {
    public String ladrar(){
        return "wif wif";
    }
    public String vestir(){
        return "Abrigo para perro pequenio";
    }
}

// y sigamos...

public class Persona implements Elegante {
    public String vestir(){
        return "Vestimenta y sobrero";
    }
}

public class Test {
    public static void main(String [] args){
        Elegante e = new Yorkie(); // !!!!
        System.out.println(e); // abrigo para perro chico
        e = new Persona();
        System.out.println(e); // vestimenta y sombrero
    }
}

// Podemos hacer mezclas de este estilo:

public class TestArray {
    public static void main(String[] args){
        Elegante[] arr = new Elegante[3];
        arr[0] = new Yorkie();
        arr[1] = new Persona();
        arr[2] = new Yorkie();

    for(Elegante e : arr) {
        System.out.println(e.vestir()); // todos se visten!
    }

    }
}

```

Lo anterior, es posible de ejecutar gracias al Dynamic Binding.

### Polimorfismo en Java
Las clases abstractas definen contratos y pueden ser utilizadas para el polimorfismo.  Las interfaces representan comportamiento puro, solo definen que hacer.

Dado que una clase abstracta podemos mezclar comportamiento abstracto con metodos concretos, no podemos garantizar la definicion completa de un contrato. Por esto, se dice que:

**En java solo hay polimorfismo si utilizamos interfaces**




## Tipos de datos parametricos

Esto no es exclusivo de java. Algunos lenguajes llaman a esto que veremos "Genericity" o "Generics" la cual es una herramienta muy muy util.

Esto consiste en diferir el verdadero tipo de un objeto hasta que se use. Entonces el "tipo" de un objeto se deja como un parametro mas, como si fuera un parametro del metodo que el programador establece al memnto de trabajar con el respectivo codigo a ese objeto.

Imagina que tienes una caja mágica. Esta caja puede guardar cualquier cosa: juguetes, libros, herramientas, ¡lo que sea! Pero, cuando creas la caja, no sabes qué tipo de objeto vas a guardar en ella.

Los tipos de datos paramétricos son como esa caja mágica. Te permiten definir una clase o un método que puede trabajar con diferentes tipos de datos, sin tener que escribir código separado para cada tipo.

En lugar de especificar el tipo de dato exacto cuando creas la clase o el método, usas un "parámetro de tipo". Este parámetro de tipo es como un marcador de posición que se reemplaza con el tipo de dato real cuando usas la clase o el método.


Por ejemplo, un balde puede tener diferentes liquidos por dentro:

```java
public class Balde<T> {
    private T contenido;
    public Balde(){

    }

    public void llenar (T contenido){
        this.contenido = contenido;
    }

    public T obtenerContenido(){
        return contenido;
    }
}
```

La diferencia ahora es el agregado de <T> a la clase ya conocida. Fijate que ahora el tipo de dato es un parametro.

Con esto sucede que lo que termines incorporando, te restringe el uso de tipos en eso. Ejemplo:

```java

public class Agua {
    // att
    // G y S
}

public class Combustible{
    // att
    // G y S

    public void encender(){
        //boom
    }
}


public class Test {
    public static void main (String[] args){
        Agua a = new Agua();
        Combustible c = new Combustible();

        Balde<Agua> b = new Balde<>;
        b.llenar(c) // NO COMPILA! NO puedo meter y 'mezclar' contenidos

        Balde<Combustible> danger = new Balde<>();
        danger.llenar(c);
        danger.obtenerContenido.encender(); // Boom
    }
}



```
