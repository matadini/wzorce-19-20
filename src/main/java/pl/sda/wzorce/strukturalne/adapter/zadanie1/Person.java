package pl.sda.wzorce.strukturalne.adapter.zadanie1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Person {

    String name;
    String surname;
    int age;
    LocalDate birthDate;


}

interface Osoba{
String getImie(Person person);
String getNazwisko(Person person);
}

@RequiredArgsConstructor
class Adapter implements Osoba {

    private  final Person person;

    @Override
    public String getImie(Person person) {
        return person.name;
    }

    @Override
    public String getNazwisko(Person person) {
        return person.surname;
    }

}

class AdapterApp {
  public static void main(String[] args) {

      Person person = new Person("Janusz", "Nosacz", 35, LocalDate.of(1985,5,24));

      Adapter adapter = new Adapter(person);
    System.out.println(adapter.getImie(person));
    System.out.println(adapter.getNazwisko(person));

  }
}