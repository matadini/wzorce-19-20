package pl.sda.wzorce.strukturalne.facade.zadanie1;


import lombok.RequiredArgsConstructor;

class ReportService {
    void generate() {
        System.out.println("generuje raport");
    }
}

class DatabaseService {
    void save(String xml) {
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
class ServiceFasada{
    private final ReportService reportService;
    private final DatabaseService databaseService;
    private final CalculateService calculateService;
     void generate(){reportService.generate();}
    void save(String xml){databaseService.save(xml);}
     void calculate(int value){calculateService.calculate(value);}
}

public class Service {
  public static void main(String[] args) {
      ReportService reportService = new ReportService();
      DatabaseService databaseService = new DatabaseService();
      CalculateService calculateService = new CalculateService();

      ServiceFasada serviceFasada = new ServiceFasada(reportService, databaseService, calculateService);
      serviceFasada.generate();
      serviceFasada.save("Faktura nr 15695");
      serviceFasada.calculate(1586);
  }
}
