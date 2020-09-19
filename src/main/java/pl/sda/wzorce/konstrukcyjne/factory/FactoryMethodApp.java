package pl.sda.wzorce.konstrukcyjne.factory;

// utworz interfejs o nazwie Car z metoda void drive();
// zaimplementuj interfejs w dwoch przykladowych klasach CarAudi, CarVW
// metoda drive ma zawierac informacje jaki samochod jedzie

// utworz interfejs CarFactory z metoda Car create()
// oraz zaimplementuj go w klasach fabrycznych carFactoryAudi etc.
// wykorzystaj fabryki do utworzenia i "prowadzenia" samochodow audi i vw.


// factory method
// utworz klase Person z danymi, imie nazwisko, data urodzenia (localdate) oraz wiek
// utworz fabryke dla klasy Person (PersonFactory) z metoda create(imie, nazwisko, data urodzenia)
// pole wiek ma byc uzupelniane w fabryce, jest to roznica obecnej daty od daty urodzenia w latach


public class FactoryMethodApp {

    public static void main(String[] args) {
        Car car = CarFactory.create("123", Car.Type.VW);
        System.out.println(car.toString());
        Car car2 = CarFactory.create("123", Car.Type.AUDI);
        System.out.println(car2.toString());
    }
}
