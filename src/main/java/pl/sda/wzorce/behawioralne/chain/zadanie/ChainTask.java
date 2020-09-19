package pl.sda.wzorce.behawioralne.chain.zadanie;

// chain of resposibility
// utworz lancuch odpowiedzialnosci bazujac na interfejsie
interface School {
    boolean test(Person person);
    void teach(Person person);
}
class Person {
    String name;
    int age;
    int score;
}
// implementujac ten interfejs w kolejnych klasach
// - ElementarySchool // akceptuje osoby miedzy 7 a 15 rokiem zycia
// - MiddleSchool // akceptuje osoby miedzy 15 a 20
// - HightSchool // akceptuje osoby powyzej 20 oraz score > 100
// w przypadku nieobsluzenia osoby przez zadna szkole wyswietl informacje
// przypadek gdy osoba ma np. 22 lata i score == 10
// w metodach teach umiesc stosowny komunikat np. "podstawowka przyjela i uczy: + person.getName())


public class ChainTask {
    public static void main(String[] args) {

    }
}
