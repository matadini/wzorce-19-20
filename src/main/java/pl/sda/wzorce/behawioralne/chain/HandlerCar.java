package pl.sda.wzorce.behawioralne.chain;

class HandlerCar implements MyHander {

    @Override
    public void consider(Proporsal proporsal) {
        System.out.println("Pani Krysia rozpatrza wniosek o samochod dla: " + proporsal.getUser());
    }

    @Override
    public boolean test(Proporsal proporsal) {
        Proporsal.Type type = proporsal.getType();
        return Proporsal.Type.CAR.equals(type);
    }
}
