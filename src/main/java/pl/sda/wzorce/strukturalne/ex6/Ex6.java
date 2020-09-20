package pl.sda.wzorce.strukturalne.ex6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// napisz klase proxy zabezpieczajaca aby osoby ponizej 18 roku
// zycia nie mogly kupowac alkoholu

interface AlcoholShop {
    void buy(int money);
}

class AlcoholShopNaRogu implements AlcoholShop {
    @Override
    public void buy(int money) {
        System.out.println("Kupuje alkohol za: " + money);
    }
}

@Getter
@AllArgsConstructor
class Person {
    String name;
    int age;
}

@RequiredArgsConstructor
class ProxyAlcoholShop implements AlcoholShop {

    private final Person person;
    private final AlcoholShop alcoholShop;

    @Override
    public void buy(int money) {
        if(person.getAge() >= 18){
            alcoholShop.buy(money);
        } else {
      System.out.println("Osobom nieletnim alkoholu nie sprzedajemy!");
        }
    }
}

public class Ex6 {
  public static void main(String[] args) {
    AlcoholShop alcoholShop = new AlcoholShopNaRogu();
    Person p1 = new Person("Kazik", 15);
    Person p2 = new Person("Adam",30);
    AlcoholShop alcoholShopKazik = new ProxyAlcoholShop(p1, alcoholShop);
    AlcoholShop alcoholShopAdam = new ProxyAlcoholShop(p2, alcoholShop);
    System.out.print("Kazik: ");
    alcoholShopKazik.buy(15);
    System.out.print("Adam: ");
    alcoholShopAdam.buy(20);

  }
}
