package pl.sda.wzorce.konstrukcyjne.ex3;

// factory method
// utworz klase Person z danymi, imie nazwisko, data urodzenia (localdate) oraz wiek
// utworz fabryke dla klasy Person (PersonFactory) z metoda create(imie, nazwisko, data urodzenia)
// pole wiek ma byc uzupelniane w fabryce, jest to roznica obecnej daty od daty urodzenia w latach

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.Period;

@Data
@ToString
@AllArgsConstructor
class Person {
    private final String name;
    private final String surname;
    private final LocalDateTime birthDate;
    private final Integer age;
}

class PersonFactory {
    static Person create(String name, String surname, LocalDateTime birthDate){
        Integer age = LocalDateTime.now().getYear() - birthDate.getYear();
        return new Person(name, surname, birthDate, age);
    }
}

public class Ex3 {

}
