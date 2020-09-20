package pl.sda.wzorce.strukturalne.proxy.zadanie.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

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

@AllArgsConstructor
class Person {
    String name;
    int age;
}
// napisz klase proxy zabezpieczajaca aby osoby ponizej 18 roku
// zycia nie mogly kupowac alkoholu

@RequiredArgsConstructor
class AlcoholProxy implements AlcoholShop {

    private final Person person;
    private final AlcoholShopNaRogu alcoholShopNaRogu;

    @Override
    public void buy(int money) {
        if(person.age < 18){
            System.out.println("Nie możesz kupić alkoholu, jesteś za młody!!!!");
        } else {
            alcoholShopNaRogu.buy(money);
        }
    }
}


public class ProxyAlcoholTask {
    public static void main(String[] args) {
        AlcoholShopNaRogu alko24h = new AlcoholShopNaRogu();
        alko24h.buy(150);

        Person maciek = new Person("Maciek", 17);
        Person ola = new Person("Ola", 25);

        AlcoholProxy alcoProxy = new AlcoholProxy(maciek,alko24h);
        alcoProxy.buy(150);
        AlcoholProxy alcoProxy1 = new AlcoholProxy(ola,alko24h);
        alcoProxy1.buy(150);
    }
}

