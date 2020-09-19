package pl.sda.wzorce.konstrukcyjne.factory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Car {
    String vim;
    String carCode;
    Type type;
    boolean insurance;

    enum Type {
        VW, AUDI, OPEL
    }
}
