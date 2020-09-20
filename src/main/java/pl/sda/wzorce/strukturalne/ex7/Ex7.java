package pl.sda.wzorce.strukturalne.ex7;

// utworz klase fasadowa ujednolicajaca ich uzycie
// zaprezentuj dzialanie serwisow, za posrednictwem fasady

import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
class ReportFacade {
    private final ReportService reportService;
    private final DatabaseService databaseService;
    private final CalculateService calculateService;
    void generate(String xml) { reportService.generate(); databaseService.generate(xml); }
    void calculate(int value) {calculateService.calculate(value);}

}

public class Ex7 {
  public static void main(String[] args) {
    ReportService reportService = new ReportService();
    DatabaseService databaseService = new DatabaseService();
    CalculateService calculateService = new CalculateService();
    reportService.generate();
    databaseService.generate("xml super");
    calculateService.calculate(100);

    System.out.println("\n======= Fasada ============");
    ReportFacade reportFacade = new ReportFacade(reportService, databaseService, calculateService);
    reportFacade.generate("xml super");
    reportFacade.calculate(100);
  }
}
