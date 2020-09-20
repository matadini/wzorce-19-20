package pl.sda.wzorce.behawioralne.templatemethod.zadanie;


// napisz algorytm bazowy dla tanca ktory bedzie zawierac
// metode dance() z wywolaniem metod:
// stepA - system.out.pr... klasniecie
// stepB - abstrakcyjna
// stepC - obrot
// stepD - abstrakcyjna
// utworz klasy dziedziczace np. TaniecCzeski, TaniecPolski
// ktore beda uzupelniac stepB i stepC, zaprezentuj dzialanie TancaPolskiego i czeskiego na ekranie




 abstract class taniec {

     void stepA(){ System.out.println("klaśnięcie"); }

     protected abstract void stepB();

     void stepC(){ System.out.println("obrot"); }

     protected abstract void stepD();


    void dance(){

        stepA();
        stepB();
        stepC();
        stepD();

    }

}

class TaniecPolski extends taniec{
    @Override
    protected void stepB() {
    System.out.println("Przejście");
    }

    @Override
    protected void stepD() {
    System.out.println("Ukłon");
    }
}

class TaniecCzeski extends taniec{


    @Override
    protected void stepB() {
    System.out.println("szpagat");
    }

    @Override
    protected void stepD() {
    System.out.println("prosko");
    }
}

public class TemplateMethodTask {
    public static void main(String[] args) {
        TaniecPolski taniecPolski = new TaniecPolski();
        TaniecCzeski taniecCzeski = new TaniecCzeski();

        taniecPolski.dance();
        taniecCzeski.dance();
    }
}
