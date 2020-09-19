package pl.sda.wzorce.strukturalne.proxy;

// proxy
// majac interfejs i klasy
interface AlcoholShop {
    void buy(int money);
}
class AlcoholShopNaRogu implements AlcoholShop {

    @Override
    public void buy(int money) {
        System.out.println("Kupuje alkohol za: " + money);
    }
}
class Person {
    String name;
    int age;
}
// napisz klase proxy zabezpieczajaca aby osoby ponizej 18 roku
// zycia nie mogly kupowac alkoholu



class ProxyApp {

    public static void main(String[] args) {
        Terminator terminator = new TerminatorIbm();

        Terminator terminatorOlka = new TerminatorProxy("olek", terminator);
        terminatorOlka.fight();
        terminatorOlka.shot();

        Terminator terminatorJanka = new TerminatorProxy("janek", terminator);
        terminatorJanka.fight();
        terminatorJanka.shot();
    }

}
