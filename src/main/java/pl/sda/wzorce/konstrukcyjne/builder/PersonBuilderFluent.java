package pl.sda.wzorce.konstrukcyjne.builder;

// utworz klase Person z nastepujacymi polami:
// - imie, nazwisko, plec, data urodzenia (localdate), pesel
// 1. zaimplementuj builder jako oddzielna klase wraz z wartosciami domyslnymi
// 2. zaimplementuj builder jako klase wewnatrzna person, przykladowa nazwa: InternalBuilder
// w przypadku domyslnej wartosci nr. pesel wyswiet na ekranie ostrzezenie ze numer pesel przyjmie wartosc domyslna
// 3. korzystajac z ponizszego kawalka kodu zaimplementuj builder w stylu fluen
class PersonBuilderFluent {
    String name;
    String surname;
    int age;
    Boolean hasACar;

    // ...
    PersonBuilderFluent withName(String name) {
        this.name = name;
        return this;
    }

    PersonBuilderFluent withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    Person create() {
        return new Person(name, surname, age, hasACar);
    }
}
