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
    void setState();
}

interface PersonBehavState {
    void drunk();
    void sober();
}

public class StateTask {
    public static void main(String[] args) {

    }
}
