package pl.sda.wzorce.behawioralne.chain;

class HandlerHome implements MyHander {

    @Override
    public void consider(Proporsal proporsal) {
        System.out.println("Pani Bogusia rozpatrza wniosek o domu dla: " + proporsal.getUser());
    }

    @Override
    public boolean test(Proporsal proporsal) {
        return Proporsal.Type.HOME.equals(proporsal.getType());
    }
}
