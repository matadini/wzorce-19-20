package pl.sda.wzorce.strukturalne.facade;

// fasada
// majac do dyspozycji klasy serwisowe
class ReportService {
    void generate() {
        System.out.println("generuje raport");
    }
}

class DatabaseService {
    void generate(String xml) {
        System.out.println("zapisuje xml: " + xml);
    }
}

class CalculateService {
    private int premium = 100;

    void calculate(int value) {
        System.out.println("obliczono wartosc faktury: " + value*premium);
    }
}
// utworz klase fasadowa ujednolicajaca ich uzycie do jednej klasy
// zaprezentuj dzialanie serwisow, za posrednictwem fasady

class FacadeApp {

    public static void main(String[] args) {
        // stary zepol
        FakturaDb fakturaDb = new FakturaDb();
        NotificationService notificationService = new NotificationService();
        fakturaDb.save("xml super");
        notificationService.execute();

        //
        FakturaFacade fakturaFacade = new FakturaFacade(notificationService,  fakturaDb);
        fakturaFacade.save("xml super");
        fakturaFacade.sendMail();
    }

}
