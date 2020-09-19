package pl.sda.wzorce.behawioralne.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// klasa zarzadania, wniosek
class Proporsal {
    String user;
    Type type;

    enum Type {
        CAR, HOME, INSURANCE
    }
}
