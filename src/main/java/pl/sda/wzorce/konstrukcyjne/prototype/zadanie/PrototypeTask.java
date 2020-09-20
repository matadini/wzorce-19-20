package pl.sda.wzorce.konstrukcyjne.prototype.zadanie;

// utworz klase Dog z polem name i type (jako enum z rasa), age
// zaimplementuj mechanizm klonowania
// utworz watache psow z roznymi imionami oraz wiekiem korzystajac z
// mechanizmu klonowania

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;

enum Breed implements Type {
     SHEEPDOG, BULLDOG, POODLE
}

@Data
@AllArgsConstructor
class Dog implements Cloneable{
    String name;
    Type type;
    Integer age;

    Dog createClone() throws CloneNotSupportedException {
        return (Dog) clone();
    }

}

public class PrototypeTask {
    public static void main(String[] args) throws CloneNotSupportedException {

        //base
        Dog alex = new Dog("Alex", Breed.SHEEPDOG, 5);

        //prototype
        Dog fifi = alex.createClone();
        fifi.setName("Fifi");
        fifi.setType(Breed.BULLDOG);
        fifi.setAge(7);

        System.out.println(alex);
        System.out.println(fifi);

    }
}
