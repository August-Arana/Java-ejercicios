package dnd;

public class Herrero {

    public void mejorarNumero(int danio) {
        danio = danio + 5;
    }

    public void mejorarArma(Arma a) {
        a.setDanio(a.getDanio() + 5);
    }

    public void reemplazarArma(Arma a){
        a = new Arma("Martillo de guerra", 20);
    }
}
