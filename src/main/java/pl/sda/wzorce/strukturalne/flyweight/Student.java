package pl.sda.wzorce.strukturalne.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student {
    YoungPerson youngPerson;
    String univeristy;
    int univeristyId;
}
