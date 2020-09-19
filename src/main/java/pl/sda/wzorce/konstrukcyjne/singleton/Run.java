package pl.sda.wzorce.konstrukcyjne.singleton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


// napisz klase LoggedUser zawierajaca pola Ex1
// nazwe uzytkownika
// czas utworzenia signletonu
// zaimplementuj klase jako singleton w trybie lazy i edger w oddzielnych klasach,
// poronaj wartosci pola czas stworzenia, jaki wniosek z tego plytnie

// napisz klase przechowujaca dane do bazy danych, pola adres, port, login, password E2
// zaimplementuj singleton bezpieczny wielowatkowo w trybie lazy wewnatrz klasy przechowujacej dane



public class Run {
    public static void main(String[] args) {
       // Config instance = SingletonConfigLazy.getInstance();
        ConfigMyown instance = ConfigMyown.getInstance();
        System.out.println(instance.toString());
        new Formularz().work();
        System.out.println(instance.toString());
    }
}
