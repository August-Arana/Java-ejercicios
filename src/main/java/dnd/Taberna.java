package dnd;

import java.util.List;

public class Taberna {
    private List<String> clientes;
    private int oro;

    public void servirCerveza(String cliente) {
    }

    public void cobrar(String cliente, int monto) {
    }
}


//  Identificá qué responsabilidades **no** le corresponden a una taberna.
//  tirarDado20
//  calcularDanioDeEspada
//  imprimirMapaDeLaMazmorra
//  para mi esas no le corresponden como responsabilidades
//
// Explicá qué pasa con el **acoplamiento** si `Taberna` necesita tirar dados. ¿Puede ser cero?
// no, no puede ser cero, ya que _algo_ de otro codigo va a necesitar, es decir, puede llamar a lo que implementa la clase Dado, y ahi existe un acoplamiento chico, pero no igual a cero.
