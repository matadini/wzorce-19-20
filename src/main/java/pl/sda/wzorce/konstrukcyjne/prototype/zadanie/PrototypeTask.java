package pl.sda.wzorce.konstrukcyjne.prototype.zadanie;

// utworz klase Dog z polem name i type (jako enum z rasa), age
// zaimplementuj mechanizm klonowania
// utworz watache psow z roznymi imionami oraz wiekiem korzystajac z
// mechanizmu klonowania

import lombok.AllArgsConstructor;
import lombok.Data;

enum Breed {
    OWCZAREK,MOPS,YORK,KUNDEL
}
@Data
@AllArgsConstructor
class Dog implements Cloneable {
    String name;
    Breed breed;
    int age;

    Dog createClone() throws CloneNotSupportedException{
        return (Dog) clone();
    }

}

public class PrototypeTask {
    public static void main(String[] args) throws CloneNotSupportedException {
        Dog burek1 = new Dog("Fafik", Breed.OWCZAREK, 10);
        Dog burek2 = burek1.createClone();
        burek2.setAge(5);
        Dog burek3 = burek1.createClone();
        burek3.setName("Pestka");
        burek3.setBreed(Breed.MOPS);

    System.out.println(burek1);
    System.out.println(burek2);
    System.out.println(burek3);
    }
}
