package pl.sda.wzorce.behawioralne.chain.zadanie;



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
        if(person.getAge()>=7 && person.getAge() <15){
        return true ; } else {return false ;}
    }

    @Override
    public void teach(Person person) {
    System.out.println("Podstawówka przyjeła i uczy " + person.getName());
    }

}

class MiddleSchool implements School {
    @Override
    public boolean test(Person person) {
        if(person.getAge()>=15 && person.getAge() <20){
            return true ; } else {return false ;}
    }

    @Override
    public void teach(Person person) {
        System.out.println("Gimnazjjum przyjeło i uczy " + person.getName());
    }

}

class HightSchool implements School {
    @Override
    public boolean test(Person person) {
        if(person.getAge()>=20 && person.getScore() > 100){
            return true ; } else {return false ;}
    }

    @Override
    public void teach(Person person) {
        System.out.println("Liceum przyjeło i uczy " + person.getName());
    }

}


public class Education {
  public static void main(String[] args) {
      List<School> chain = new ArrayList<>();
      chain.add(new ElementarySchool());
      chain.add(new MiddleSchool());
      chain.add(new HightSchool());

      Person janusz = new Person("Janusz", 35 , -5);
      Person kasia = new Person("Kasia", 22 , 150);
      Person pioter = new Person("pioter", 12 , 15);

      for(School school: chain){
          if(school.test(pioter)){
              school.teach(pioter);
              break;
          } else {
        System.out.println("osoba nie została przyjęta");

          }
      }

  }
}
