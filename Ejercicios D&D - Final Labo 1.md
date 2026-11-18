# Ejercicios Java OOP: La Campaña de la Mazmorra

Guía de práctica basada en **"Otras notas, comparar.md"**. Son 25 ejercicios en 7 actos, más un proyecto final que integra todo.

## Cómo usar esta guía

- Hacé los ejercicios **en orden**: cada acto reutiliza clases del anterior. Armá un proyecto Java por acto, o uno solo con paquetes (`acto1`, `acto2`, ...).
- 🎲 **Predecí antes de ejecutar**: cuando un ejercicio te pide adivinar la salida o si compila, escribí tu respuesta en un comentario **antes** de correrlo. Ahí está el aprendizaje.
- 💀 **Trampa**: hay ejercicios con código que no compila o falla a propósito. El objetivo es explicar *por qué*.
- 📜 **Pregunta teórica**: respondé en 2-3 líneas con tus palabras, como si fuera el oral del final.
- Al final de cada acto hay un **checkpoint** con lo que tendrías que poder explicar sin mirar tus notas.

---

## ACTO I: Creación de personajes
*Clases, objetos, instancias, encapsulamiento y ocultamiento de información.*

### Ejercicio 1: Tu primer aventurero
Creá la clase `Aventurero` con nombre, raza, nivel y puntos de vida (`hp`).
- En un `main`, instanciá tres aventureros distintos.
- Instanciá **dos** aventureros con exactamente los mismos datos (`"Thorin", "Enano", 5, 40`).
- 🎲 Predecí y después comprobá: ¿qué devuelve `a1 == a2`? ¿Y `a1.equals(a2)`?
- 📜 Explicá la diferencia entre objetos **iguales** e **idénticos** usando a estos dos Thorins.

Hecho

### Ejercicio 2: Los puntos de vida no se tocan
Hacé privados todos los atributos de `Aventurero`.
- No hagas `setHp(int)`. En su lugar, creá `recibirDanio(int cantidad)` y `curar(int cantidad)`.
- Reglas: el HP nunca baja de 0 ni supera `hpMaximo`. Si llega a 0, `estaVivo()` devuelve `false`.
- 📜 ¿Por qué `recibirDanio` es mejor que un `setHp` público? Relacionalo con **encapsulamiento** y **ocultamiento de información**.

Hecho

### Ejercicio 3: El modificador oculto
Agregá el atributo `fuerza` (un valor entre 1 y 20) y el método `getModificadorFuerza()`.
- En D&D el modificador se calcula como `(fuerza - 10) / 2`, redondeado hacia abajo.
- **Primera versión**: guardás `fuerza` y calculás el modificador cada vez que te lo piden.
- **Segunda versión**: guardás directamente el modificador ya calculado en un atributo.
- El `main` que usa `getModificadorFuerza()` **no debe cambiar** entre las dos versiones.
- 📜 Esto es el ejemplo de la "edad" de tus notas. ¿Qué es lo que queda oculto? ¿Qué gana quien usa la clase?

Hecho

### Ejercicio 4: Modelar según el contexto
Vas a modelar un `Dragon` en dos contextos distintos. Escribí solo los atributos y las firmas de los métodos, sin implementarlos.
- **Contexto A**: un simulador de combate.
- **Contexto B**: el sistema contable de un gremio de cazadores que vende partes de dragón.
- 📜 ¿Qué atributos u operaciones aparecen en un contexto y no en el otro? ¿Por qué tus notas dicen que el contexto es el factor más importante al abstraer?

Hecho

### Ejercicio 5: Cohesión rota 💀
Te heredan esta clase:

```java
public class Taberna {
    private List<String> clientes;
    private int oro;
    public void servirCerveza(String cliente) { ... }
    public void tirarDado20() { ... }
    public void calcularDanioDeEspada(int fuerza) { ... }
    public void imprimirMapaDeLaMazmorra() { ... }
    public void cobrar(String cliente, int monto) { ... }
}
```

- 📜 Identificá qué responsabilidades **no** le corresponden a una taberna.
- Rediseñala en varias clases cohesivas (`Taberna`, `Dado`, `Arma`, `Mapa`...).
- 📜 Explicá qué pasa con el **acoplamiento** si `Taberna` necesita tirar dados. ¿Puede ser cero?

> **Checkpoint Acto I**: clase vs objeto vs instancia · igual vs idéntico · encapsulamiento vs ocultamiento · modularidad · alta cohesión y bajo acoplamiento.

---

## ACTO II: El inventario
*Referencias, pasaje de parámetros y relaciones entre objetos.*

### Ejercicio 6: Los controles remotos 🎲
Creá `Arma` con nombre y `danio`, con getter y setter de `danio`. Predecí la salida y después comprobala:

```java
Arma espada = new Arma("Espada larga", 8);
Arma otra = espada;
otra.setDanio(12);
System.out.println(espada.getDanio());   // ¿?

otra = new Arma("Daga", 4);
System.out.println(espada.getNombre());  // ¿?
```

- Dibujá en papel las variables y las flechas hacia los objetos en cada paso.

### Ejercicio 7: El hechizo de mejora 🎲
Escribí en una clase `Herrero` estos tres métodos:

```java
public void mejorarNumero(int danio)   { danio = danio + 5; }
public void mejorarArma(Arma a)        { a.setDanio(a.getDanio() + 5); }
public void reemplazarArma(Arma a)     { a = new Arma("Martillo de guerra", 20); }
```

- Llamá a cada método y después imprimí el valor original.
- 🎲 Predecí cuál de los tres modifica realmente lo que tenía el llamador.
- 📜 Usá este ejercicio para justificar la frase **"Java siempre pasa por valor; en los objetos pasa el valor de la referencia"**. El tercer método es la prueba clave: explicá por qué no reemplaza el arma.

### Ejercicio 8: Agregación: la mochila
Un `Aventurero` **tiene una** `Mochila`, y la mochila contiene una lista de `Item`.
- La mochila se crea afuera y se le asigna al aventurero con `setMochila(...)`.
- Hacé que un aventurero muera y que **otro** aventurero recoja la misma mochila (el mismo objeto).
- 📜 ¿Por qué esto es agregación y no composición?

### Ejercicio 9: Composición: el familiar del mago
Un `Mago` es **dueño de** su `Familiar` (un cuervo, un gato...). El familiar no tiene sentido sin su mago.
- **Versión 1**: `private final Familiar familiar = new Familiar(...)` dentro de `Mago`, sin getter ni setter.
- **Versión 2 (purista)**: hacé que `Familiar` sea una **clase interna privada** de `Mago`.
- 💀 Desde un `main` en otra clase, intentá `new Familiar()` en ambas versiones. ¿En cuál compila y en cuál no?
- Exponé el comportamiento del familiar solo a través del mago, por ejemplo con `mago.enviarFamiliarAExplorar()`.

### Ejercicio 10: El gremio (cardinalidad y direccionalidad)
Modelá estas relaciones. Para cada una, indicá la cardinalidad, la direccionalidad y si es una asociación libre, una agregación o una composición:
1. Un `Gremio` tiene muchos `Aventurero`.
2. Un `Aventurero` pertenece a un solo gremio, y además necesitás saber a cuál.
3. Un `Aventurero` puede haber completado muchas `Mision`, y una misión puede haberla completado más de un aventurero.
4. Un `Dado` le da un número al `Aventurero` cuando ataca (solo colaboran).

- Implementá la relación 2 en las dos direcciones. 💀 Cuidá que agregar un aventurero al gremio deje **ambos lados** consistentes.
- Dibujá el diagrama UML con las flechas correctas (rombo vacío para agregación, rombo lleno para composición).

> **Checkpoint Acto II**: referencia vs objeto · por qué Java no pasa por referencia · agregación vs composición en código · clase interna · cardinalidad y direccionalidad.

---

## ACTO III: La forja de personajes
*Constructores, sobrecarga y firma de métodos.*

### Ejercicio 11: Constructores encadenados
Dale a `Aventurero` estos constructores:
- `Aventurero(String nombre)`: nivel 1 y HP 10.
- `Aventurero(String nombre, String raza)`
- `Aventurero(String nombre, String raza, int nivel)`
- Cada uno debe reutilizar al anterior con `this(...)`. **No se puede repetir ninguna asignación.**
- 💀 Poné el `this(...)` en la segunda línea en lugar de la primera. Anotá el error y explicá por qué el compilador lo exige primero.
- 💀 Borrá todos los constructores, menos el de tres parámetros, e intentá `new Aventurero()`. ¿Por qué ya no existe el constructor por defecto?

### Ejercicio 12: El dado sobrecargado
Creá la clase `Dado` con el método `tirar` sobrecargado:
- `tirar()`: tira 1d20.
- `tirar(int caras)`: por ejemplo 1d6.
- `tirar(int cantidad, int caras)`: por ejemplo 3d6, suma los resultados.
- `tirar(int cantidad, int caras, int modificador)`: por ejemplo 2d8+3.
- Cada versión debe reutilizar a la más simple.
- 💀 Agregá `tirar(int caras, int cantidad)`. ¿Compila? Explicalo con la definición de **firma**.
- 💀 Agregá `int tirar(int caras)` además de una versión `long tirar(int caras)`. ¿Compila? ¿El tipo de retorno forma parte de la firma?

### Ejercicio 13: ¿Cuál se ejecuta? 🎲
Con estos métodos en una clase `Clerigo`:

```java
void lanzar(String hechizo)                 { System.out.println("A"); }
void lanzar(String hechizo, int nivel)      { System.out.println("B"); }
void lanzar(int nivel, String hechizo)      { System.out.println("C"); }
void lanzar(String hechizo, Aventurero obj) { System.out.println("D"); }
```

Predecí la salida de cada llamada:

```java
c.lanzar("Curar heridas");
c.lanzar("Curar heridas", 3);
c.lanzar(3, "Curar heridas");
c.lanzar("Bendición", thorin);
c.lanzar("Bendición", null);   // 💀 ¿qué pasa acá?
```

- 📜 La elección del método sobrecargado, ¿se decide en **compilación** o en **ejecución**? (Ver la sección de correcciones al final.)

> **Checkpoint Acto III**: constructor implícito y cuándo se pierde · `this(...)` · firma = nombre + cantidad, tipo y orden de parámetros · sobrecarga.

---

## ACTO IV: Clases y linajes
*Herencia, `super`, sobreescritura y casteo.*

### Ejercicio 14: La jerarquía de clases
Creá `Personaje` (nombre, hp, nivel) con los métodos `atacar()` (devuelve `"Ataca con los puños"`) y `presentarse()`.
- Creá las clases `Guerrero`, `Mago` y `Picaro`, que heredan de `Personaje`.
- `Guerrero` agrega `int armadura` y el método `cubrirAliado()`.
- `Picaro` agrega `esconderse()`.
- Probá que `new Guerrero(...).presentarse()` funciona sin haberlo escrito en `Guerrero`.

### Ejercicio 15: Los dos errores del constructor 💀
Hacé que `Personaje` tenga **únicamente** el constructor `Personaje(String nombre)`, con `nombre` privado. Después escribí esto en `Guerrero`:

```java
public Guerrero(String nombre, int armadura) {
    this.nombre = nombre;
    this.armadura = armadura;
}
```

- Tus notas dicen "son 2 razones por las que no compila". Encontrá y escribí las dos.
- Arreglalo de las **dos** formas posibles que mencionan tus notas, y explicá cuál preferís y por qué.

### Ejercicio 16: Cada clase ataca a su manera
Sobreescribí `atacar()` en cada subclase:
- `Guerrero`: `"Ataca con los puños"` + `" ... y luego con su hacha!"`, reutilizando el padre con `super.atacar()`.
- `Mago`: reemplaza todo por `"Lanza un proyectil mágico"`.
- `Picaro`: si está escondido, `"Ataque furtivo x2!"`; si no, el comportamiento del padre.
- 💀 En `Guerrero`, escribí `return atacar() + "..."` sin `super`. Ejecutalo y explicá el `StackOverflowError`.
- Agregá `@Override` en todos los métodos sobreescritos. 💀 Equivocate a propósito en el nombre (`atacr()`) con y sin `@Override`. ¿Qué te aporta la anotación?

### Ejercicio 17: El espejo del cambiaformas (casteo) 🎲
Predecí qué compila, qué falla en ejecución y qué funciona:

```java
Personaje p1 = new Guerrero("Conan", 3);
Personaje p2 = new Mago("Elminster");

p1.atacar();                       // ¿qué versión se ejecuta?
p1.cubrirAliado();                 // ¿?
((Guerrero) p1).cubrirAliado();    // ¿?
((Guerrero) p2).cubrirAliado();    // ¿?
Guerrero g = new Personaje("x");   // ¿?
```

- Escribí el método `void ordenarDefensa(Personaje p)`. Si `p` es un `Guerrero`, debe cubrir a un aliado; si no, debe imprimir que no puede. Usá `instanceof` y casteo, y que nunca lance `ClassCastException`.

> **Checkpoint Acto IV**: relación ES-UN · qué se hereda y qué no (lo privado) · `super()` vs `super.metodo()` · el `super()` implícito · sobreescritura vs sobrecarga · upcasting/downcasting · `instanceof`.

---

## ACTO V: Las trampas de la mazmorra
*Excepciones.*

##a Ejercicio 18: Excepciones propias del calabozo
Creá esta jerarquía de excepciones:

```
MazmorraException (checked, extends Exception)
├── TrampaException          → atributo int danio
└── PuertaCerradaException   → atributo String llaveNecesaria

HechizoInvalidoException (unchecked, extends RuntimeException)
```

- Cada una debe tener los **4 constructores clásicos**: vacío, con mensaje, con causa, y con mensaje y causa. Sumales constructores con sus atributos propios.
- Los atributos tienen getter pero **no** setter. 📜 ¿Por qué?

### Ejercicio 19: Explorar la sala
En la clase `Sala`, escribí `void entrar(Aventurero a) throws MazmorraException`:
- Con un 1d20 aleatorio: si sale menos de 5, lanza `TrampaException` con daño 1d6; si sale entre 5 y 8, lanza `PuertaCerradaException`; con cualquier otro valor, el aventurero entra.
- En `Mago`, `lanzarHechizo(String nombre)` lanza `HechizoInvalidoException` si el nombre está vacío.
- En el `main`:
  - Atrapá **por separado** las dos subclases de `MazmorraException`, para aplicar el daño en un caso y pedir la llave en el otro.
  - Agregá un `finally` que imprima "El aventurero sale de la sala" **siempre**.
  - 💀 Poné el `catch (MazmorraException e)` **antes** que el `catch (TrampaException e)`. ¿Qué dice el compilador?
- 📜 ¿Por qué el compilador te obliga a manejar `entrar(...)` pero no `lanzarHechizo(...)`?

### Ejercicio 20: El grimorio en la nube (causa y desacoplamiento)
`Grimorio.cargarHechizo(String nombre) throws GrimorioException` debe buscar el hechizo:
- primero en un archivo local `hechizos/<nombre>.txt`, leído con `FileReader`;
- si el archivo no existe, en una "biblioteca arcana" simulada, que lanza tu propia `BibliotecaNoDisponibleException`.
- Cualquier fallo se envuelve en `GrimorioException(codigo, mensaje, causa)`. Usá el código 1001 si falla el archivo y el 1002 si falla la biblioteca.
- Cerrá el `FileReader` en un `finally`, chequeando `null`. Después rehacelo con **try-with-resources** y compará los dos.
- En el `main`, imprimí `e.getCode()`, `e.getMessage()` y `e.getCause()`, y llamá a `e.printStackTrace()`. Buscá el **"Caused by:"**.
- 📜 ¿Por qué el `main` no debería saber si el hechizo vino de un archivo o de la nube?

> **Checkpoint Acto V**: excepción vs error · checked vs unchecked · `throw` vs `throws` · las tres opciones de manejo (relanzar otra, manejar, declarar) · `finally` · excepciones propias y sus 4 constructores · causa · desacoplamiento.

---

## ACTO VI: Las reglas del Dungeon Master
*Miembros estáticos, constantes, ambientes y binding.*

### Ejercicio 21: El reglamento universal
En la clase `Personaje`:
- `public static final int NIVEL_MAXIMO = 20;` Intentá modificarla y anotá el error.
- `private static int personajesCreados;`, que se incrementa en el constructor. Agregá `public static int getPersonajesCreados()`.
- `private static double multiplicadorExperiencia = 1.0;`, con un getter y un setter estáticos. El DM lo cambia a 2.0 en un "fin de semana de doble XP" y afecta a **todos** los personajes.
- En el setter estático, usá un parámetro con el mismo nombre que el atributo y desambiguá **sin** `this` (con el nombre de la clase).
- 💀 Dentro de `getPersonajesCreados()`, intentá leer `this.nombre` o llamar a `atacar()`. Explicá el error con la idea de **ambiente estático**.
- Al revés: desde `ganarExperiencia(int xp)`, un método de instancia, usá `multiplicadorExperiencia`. ¿Por qué esto sí funciona?
- 📜 ¿Por qué no se recomienda `thorin.multiplicadorExperiencia` aunque compile?

### Ejercicio 22: Static y dynamic binding 🎲
Armá un arreglo `Personaje[] grupo` con un guerrero, un mago, un pícaro y otro guerrero. Recorrelo y llamá a `atacar()`.
- 📜 En la línea `Personaje p = new Mago("Raistlin");`, señalá las 3 partes (declaración de la referencia, creación del objeto y la atadura) y explicá qué se decide en compilación y qué en ejecución.
- 📜 En una de tus notas, "dynamic binding" aparece asociado a fallos de casteo. Reformulalo: ¿qué es lo que realmente se decide dinámicamente?

> **Checkpoint Acto VI**: atributos y métodos de clase vs de instancia · `static final` · por qué no hay `this` en un ambiente estático · static vs dynamic binding.

---

## ACTO VII: Contratos arcanos
*Clases abstractas, interfaces, polimorfismo y genéricos.*

### Ejercicio 23: El personaje abstracto
Convertí `Personaje` en una clase **abstracta**:
- `atacar()` pasa a ser `public abstract int atacar();` y devuelve el daño.
- `presentarse()` sigue siendo concreto, porque es comportamiento compartido.
- 💀 Intentá `new Personaje("x")`.
- 💀 Creá `Bardo extends Personaje` sin implementar `atacar()`. Leé el error.
- Creá la **clase abstracta intermedia** `Lanzador extends Personaje`, que:
  - agrega `int mana` y el método abstracto `lanzarHechizo()`;
  - implementa `atacar()` como "usa el hechizo si tiene maná, si no, golpea con el bastón".
- Hacé `Mago` y `Clerigo extends Lanzador`, que solo implementan `lanzarHechizo()`.
- 📜 Verificá cada regla de tus notas con código: "si tiene un método abstracto debe ser abstracta", "una clase abstracta puede no tener métodos abstractos" y "la primera subclase concreta implementa todo lo pendiente".

### Ejercicio 24: Interfaces que cruzan linajes
Hay comportamientos que no respetan la jerarquía de `Personaje`:
- Interfaz `Volador` con `int volar(int metros)`.
- Interfaz `Lanzahechizos` con `String lanzarHechizo()`.
- Interfaz `Comerciable` con `int getPrecio()`.

Implementalas en clases de jerarquías **distintas**:
- `Mago extends Lanzador implements Volador` (con el hechizo *Volar*).
- `Dragon` (no es un `Personaje`, es un `Monstruo`) `implements Volador, Lanzahechizos`.
- `Grifo extends Monstruo implements Volador, Comerciable`.
- `PocionDeVuelo extends Item implements Comerciable`.

En el `main`:
- `Volador[] escuadron = { new Mago(...), new Dragon(...), new Grifo(...) };` Recorrelo y hacelos volar a todos.
- Escribí `int valorTotal(Comerciable[] cosas)`, que sume el precio de un grifo y de pociones mezclados.
- 📜 ¿Por qué no podías resolver `volar()` poniéndolo en `Personaje` o en `Monstruo`? Relacionalo con el problema de **vestir()** de tus notas y con que Java no tenga herencia múltiple.
- 📜 Tus notas dicen "en Java solo hay polimorfismo si utilizamos interfaces". Explicá qué quiere decir el apunte con eso, y por qué el arreglo `Personaje[]` del ejercicio 22 también se comporta polimórficamente.

### Ejercicio 25: El cofre genérico
Creá `Cofre<T>` con `guardar(T item)`, `T abrir()` y `boolean estaVacio()`.
- `Cofre<Arma> armero`, `Cofre<PocionDeVuelo> botiquin`, `Cofre<Integer> tesoro` (monedas de oro).
- 💀 Intentá `armero.guardar(new PocionDeVuelo())`. ¿En qué momento se detecta el error, en compilación o en ejecución?
- Mostrá que `armero.abrir().getDanio()` funciona **sin casteo**.
- **Versión sin genéricos**: hacé `CofreViejo` con `Object`. Mostrá que tenés que castear y que podés recibir una `ClassCastException` en ejecución. 📜 ¿Qué problema resuelven los genéricos?
- **Extra**: `Cofre<T extends Comerciable>`, con un método `int valor()` que llame a `getPrecio()` sobre el contenido.

> **Checkpoint Acto VII**: clase abstracta vs concreta · método abstracto · clases abstractas intermedias · interfaz como contrato · `implements` múltiple · polimorfismo con parámetros y arreglos · genéricos.

---

## 🐉 JEFE FINAL: El combate por turnos

Un mini juego de consola que usa **todo** lo anterior. Requisitos:

1. **Modelo**: `Personaje` (abstracta) → `Guerrero`, `Picaro`, `Lanzador` (abstracta) → `Mago`, `Clerigo`. Además, `Monstruo` (abstracta) → `Goblin`, `Dragon`.
2. **Interfaz `Combatiente`** con `int atacar(Combatiente objetivo)`, `void recibirDanio(int)`, `boolean estaVivo()` y `String getNombre()`. La implementan **tanto** los personajes como los monstruos.
3. **`Dado`** con `tirar` sobrecargado (ejercicio 12). Inyectalo por constructor (agregación) para que en los tests puedas usar un dado "trucado" que extienda `Dado` y devuelva siempre el mismo valor.
4. **`Grupo<T extends Combatiente>`** genérico, que maneje una lista de combatientes, con `estaDerrotado()` y `vivos()`.
5. **`Combate`** recibe un `Grupo<Personaje>` y un `Grupo<Monstruo>`. Alterna turnos, imprime cada acción y termina cuando un grupo queda derrotado.
6. **Excepciones**:
   - `ObjetivoMuertoException` (checked), si alguien ataca a un combatiente con 0 HP.
   - `SinManaException` (checked), que un `Lanzador` atrapa para atacar con el bastón.
   - `CombateInvalidoException` (unchecked), si se arranca el combate con un grupo vacío.
7. **Static**: `Combate.contadorTurnos` y la constante `Combate.MAX_TURNOS = 100`, que lanza una excepción si se supera.
8. **Composición**: `Mago` tiene un `Familiar` como clase interna privada, que una vez por combate le da +2 de daño.
9. **Polimorfismo real**: `Combate` **no** puede usar ni `instanceof` ni casteos. Si sentís que los necesitás, falta un método en el contrato.
10. **Encapsulamiento**: ningún atributo público salvo las constantes, y nada de setters de HP.

**Preguntas de defensa** (como si te las tomaran en el final):
- ¿Dónde hay agregación y dónde composición? Justificá cada una.
- ¿Qué relaciones hiciste con herencia y cuáles con interfaces? ¿Por qué?
- ¿Por qué el requisito 9 es una buena señal de diseño?
- Si mañana agregás `Paladin`, ¿qué clases tenés que tocar? (Lo ideal es que solo crees una nueva.)

---

## ⚠️ Correcciones a tus notas

Al leer tu resumen encontré algunas cosas que conviene corregir antes del final:

1. **La sobrecarga se resuelve en compilación, no "en runtime"** (sección de constructores). El compilador elige qué constructor o método sobrecargado usar según los tipos *declarados* de los argumentos. Lo que se decide en ejecución es qué **sobreescritura** corre (dynamic binding).
2. **"Existen casos donde Java no pasa objetos por valor de referencia"**: no. Los primitivos se copian, y en los objetos siempre se copia la referencia. No hay excepciones; el ejercicio 7 lo demuestra.
3. **`CustomCodeException extends Throwable`**: debería ser `extends Exception` (checked) o `extends RuntimeException` (unchecked). Extender `Throwable` directamente no se hace. Ese constructor además asigna `this.code = code` sin recibir `code`.
4. **`throws new CustomCodeException(...)`** dentro de un `catch`: es `throw` (la acción). `throws` va en la firma del método.
5. **En el ejemplo de `Elegante`, `System.out.println(e)`** no imprime "abrigo...". Llama a `toString()`. Debería ser `System.out.println(e.vestir())`.
6. **`Perro.ladrar()` que hace `return super.ladrar();`** en una clase sin padre explícito no compila, porque `Object` no tiene `ladrar()`.
7. **Dynamic binding**: no es "lo que se observa cuando falla un casteo". Es que en ejecución se elige el método según el **objeto real** y no según el tipo de la referencia. La `ClassCastException` es otra cosa: un casteo que el compilador permitió pero que el objeto real no cumple.
8. **Constantes**: un `static final` con un valor literal se fija en compilación, pero un `static final` también puede inicializarse en ejecución (por ejemplo, en un bloque `static`). Lo esencial es que no se puede reasignar.
9. **Garbage collection** quedó como "TO_DO". Repasá al menos qué hace que un objeto sea elegible para el recolector: que no quede ninguna referencia que llegue a él. Podés probarlo en el ejercicio 6: ¿qué pasa con la primera `Arma` si no queda ninguna variable apuntándole?
