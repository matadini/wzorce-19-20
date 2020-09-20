package pl.sda.wzorce.konstrukcyjne.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
class Person {
    String name;
    String surname;
    int age;
    Boolean hasACar;

}

