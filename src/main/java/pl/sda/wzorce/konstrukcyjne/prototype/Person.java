package pl.sda.wzorce.konstrukcyjne.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Cloneable {
  String name;
  String surname;
  int age;
  String pesel;
}

class PrototypeApp{
  public static void main(String[] args) {
      // baza
    Person jan = new Person("Jan", "Kowalski", 57, "157568455");
    // marysia old way
    Person marysia = new Person("Marysia", jan.getSurname(), jan.getAge(), "54848645");

    // marysia new way
  }
}

