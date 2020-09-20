package pl.sda.wzorce.behawioralne.templatemethod;

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
