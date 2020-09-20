package pl.sda.wzorce.konstrukcyjne.builder.zadanie1;


import lombok.Setter;

import java.time.LocalDate;


@Setter
public class PersonBuilder {

    String name = "niepodano";
    String surname = "niepodano";
    String sex = "niepodano";
    LocalDate birthDate = LocalDate.of(1900,01,01);
    String pesel = "12345678";

     Person create() {
    return new Person(name, surname, sex, birthDate, pesel);
}

}
