package pl.sda.wzorce.behawioralne.ex9;

// utworz interfejsy dla producenta (rozglosnia radiowa) i subskrybentow (odbiornik)
// niech metody producenta i subskrybentow jako argument przyjmuje zmienna string ktora
// ma przechowywac tytul utworu do zagrania, wykonaj przykladowe "graanie na zadanie"
// 1. zaprojektuj interfejsy
// 2. utworz klase implementujaca interfejs producenta
// 3. utworz 2-3 klasy implementujace interfejs subskrybenta
// niech kazda klasa subskrybenta inaczej informuje o tytule utworu ktory odbiera
// 4. zaprezentuj uzycie producenta
// 5. ukryj klasy implementujace producenta i subskrybenta za pomoca wzorca: FactoryMethod
// aby w metodzie main() korzystac tylko z interfejsow bez wspominania o klasach


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

interface Producer {
    void sendSignal(String title);
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
}

interface Subscriber {
    void update(String title);
}

class RozglosniaRadiowa implements Producer {
    private final List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void sendSignal(String title) {
        subscriberList.forEach(s -> s.update(title));
    }
    @Override
    public void subscribe(Subscriber subscriber) {
        if (!subscriberList.contains(subscriber))
            subscriberList.add(subscriber);
    }
    @Override
    public void unSubscribe(Subscriber subscriber) {
        if (subscriberList.contains(subscriber))
            subscriberList.remove(subscriber);
    }
}
class ProducerFactory {
    static Producer create() {
        return new RozglosniaRadiowa();
    }
}

@RequiredArgsConstructor
class Odbiornik1 implements Subscriber {
    private final String serial;
    @Override
    public void update(String title) {
        System.out.println("Odbiornik o numerze: " + serial + " gra utwór: " + title);
    }
}

@RequiredArgsConstructor
class Odbiornik2 implements Subscriber {
    private final String serial;
    @Override
    public void update(String title) {
        System.out.println("Odbiornik biurowy o numerze: " + serial + " gra utwór: " + title);
    }
}

@RequiredArgsConstructor
class Odbiornik3 implements Subscriber {
    private final String name;
    @Override
    public void update(String title) {
        System.out.println("Odbiornik, którego właścicielem jest: " + name + " gra utwór: " + title);
    }
}

public class ObserverTask {
  public static void main(String[] args) {
    Subscriber o1 = new Odbiornik1("A234");
    Subscriber o2 = new Odbiornik2("B345");
    Subscriber o3 = new Odbiornik3("Krzysiek");
    Producer radioZet = ProducerFactory.create();
    radioZet.subscribe(o1);
    radioZet.subscribe(o2);
    radioZet.subscribe(o3);
    radioZet.sendSignal("Dziewczyno z kebabem");

  }
}
