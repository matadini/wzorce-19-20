package pl.sda.wzorce.strukturalne.decorator;

import java.util.Scanner;


// dekorator
// napisz interfej FightCombo z metoda int calculate(int hits) gdzie
// wynikiem bedzie hits*10, zaimplementuj interfejs w odpowiedniej klasie
// utworz klase bazowa dla dekoratorow dla interfejsu FightCombo
// utworz klase dekoratora ktora bedzie dodawała do rezultatu metody calcuate
// bedzie dodawala wartosc 10
// uzycie metody z dekoratorem i bez wyswietl na ekranie

class DecoratorApp {
    public static void main(String[] args) {
        Printer printerIntel = new PrinterIntel();
        printerIntel.print("ELOSZKA");

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if(next.equals("1")) {
            Printer replacePrinter = new ReplacePrinterDecorator(printerIntel);
            replacePrinter.print("ELOSZKAI");
        } else {
            Printer replacePrinter = new ReplacePrinterDecorator2(printerIntel);
            replacePrinter.print("ELOSZKAI");
        }


    }
}
