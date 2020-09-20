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
class ProxyAlcoholShop implements AlcoholShop{

    private final AlcoholShop alkoholShop;
    private final Person person;

    @Override
    public void buy(int money) {
    if (person.age >= 18) {
      alkoholShop.buy(money);
          }
    else{
      System.out.println("NIe masz jeszcze 18 lat! Nie możesz kupić alkoholu");
    }

    }
}

public class ProxyAlcoholTask {
    public static void main(String[] args) {

        AlcoholShop narogu = new AlcoholShopNaRogu();

        Person jasiek = new Person("Jaś",12);
        Person janusz= new Person("Janusz",55);

        AlcoholShop żabka = new ProxyAlcoholShop(narogu,jasiek);
        AlcoholShop żabka1 = new ProxyAlcoholShop(narogu,janusz);

        żabka.buy(10);
        żabka1.buy(10);





    }
}

