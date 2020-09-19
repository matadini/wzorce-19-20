package pl.sda.wzorce.konstrukcyjne.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class DoctorPerson {
    String name;
    String surname;
    int age;
    String special;
    boolean isEmploye;
    String pesel;
    String uuid;
}
