package pl.sda.wzorce.behawioralne.chain;

class HandlerInsurance implements MyHander {

    @Override
    public void consider(Proporsal proporsal) {
        System.out.println("Pani Zosia rozpatrza wniosek o ubezpieczenia dla: " + proporsal.getUser());
    }

    @Override
    public boolean test(Proporsal proporsal) {
        return Proporsal.Type.INSURANCE.equals(proporsal.getType());
    }
}
