package pl.sda.wzorce.behawioralne.state.zadanie;

// utworz interfejs Person reprezentujacy czlowieka,
// ma on zawierac metody drink, soberup, walk, talk, setState
// zaimplementuj obsluge nastepujacych stanow dla Person
// - sober
// - drunk
// zaprezentuj zmiennosc dzialania walk and talk po zmianie stanu


interface Person {

  void drink();

  void soberup();

  void walk();

  void talk();

  void setState(PersonState sober);
}

interface PersonBehavState {

  void drink();

  void soberup();

  void walk();

  void talk();
}

enum PersonState {
  SOBER,
  DRUNK
}

class PersonBahveStateSober implements PersonBehavState {

  @Override
  public void drink() {
    System.out.println("Wkoncu sie moge napic");
  }

  @Override
  public void soberup() {
    System.out.println("Dzisiaj jestem jeszcze trzezwiutki");
  }

  @Override
  public void walk() {
    System.out.println("Ide po wódke");
  }

  @Override
  public void talk() {
    System.out.println("ze mna sie nie napijesz?");
  }
}

class PersonBahveStateDrunk implements PersonBehavState {

  @Override
  public void drink() {
    System.out.println("Jestes ciota czy pijesz");
  }

  @Override
  public void soberup() {
    System.out.println("12 a ja sie jeszcze nie napilem?");
  }

  @Override
  public void walk() {
    System.out.println("Za mało alkoholu");
  }

  @Override
  public void talk() {
    System.out.println("pij nie gadaj");
  }
}
//    private final Phone phoneStateOwner;
//
//    @Override
//    public void call() {
//        System.out.println("jestem wylaczony nie zadzwonisz");
//    }
//
//    @Override
//    public void callEnd() {
//        System.out.println("jestem wylaczony nie skonczysz rozmowy");
//    }
//
//    @Override
//    public void sms() {
//        System.out.println("jestem wylaczony nie smsujesz");
//    }
//
//    @Override
//    public void sendSms() {
//        System.out.println("jestem wylaczony nie wyslesz sms");
//    }
//
//    @Override
//    public void turnOn() {
//        phoneStateOwner.setState(PhoneState.ON);
//        System.out.println("wlaczam sie....");
//    }
//
//    @Override
//    public void turnOff() {
//        System.out.println("jestem juz wylaczony!");
//    }

class StateTask {
  public static void main(String[] args) {}
}
