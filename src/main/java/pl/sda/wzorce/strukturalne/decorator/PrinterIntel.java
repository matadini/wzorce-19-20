package pl.sda.wzorce.strukturalne.decorator;

class PrinterIntel implements Printer {

    @Override
    public void print(String data) {
        System.out.println("INTEL PRINTER: " + data);
    }
}
