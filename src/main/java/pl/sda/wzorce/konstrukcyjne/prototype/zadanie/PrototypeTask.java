package pl.sda.wzorce.konstrukcyjne.prototype.zadanie;

// utworz klase Dog z polem name i type (jako enum z rasa), age
// zaimplementuj mechanizm klonowania
// utworz watache psow z roznymi imionami oraz wiekiem korzystajac z
// mechanizmu klonowania

import lombok.AllArgsConstructor;
import lombok.Data;


enum Breed {
     SHEEPDOG, BULLDOG, POODLE
}

@Data
@AllArgsConstructor
class Dog implements Cloneable{
    String name;
    Breed type;
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

        System.out.println(alex);
        System.out.println(fifi);

    }
}
