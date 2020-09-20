package pl.sda.wzorce.strukturalne.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class FootballPlayer {
    YoungPerson youngPerson;
    String team;
    String position;
}
