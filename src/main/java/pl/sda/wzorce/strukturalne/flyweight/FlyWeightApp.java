package pl.sda.wzorce.strukturalne.flyweight;


import lombok.AllArgsConstructor;
import lombok.Data;


public class FlyWeightApp {

    public static void main(String[] args) {
        YoungPerson youngPerson = new YoungPerson("jan", "kowalski", 15);
        Student student = new Student(youngPerson, "polibuda", 123);
        FootballPlayer footballPlayer = new FootballPlayer(youngPerson, "fc kartofle", "pomocnik");

    }

}
