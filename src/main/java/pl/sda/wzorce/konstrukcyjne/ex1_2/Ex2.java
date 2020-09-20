package pl.sda.wzorce.konstrukcyjne.ex1_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
@AllArgsConstructor
class Person{

    private final String name;
    private final String surname;
    private final LocalDateTime birthDate;
    private final String pesel;

    class InternalBuilder{

        Person create() {
            if(pesel.equals("-1")){
            System.out.println("Pesel domyślny");
            }
            return new Person(name, surname, birthDate, pesel);}
    }

}

class PersonBuilder{

    Person create() { return new Person("Jan", "Kowalski", null, "6712189394002"); }
}

// utworz klase Person z nastepujacymi polami:
// - imie, nazwisko, plec, data urodzenia (localdate), pesel
// 1. zaimplementuj builder jako oddzielna klase wraz z wartosciami domyslnymi
// 2. zaimplementuj builder jako klase wewnatrzna person, przykladowa nazwa: InternalBuilder
// w przypadku domyslnej wartosci nr. pesel wyswiet na ekranie ostrzezenie ze numer pesel przyjmie wartosc domyslna
// 3. korzystajac z ponizszego kawalka kodu zaimplementuj builder w stylu fluent

class PersonBuilderFluent {
    String name;
    String surname;
    LocalDateTime birthDate;
    String pesel;
    // ...
    PersonBuilderFluent withName(String name) {
        this.name = name;
        return this;
    }
    PersonBuilderFluent withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    PersonBuilderFluent withBirthDate(LocalDateTime date) {
        this.birthDate = date;
        return this;
    }

    PersonBuilderFluent withPesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    Person create() {
        return new Person(name, surname, birthDate, pesel);
    }
}

public class Ex2 {
  public static void main(String[] args) {
      // przykladowe uzycie
      Person person = new PersonBuilderFluent().withName("Janusz").withSurname("Nosacz").withPesel("92120800912").create();}
}


