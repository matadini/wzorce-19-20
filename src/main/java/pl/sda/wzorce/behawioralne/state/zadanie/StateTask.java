package pl.sda.wzorce.behawioralne.state.zadanie;

// utworz interfejs Person reprezentujacy czlowieka,
// ma on zawierac metody drink, soberup, walk, talk, setState
// zaimplementuj obsluge nastepujacych stanow dla Person
// - sober
// - drunk
// zaprezentuj zmiennosc dzialania walk and talk po zmianie stanu

import lombok.RequiredArgsConstructor;

enum PersonStateType {
    SOBER, DRUNK
}

interface Person extends PersonState{
    void setState(PersonStateType on);
}

interface PersonState {
    void drink();
    void soberup();
    void walk();
    void talk();
}

@RequiredArgsConstructor
class PersonStateSober implements PersonState {
    private final Person person;

    @Override
    public void drink() {
        System.out.println("Upijam się :D");
        person.setState(PersonStateType.DRUNK);
    }

    @Override
    public void soberup() {
        System.out.println("Nie jestem pijany. Nie mam po czym trzeźwieć!");
    }

    @Override
    public void walk() {
        System.out.println("Chodzę prosto");
    }

    @Override
    public void talk() {
        System.out.println("Nie seplenię");
    }
}

@RequiredArgsConstructor
class PersonStateDrunk implements PersonState {
    private final Person person;

    @Override
    public void drink() {
        System.out.println("Nie mogę już pić! Jestem pijany");
    }

    @Override
    public void soberup() {
        System.out.println("Kaca mam. Trzeźwieje");
        person.setState(PersonStateType.SOBER);
    }

    @Override
    public void walk() {
        System.out.println("Chodzę wężykiem");
    }

    @Override
    public void talk() {
        System.out.println("Seplenię");
    }
}

class PolishPerson implements Person {
    PersonState currentPersonState;

    PolishPerson(){
        this.currentPersonState = new PersonStateSober(this);
    }


    @Override
    public void setState(PersonStateType personStateType) {
        if(PersonStateType.SOBER.equals(personStateType)){
            currentPersonState = new PersonStateSober(this);
        }
        if(PersonStateType.DRUNK.equals(personStateType)){
            currentPersonState = new PersonStateDrunk(this);
        }
    }

    @Override
    public void drink() {
        currentPersonState.drink();
    }

    @Override
    public void soberup() {
        currentPersonState.soberup();
    }

    @Override
    public void walk() {
        currentPersonState.walk();
    }

    @Override
    public void talk() {
        currentPersonState.talk();
    }
}


class StateTask {
    public static void main(String[] args) {

        Person pijak = new PolishPerson();
        System.out.println("=========== Co robi pijak ============");
        pijak.talk();
        pijak.walk();
        pijak.soberup();
        pijak.drink();
        pijak.drink();
        pijak.walk();
        pijak.talk();
        pijak.soberup();
    }
}
