package pl.sda.wzorce.konstrukcyjne.factory.zadanie;

// factory na przykladzie operowania na interfejsach
// 1. zdefiniuj interfejs Car z metoda drive();
// metoda drive ma zawierac informacje jaki samochod jedzie
// 2. zdefiniuj interfejs CarFactory z metoda Car create()
// 3. utworz przykladowa klase implementujaca Car np. CarAudi, CarAudi
// 4. utworz przykladowa klase implementujaca CarFactory np. CarFactoryAudi,
// obiektem zwracanym powinien byc obiekt klasy implementujacej Car np. new CarAudi
// 5. oddtworz przyklad z zajec korzystajac z fabryki opartej w dzialaniu na interfejsach
// porownaj przyklad z tym z zajec i zastanow sie czy poziom hermatyzacji kodu wzrosl czy zmalal?
// wykorzystaj fabryki do utworzenia i "prowadzenia" samochodow audi i vw.

import lombok.AllArgsConstructor;

public class FactoryTask {
    public static void main(String[] args) {
        Car car = new CarFactoryAudi().create();
        car.drive();
    }
}

interface Car {
    void drive();
}

interface CarFactory {
    Car create();
}

class CarAudi implements Car {
    String name = "Audi";

    @Override
    public void drive() {
        System.out.println("jedzie " + name);
    }
}

class CarFactoryAudi implements CarFactory {


    @Override
    public Car create() {
        return new CarAudi();
    }
}
