package pl.sda.wzorce.behawioralne.templatemethod;

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
