package pl.sda.wzorce.strukturalne.proxy.zadanie.security;

import lombok.AllArgsConstructor;

public class ProxyAlcoholTask {

    public static void main(String[] args) {
        Person person1 = new Person("Matiusz", 19);
        Person person2 = new Person("Mateusz", 17);
        AlcoholShop alcoholShop1 = new AlcoholShopProxy(person1, new AlcoholShopNaRogu());
        AlcoholShop alcoholShop2 = new AlcoholShopProxy(person2, new AlcoholShopNaRogu());
        alcoholShop1.buy(20);
        alcoholShop2.buy(20);
    }
}

interface AlcoholShop {
    void buy(int money);
}

@AllArgsConstructor
class AlcoholShopProxy implements AlcoholShop {

    Person person;
    AlcoholShopNaRogu alcoholShopNaRogu;

    @Override
    public void buy(int money) {
        if (person.age > 18) {
            alcoholShopNaRogu.buy(money);
        } else {
            System.out.println("nie masz 18 lat");
        }
    }
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

