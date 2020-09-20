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
