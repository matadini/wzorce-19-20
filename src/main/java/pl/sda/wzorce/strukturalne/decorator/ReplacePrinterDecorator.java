package pl.sda.wzorce.strukturalne.decorator;

class ReplacePrinterDecorator extends PrinterDecotrator {

    public ReplacePrinterDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String data) {
        // tutaj zmiaesz
        data = data.replace("E", "3");
        printer.print(data);
    }
}
