package pl.sda.wzorce.konstrukcyjne.builder;

import lombok.Setter;

@Setter
class DoctorPersonBuilder {
    String name = "niepodano";
    String surname = "niepodano";
    int age = -1;
    String special = "niepodano";
    boolean isEmploye = false;
    String pesel = "niepodano";
    String uuid = "niepodano";

    DoctorPerson create() {
        return new DoctorPerson(name, surname, age, special, isEmploye, pesel, uuid);
    }
}
