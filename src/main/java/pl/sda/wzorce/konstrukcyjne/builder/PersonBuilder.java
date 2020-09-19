package pl.sda.wzorce.konstrukcyjne.builder;

import lombok.Setter;

@Setter
class PersonBuilder {
    String name = "janusz";
    String surname = "nosacz";
    int age = 56;
    Boolean hasACar = true;

    Person create() {
        return new Person(name, surname, age, hasACar);
    }

}
