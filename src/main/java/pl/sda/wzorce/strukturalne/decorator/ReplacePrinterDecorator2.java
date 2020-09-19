package pl.sda.wzorce.strukturalne.decorator;

class ReplacePrinterDecorator2 extends PrinterDecotrator {

    public ReplacePrinterDecorator2(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String data) {
        // tutaj zmiaesz
        data = data.replace("I", "1");
        printer.print(data);
    }
}
