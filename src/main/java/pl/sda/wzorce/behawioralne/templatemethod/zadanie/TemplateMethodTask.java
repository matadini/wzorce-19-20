package pl.sda.wzorce.behawioralne.templatemethod.zadanie;

// napisz algorytm bazowy dla tanca ktory bedzie zawierac
// metode dance() z wywolaniem metod:
// stepA - system.out.pr... klasniecie
// stepB - abstrakcyjna
// stepC - obrot
// stepD - abstrakcyjna
// utworz klasy dziedziczace np. TaniecCzeski, TaniecPolski
// ktore beda uzupelniac stepB i stepC, zaprezentuj dzialanie TancaPolskiego i czeskiego na ekranie

abstract class Dance {

    void clap() { System.out.println("Klaśnięcie"); }

    protected abstract void addMove1();

    void rotation() {
        System.out.println("Obrót");
    }

    protected abstract void addMove2();

    void dance() {

        // klasnięcie
       clap();

        // ruch1

       addMove1();

        // obrót
        rotation();

        // ruch2
       addMove2();
    }
}

    class TaniecPolski extends Dance {
        @Override
        protected void addMove1() {
            System.out.println("Piruet");
        }

        @Override
        protected void addMove2() {
            System.out.println("Skok");
        }
    }

    class TaniecCzeski extends Dance {
    @Override
    protected void addMove1() {
        System.out.println("Skok do tyłu");
    }

    @Override
    protected void addMove2() {
        System.out.println("Skok do przodu");
    }
}

public class TemplateMethodTask {
    public static void main(String[] args) {
        Dance taniecPolski  = new TaniecPolski();
        Dance taniecCzeski = new TaniecCzeski();

        System.out.println("Taniec Polski");
        taniecPolski.dance();
        System.out.println("Taniec Czeski");
        taniecCzeski.dance();
    }
}
