package pl.sda.wzorce.strukturalne.proxy.zadanie.security;

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


public class ProxyAlcoholTask {
    public static void main(String[] args) {

    }
}

