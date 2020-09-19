package pl.sda.wzorce.strukturalne.adapter;



// ludzie z polski nie lubia zagranicznych nazw ;)
// napisz klase Person z polami, name, surname, age, birthDate
// napisz interfejs o nazwie Osoba z metodami getImie(), getNazwisko() aby
// napisz klase adaptera implementujacy interfejs osoba
// aby programista no-english mogl korzystac z instancji klasy Person bez watpliwosci

class AdapterApp {
    public static void main(String[] args) {
        // uzycie starego serwisu
        OldService oldService = new OldService();
        oldService.showPerson("jan", "kowalski");

        // uzycie nowego serwisu
        ModernService service = new ModernServiceAdapter(oldService);
        service.renderData(new Person("jan", "kowalski"));
    }
}

