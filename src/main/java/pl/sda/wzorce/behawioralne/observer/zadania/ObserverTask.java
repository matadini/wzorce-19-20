package pl.sda.wzorce.behawioralne.observer.zadania;

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

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ObserverTask {
    public static void main(String[] args) {
        Janusz janusz = new Janusz("Janusz");
        Marysia marysia = new Marysia("Marysia");
        Zygmunt zygmunt = new Zygmunt("Zygmunt");

        Producer radio = ProducerFactory.create();
        radio.subscribe(janusz);
        radio.subscribe(marysia);
        radio.subscribe(zygmunt);

        radio.granieNaZadanie("Kolorowe jarmarki");
        radio.granieNaZadanie("Radio song");
    }
}

interface Producer {
    void granieNaZadanie(String song);
    void subscribe(Subsciber subsciber);

}

interface Subsciber {
    void update(String song);
}

class Radio implements Producer {

    private final List<Subsciber> subsciberList = new ArrayList<>();

    @Override
    public void granieNaZadanie(String song) {
        subsciberList.forEach(s -> s.update(song));
    }

    @Override
    public void subscribe(Subsciber subsciber) {
        subsciberList.add(subsciber);
    }


}
@AllArgsConstructor
class Janusz implements Subsciber{

    String name;

    @Override
    public void update(String song) {
        System.out.println(name + " słucha piosenki o nazwie " + song);
    }
}
@AllArgsConstructor
class Marysia implements Subsciber{

    String name;

    @Override
    public void update(String song) {
        System.out.println(name + " słucha piosenki o nazwie " + song);
    }
}
@AllArgsConstructor
class Zygmunt implements Subsciber{

    String name;

    @Override
    public void update(String song) {
        System.out.println(name + " słucha piosenki o nazwie " + song);
    }
}

class ProducerFactory{
    static Producer create(){
        return new Radio();
    }
}


