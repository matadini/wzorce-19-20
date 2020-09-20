package pl.sda.wzorce.behawioralne.templatemethod;


abstract class MakeCar {


    abstract void addBody();
    protected abstract void addAddons();

    void addEngine() {
        System.out.println("MakeCar: Dodaje silnik");
    }

    void addTires() {
        System.out.println("MakeCar: Dodaje opony");
    }


    void make() {

        // wez karoserie
        addBody();

        // wez silnik
        addEngine();

        // wez opony
        addTires();

        // wez wyposazenie
        addAddons();
    }

}

class MakeCarHatchback extends MakeCar {

    @Override
    void addBody() {
        System.out.println("MakeCarHatchback dodaje karoserie");
    }

    @Override
    protected void addAddons() {
        System.out.println("MakeCarHatchback dodaje radio");

    }
}

class MakeCarCombi extends MakeCar {

    @Override
    void addEngine() {
        System.out.println("MakeCarCombi daje V8 Combi");
    }

    @Override
    void addBody() {
        System.out.println("MakeCarCombi daje karoserie kombii");
    }

    @Override
    protected void addAddons() {
        System.out.println("MakeCarCombi dodaje klimatyzacje");
    }
}

public class TemplateMethodApp {
    public static void main(String[] args) {
        MakeCarCombi makeCarCombi = new MakeCarCombi();
        MakeCarHatchback makeCarHatchback = new MakeCarHatchback();

        makeCarCombi.make();
        System.out.println("\n");
        makeCarHatchback.make();
    }
}
