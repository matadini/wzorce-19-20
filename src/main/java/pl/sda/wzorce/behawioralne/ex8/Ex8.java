package pl.sda.wzorce.behawioralne.ex8;

// implementujac ten interfejs w kolejnych klasach
// - ElementarySchool // akceptuje osoby miedzy 7 a 15 rokiem zycia
// - MiddleSchool // akceptuje osoby miedzy 15 a 20
// - HightSchool // akceptuje osoby powyzej 20 oraz score > 100
// w przypadku nieobsluzenia osoby przez zadna szkole wyswietl informacje
// przypadek gdy osoba ma np. 22 lata i score == 10
// w metodach teach umiesc stosowny komunikat np. "podstawowka przyjela i uczy: + person.getName())

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

interface School {
  boolean test(Person person);

  void teach(Person person);
}

@Data
@AllArgsConstructor
class Person {
  String name;
  int age;
  int score;
}

class ElementarySchool implements School {
  @Override
  public boolean test(Person person) {
    return (person.getAge() >= 7 && person.getAge() <= 15);
  }

  @Override
  public void teach(Person person) {
    System.out.println("podstawowka przyjela i uczy: " + person.getName());
  }
}

class MiddleSchool implements School {
  @Override
  public boolean test(Person person) {
    return (person.getAge() >= 15 && person.getAge() <= 20);
  }

  @Override
  public void teach(Person person) {
    System.out.println("szkoła średnia przyjela i uczy: " + person.getName());
  }
}

class HighSchool implements School {
  @Override
  public boolean test(Person person) {
    return (person.getAge() >= 20 && person.getScore() > 100);
  }

  @Override
  public void teach(Person person) {
    System.out.println("szkoła wyższa przyjela i uczy: " + person.getName());
  }
}

public class Ex8 {
  public static void main(String[] args) {
      //łańcuch
      List<School> chain = new ArrayList<>();
      chain.add(new ElementarySchool());
      chain.add(new MiddleSchool());
      chain.add(new HighSchool());

      //zadanie
      Person p1 = new Person("Olek", 10, 50);
      Person p2 = new Person("Wojtek", 16, 90);
      Person p3 = new Person("Adam", 22, 110);

      //obrobka
      for(School school : chain){
          if(school.test(p1)){
              school.teach(p1);
              break;
          }
          }

      for(School school : chain){
          if(school.test(p2)){
              school.teach(p2);
              break;
          }
      }

      for(School school : chain){
          if(school.test(p3)){
              school.teach(p3);
              break;
          }
      }

      }
  }

