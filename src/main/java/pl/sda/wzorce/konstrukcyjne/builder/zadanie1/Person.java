package pl.sda.wzorce.konstrukcyjne.builder.zadanie1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Data
@AllArgsConstructor
class Person {

    String name;
    String surname;
    String sex;
    LocalDate birthDate;
    String pesel;

}

@Setter
class InternalBuilder {

    String name = "niepodano";
    String surname = "niepodano";
    String sex = "niepodano";
    LocalDate birthDate = LocalDate.of(1900,01,01);
    String pesel = "1";

    Person create() {
    if (pesel.equals("1")) System.out.println("numer pesel przyjmie wartosc domyslna");
        return new Person(name, surname, sex, birthDate, pesel);
    }


}

class PersonBuilderFluent {
    String name = "niepodano";
    String surname = "niepodano";
    String sex = "niepodano";
    LocalDate birthDate = LocalDate.of(1900,01,01);
    String pesel = "1";

    PersonBuilderFluent withName(String name) {
        this.name = name;
        return this;
    }
    PersonBuilderFluent withSurname(String surname) {
        this.surname = surname;
        return this;
    }
    PersonBuilderFluent withSex(String sex) {
        this.sex = sex;
        return this;
    }
    PersonBuilderFluent withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
    Person create() {
            return new Person(name, surname, sex, birthDate, pesel);
        }
}


class BuilderApp {
  public static void main(String[] args) {

      PersonBuilderFluent builder1 = new PersonBuilderFluent();
      builder1.withName("janusz");
      Person person1 = builder1.create();

    System.out.println(person1);
  }
}