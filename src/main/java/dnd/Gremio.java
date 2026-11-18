package dnd;

import java.util.ArrayList;
import java.util.List;

public class Gremio {

    private String nombre;
    private List<Aventurero> miembros;

    public Gremio(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(Aventurero miembro) {
        if (!this.miembros.contains(miembro)) {
            // no esta anotado
            if (!miembro.tieneGremio() || miembro.getGremio() == this.nombre) {
                // pero el se anoto
                this.miembros.add(miembro);
                miembro.setGremio(this);
            }else{
                System.out.println("El aventurero esta en otro gremio, sacarlo de ahi");
            }
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void listarMiembros() {
        for (Aventurero ave : miembros) {
            System.out.println(ave.getNombre());
        }
    }
    public void hecharMiembro(Aventurero miembro){
        miembros.remove(miembro);
    }
}

/*
 * 
 * Ejercicio 10: El gremio (cardinalidad y direccionalidad)
 * Modelá estas relaciones. Para cada una, indicá la cardinalidad, la
 * direccionalidad y si es una asociación libre, una agregación o una
 * composición:
 *
 * 1. Un `Gremio` tiene muchos `Aventurero`.
 * uno a muchos
 * 2. Un `Aventurero` pertenece a un solo gremio, y además necesitás saber a
 * cuál.
 * uno a uno
 * 3. Un `Aventurero` puede haber completado muchas `Mision`, y una misión puede
 * haberla completado más de un aventurero.
 * muchos a muchos
 * 4. Un `Dado` le da un número al `Aventurero` cuando ataca (solo colaboran).
 * 
 * 
 * - Implementá la relación 2 en las dos direcciones. 💀 Cuidá que agregar un
 * aventurero al gremio deje **ambos lados** consistentes.
 * - Dibujá el diagrama UML con las flechas correctas (rombo vacío para
 * agregación, rombo lleno para composición).
 * 
 */
