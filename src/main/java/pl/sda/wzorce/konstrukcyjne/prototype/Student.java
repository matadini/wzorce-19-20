package pl.sda.wzorce.konstrukcyjne.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student implements Cloneable {
    String name;
    String surname;
    int age;
    String pesel;

    Student createClone() throws CloneNotSupportedException {
        return (Student) clone();
    }
}

class PrototypeApp {
    public static void main(String[] args) throws CloneNotSupportedException {

        // base
        Student jan = new Student("Jan", "Kowalski", 15, "123");

        // marysia old way
        Student marysia = new Student("Marysia", jan.getSurname(), jan.getAge(), "789");

        // marysia new way
        Student marysia2 = jan.createClone();
        marysia2.setName("Marysia");
        marysia2.setPesel("789");

        System.out.println(jan);
        System.out.println(marysia);
        System.out.println(marysia2);

    }
}
