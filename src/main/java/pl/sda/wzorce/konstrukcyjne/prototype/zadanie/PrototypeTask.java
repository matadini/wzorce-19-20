package pl.sda.wzorce.konstrukcyjne.prototype.zadanie;

import lombok.AllArgsConstructor;
import lombok.Data;

// utworz klase Dog z polem name i type (jako enum z rasa), age
// zaimplementuj mechanizm klonowania
// utworz watache psow z roznymi imionami oraz wiekiem korzystajac z
// mechanizmu klonowania
public class PrototypeTask {
    public static void main(String[] args) throws CloneNotSupportedException {

        Dog dog1 = new Dog("reksio", Breed.HE, 5);
        Dog dog2 = dog1.createClone();
        dog2.setName("winston");
        dog2.setAge(7);
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
    }
}

enum Breed {
    SHE, HE
}

@Data
@AllArgsConstructor
class Dog implements Cloneable {
    String name;
    Breed breed;
    int age;

    Dog createClone() throws CloneNotSupportedException {
        return (Dog) clone();
    }
}
