package pl.sda.wzorce.konstrukcyjne.builder;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
class Person {
    String name;
    String surname;
    int age;
    Boolean hasACar;

}

