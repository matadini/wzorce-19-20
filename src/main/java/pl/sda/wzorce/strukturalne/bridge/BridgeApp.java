package pl.sda.wzorce.strukturalne.bridge;


// zaimplementuj przy pomocy dziedziczenia nastepujaca hierarche
// drink
// | --> Coffe
// | ---->

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

// dziedziczenie
class Figura {

}

class Okrag extends Figura {

}

class CzerwonyOkrag extends Okrag {

}

class NiebiskiOkrag extends Okrag {

}

// kompozycja
class FiguraKompozycja {

}

@RequiredArgsConstructor
class Okrag2 extends FiguraKompozycja {
    private final Kolor color;
}

@RequiredArgsConstructor
class Kolor {
    private final String nazwaKoloru;
}

public class BridgeApp {
    public static void main(String[] args) {

        Figura figura = new CzerwonyOkrag();

        FiguraKompozycja figura2 = new Okrag2(new Kolor("Czerwony"));
        FiguraKompozycja figura22 = new Okrag2(new Kolor("Zielony"));

    }
}
