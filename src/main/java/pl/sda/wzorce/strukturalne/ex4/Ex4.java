package pl.sda.wzorce.strukturalne.ex4;


// adapter
// ludzie z polski nie lubia zagranicznych nazw ;)
// napisz klase Person z polami, name, surname, age, birthDate
// napisz interfejs o nazwie Osoba z metodami getImie(), getNazwisko() aby
// aby programista no-english mogl korzystac z instancji klasy Person bez watpliwosci
// napisz klase adaptera implementujacy interfejs osoba


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
class Person{

    String name;
    String surname;
    Integer age;
    LocalDateTime birthDate;
}

    interface Osoba{
    String getImie();
    String getNazwisko();
    Integer getWiek();
    LocalDateTime getDataUrodzenia();
}

    @RequiredArgsConstructor
    class Adapter implements Osoba{
        private final Person person;

        @Override
        public String getImie() {
            return person.getName();
        }

        @Override
        public String getNazwisko() {
            return person.getSurname();
        }

        @Override
        public Integer getWiek() {
            return person.getAge();
        }

        @Override
        public LocalDateTime getDataUrodzenia() {
            return person.getBirthDate();
        }
    }

public class Ex4 {
}
