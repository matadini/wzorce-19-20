package pl.sda.wzorce.behawioralne.templatemethod.zadanie;

// napisz algorytm bazowy dla tanca ktory bedzie zawierac
// metode dance() z wywolaniem metod:
// stepA - system.out.pr... klasniecie
// stepB - abstrakcyjna
// stepC - obrot
// stepD - abstrakcyjna
// utworz klasy dziedziczace np. TaniecCzeski, TaniecPolski
// ktore beda uzupelniac stepB i stepC, zaprezentuj dzialanie TancaPolskiego i czeskiego na ekranie

public class TemplateMethodTask {
    public static void main(String[] args) {
        PolskiTaniec polskiTaniec = new PolskiTaniec();
        CzeskiTaniec czeskiTaniec = new CzeskiTaniec();

        polskiTaniec.dance();
        czeskiTaniec.dance();
    }
}

abstract class Taniec {

    void dance() {
        stepA();
        stepB();
        stepC();
        stepD();
    }

    protected void stepA() {
        System.out.println("klasniecie");
    }

    protected abstract void stepB();

    protected void stepC() {
        System.out.println("obrot");
    }

    protected abstract void stepD();
}

class PolskiTaniec extends Taniec {

    @Override
    protected void stepB() {
        System.out.println("dwa kroki w prawo");
    }

    @Override
    protected void stepD() {
        System.out.println("dwa kroki w lewo");
    }
}

class CzeskiTaniec extends Taniec {

    @Override
    protected void stepB() {
        System.out.println("krok w tyl");
    }

    @Override
    protected void stepD() {
        System.out.println("dwa salta i piruet");
    }
}
