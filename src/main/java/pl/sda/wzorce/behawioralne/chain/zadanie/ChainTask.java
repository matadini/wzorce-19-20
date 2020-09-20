package pl.sda.wzorce.behawioralne.chain.zadanie;


// chain of resposibility
// utworz lancuch odpowiedzialnosci bazujac na interfejsie

// implementujac ten interfejs w kolejnych klasach
// - ElementarySchool // akceptuje osoby miedzy 7 a 15 rokiem zycia
// - MiddleSchool // akceptuje osoby miedzy 15 a 20
// - HightSchool // akceptuje osoby powyzej 20 oraz score > 100
// w przypadku nieobsluzenia osoby przez zadna szkole wyswietl informacje
// przypadek gdy osoba ma np. 22 lata i score == 10
// w metodach teach umiesc stosowny komunikat np. "podstawowka przyjela i uczy: + person.getName())


import lombok.AllArgsConstructor;

        import java.util.ArrayList;
        import java.util.List;

public class ChainTask {

    public static void main(String[] args) {
        List<School> schoolList = new ArrayList<>();
        ElementarySchool elementarySchool = new ElementarySchool();
        MiddleSchool middleSchool = new MiddleSchool();
        HightSchool hightSchool = new HightSchool();
        schoolList.add(elementarySchool);
        schoolList.add(middleSchool);
        schoolList.add(hightSchool);

        Person person1 = new Person("Janusz", 22, 10);
        Person person2 = new Person("Janusz", 10, 16);
        Person person3 = new Person("Janusz", 15, 50);

        forEachChain(schoolList, person1);
        forEachChain(schoolList, person2);
        forEachChain(schoolList, person3);
    }

    private static void forEachChain(List<School> schoolList, Person person1) {
        for (School s : schoolList) {
            if (s.test(person1)) {
                s.teach(person1);
                break;
            }
        }
    }
}

@AllArgsConstructor
class Person {
    String name;
    int age;
    int score;
}

interface School {
    boolean test(Person person);

    void teach(Person person);
}

class ElementarySchool implements School {
    static int numberOfStudents = 0;

    @Override
    public boolean test(Person person) {
        return person.age < 15 && person.age >= -7;
    }

    @Override
    public void teach(Person person) {
        System.out.println("Przyjęto ucznia do podstawówki");
        numberOfStudents++;
    }
}

class MiddleSchool implements School {
    static int numberOfStudents = 0;

    @Override
    public boolean test(Person person) {
        return person.age < 20 && person.age >= 15;
    }

    @Override
    public void teach(Person person) {
        System.out.println("Przyjęto ucznia do szkoły średniej");
        numberOfStudents++;
    }
}

class HightSchool implements School {
    static int numberOfStudents = 0;

    @Override
    public boolean test(Person person) {
        return person.score >= 100 && person.age >= 20;
    }

    @Override
    public void teach(Person person) {
        System.out.println("Przyjęto ucznia na studnia");
        numberOfStudents++;
    }
}


