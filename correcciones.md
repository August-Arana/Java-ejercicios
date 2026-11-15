# Ejercicio 4

Esto es lo que escribiste para este desarrollo:

```java
package dnd;

import java.util.Map;
import java.util.HashMap;

public class Dragon {
    String color;
    String edad;
    int peso;
    int hp;
    int armor;
    int velocidad;
    Map<String, Integer> piezas = new HashMap<>();

    public Dragon(String color, String edad, int peso) {
        this.color = color;
        this.edad = edad;
        this.peso = peso;
    }

    public Dragon(String color, String edad, int peso, int hp, int armor, int velocidad) {
        this(color, edad, peso);
        this.hp = hp;
        this.armor = armor;
        this.velocidad = velocidad;
    }

    public Dragon(String color, String edad, int peso, Map<String, Integer> piezas) {
        this(color, edad, peso);
        this.piezas = piezas;
    }

    // contexto de combate
    void atacar() {
    }

    void moverse(int x, int y) {
    }

    void recibirDano() {
    }

    void curarse() {
    }

    // contexto de vender partes
    void listarPiezas() {
    }

    void venderPieza() {
    }

    void agregarPieza() {
    }
}
```

## Aca lo primero que fallo es que deberian haber sido dos clases.

Esto no se lo entendi a C, pero el modelado en contextos diferentes pasaba, de forma muy importante, por tener dos clases diferentes para los dos contextos mencionados.
Segun C, esto se hace evidente en la implementacion de dos constructores tan diferentes. Fijate que hiciste dos constructores para dos entornos distintos y esto ya esta hablando de que, en realidad, deberias haber tenidos dos clases.

## Firmas incompletas

El ejercicio pedia las firmas de los metodos, vos pusiste los metodos, pero te faltaron los parametros. Esto importa porque los parametros son parte de la firma de los metodos.

## Mapeo de piezas... raro

Primero, el mapeo es ambiguo, tenes un string y un int que no describen mucho mas nada.
Luego tenes esto:


this.piezas = piezas;

y aca, como sospechabas, tenes algo no analizado. Este dragon esta haciendo composicion, fijate que le tienen que pasar una lista externa de las piezas, no es que el dragon se crea con la lista. Si quisieras que el dragon tenga su propia lista tendrias que haber hecho algo asi en su lugar:

this.piezas = new hashMap<>(piezas)

## Te olvidaste los atributos de privacidad, todos

no pusiste private String...


