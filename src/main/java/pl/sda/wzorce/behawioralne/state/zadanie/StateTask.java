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
    System.out.println("Za mało alkoholu, kto jest najbardziej trzezwy?");
  }

  @Override
  public void talk() {
    System.out.println("Pij nie gadaj");
  }
}

class USiebie implements Person {
  PersonState state = PersonState.SOBER;

  @Override
  public void drink() {
    if (state.equals(PersonState.SOBER)) {
      System.out.println("Chłopaki dzisiaj nie pije");
    }
    if (state.equals(PersonState.DRUNK)) {
      System.out.println("Polewaj");
      state = PersonState.DRUNK;
    }
  }

  @Override
  public void soberup() {
    if (state.equals(PersonState.DRUNK)) {
      System.out.println("Musze wytrzezwiec");
    }
  }

  @Override
  public void walk() {
    if (state.equals(PersonState.DRUNK)) {
      System.out.println("Losujemy kto idzie po alko");
    } else {
      System.out.println(" Moge isc cos wam kupic");

    }
  }

  @Override
  public void talk() {
    if (state.equals(PersonState.DRUNK)) {
      System.out.println("No hey piekna co tam");
    } else {
      System.out.println("Dzien dobry, jestm Patryk");
    }
  }

  @Override
  public void setState(PersonState sober) {

  }
}

class NaMiescie implements Person {

  @Override
  public void drink() {

  }

  @Override
  public void soberup() {

  }

  @Override
  public void walk() {

  }

  @Override
  public void talk() {

  }

  @Override
  public void setState(PersonState sober) {

  }
}

class StateTask {
  public static void main(String[] args) {}
}
