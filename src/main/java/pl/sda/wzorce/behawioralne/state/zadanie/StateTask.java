package pl.sda.wzorce.behawioralne.state.zadanie;



// utworz interfejs Person reprezentujacy czlowieka,
// ma on zawierac metody drink, soberup, walk, talk, setState
// zaimplementuj obsluge nastepujacych stanow dla Person
// - sober
// - drunk
// zaprezentuj zmiennosc dzialania walk and talk po zmianie stanu

import lombok.RequiredArgsConstructor;

enum PersonState{
    DRUNK, SOBER
}

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

class Janusz implements Person{

    PersonBehavState personBehavState;

    Janusz(){this.personBehavState = new PersonBehavStateSoberb(this);}

    @Override
    public void drink() {
        personBehavState.drink();
    }

    @Override
    public void soberup() {
        personBehavState.soberup();
    }

    @Override
    public void walk() {
        personBehavState.walk();
    }

    @Override
    public void talk() {
        personBehavState.talk();
    }

    @Override
    public void setState(PersonState personState) {
        if(PersonState.SOBER.equals(personState))
            personBehavState = new PersonBehavStateSoberb(this);
        if(PersonState.DRUNK.equals(personState))
            personBehavState = new PersonBehavStateDrunk(this);
    }
}

@RequiredArgsConstructor
class PersonBehavStateSoberb implements PersonBehavState{

    private final Person personState;
    @Override
    public void drink() {
        personState.setState(PersonState.DRUNK);
    System.out.println("Jestem pijany");
    }

    @Override
    public void soberup() {
    System.out.println("Przecież jestem trzeźwy");
    }

    @Override
    public void walk() {
    System.out.println("Ide prosto");
    }

    @Override
    public void talk() {
    System.out.println("Mówie wyrażnie");
    }
}

@RequiredArgsConstructor
class PersonBehavStateDrunk implements PersonBehavState{

    private final Person personState;
    @Override
    public void drink() {
        System.out.println("Bede żygoł......");
    }

    @Override
    public void soberup() {
        personState.setState(PersonState.SOBER);
        System.out.println("Mam kaca ");
    }

    @Override
    public void walk() {
        System.out.println("Cała droga moja, od lewej do prawej");
    }

    @Override
    public void talk() {
        System.out.println("Halyyba..stroa.......maszd.f.....");
    }
}


public class StateTask {
  public static void main(String[] args) {
    Person janusz = new Janusz();
    janusz.soberup();
    janusz.talk();
    janusz.drink();
    janusz.talk();
    janusz.walk();
      janusz.drink();
    janusz.soberup();

  }
}
