package pl.sda.wzorce.strukturalne.proxy.zadanie.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// proxy
// majac interfejs i klasy
interface AlcoholShop {
  void buy(int money);
}

class AlcoholShopNaRogu implements AlcoholShop {

  @Override
  public void buy(int money) {
    System.out.println("Kupuje alkohol za: " + money + " zł");
  }
}

@Getter
@AllArgsConstructor
class Person {
  String name;
  int age;
}

@AllArgsConstructor
@RequiredArgsConstructor
class ProxyAlcoholShop implements AlcoholShop {

  private Person person;
  private AlcoholShop alcoholShop;

  @Override
  public void buy(int money) {
    if (person.getAge() >= 18) {
      alcoholShop.buy(money);
    } else {
      System.out.println(
          person.getName()
              + "nie może kupić alkoholu poniewaz "
              + "nie sprzedajemy alkoholu osobom  ponizej 18 roku zycia");
    }
  }
}

public class ProxyAlcoholTask {
  public static void main(String[] args) {

    AlcoholShop alcoholShop = new AlcoholShopNaRogu();
    Person person1 = new Person("Michał", 19);
    Person person2 = new Person("Bartek ", 16);
    Person person3 = new Person("Wojtek", 24);
    System.out.print("Michał ");
    AlcoholShop alcoholShop1 = new ProxyAlcoholShop(person1, alcoholShop);
    alcoholShop1.buy(30);
    System.out.println();
    AlcoholShop alcoholShop2 = new ProxyAlcoholShop(person2, alcoholShop);
    alcoholShop2.buy(20);
  }
}
