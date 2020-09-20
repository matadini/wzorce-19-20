package pl.sda.wzorce.konstrukcyjne.factory.zadanie2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
public class Person {

    String name;
    String surname;
    int age;
    LocalDate birthDate;
}

class PersonFactroy{
    static Person create(String name, String surname, LocalDate birthDate){

        int age = Period.between(birthDate, LocalDate.now()).getYears();

        return new Person(name,surname,age,birthDate);
    }
}

class FactoryApp{
  public static void main(String[] args) {
    Person person = PersonFactroy.create("janusz", "nosacz", LocalDate.of(1992,3,9));
    System.out.println(person);
  }
}