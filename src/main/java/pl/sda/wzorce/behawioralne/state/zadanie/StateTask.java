package pl.sda.wzorce.behawioralne.state.zadanie;

// utworz interfejs CoffeExpress reprezentujacy ekspres do kawy, ma on zawierac metody
// wlacz, wylacz, zaparz kawe, wyczysc sie, setState - nazwy metod moga byc po angielsku
// zaimplementuj interfejs w klasie a wewnatrz klasy obsluguj stany przy pomocy instancji
// interfejsu
// CoffeExpresState, dla interfejsu utworz 4 klasy implementujace pojedyncze zachowanie
// interfejs CoffeExpressState ma pokrywac sie swoimi metodami z interfejsem CoffeExpress
// dla poszczegolnego stanu np.
// CoffeExpresStateOn
// CoffeExpresStateOff
// CoffeExpresStateMakeCoffe
// CoffeExpresStateCleanUp
// zaprezentuj zmiennosc zachowania metod expresu na przykladzie

import lombok.RequiredArgsConstructor;

public class StateTask {
    public static void main(String[] args) {
    }
}

interface CoffeeExpress {
    void turnOn();

    void turnOff();

    void makeACoffee();

    void clean();

    void setState();
}

interface CoffeeBehevState {
    void turnOn();

    void turnOff();

    void makeACoffee();

    void clean();

}

@RequiredArgsConstructor
class CoffeeExpressStateOn implements CoffeeBehevState {

    private final CoffeeExpress coffeeExpress;

    @Override
    public void turnOn() {
        System.out.println("Nie mozesz mnie drugi raz włączyć");
    }

    @Override
    public void turnOff() {
        System.out.println("Wyłączanie...3...2...1... Off");
    }

    @Override
    public void makeACoffee() {
        System.out.println("Zaczynam robić kawę");
    }

    @Override
    public void clean() {
        System.out.println("czyszcze się");
    }
}
