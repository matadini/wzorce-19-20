package pl.sda.wzorce.strukturalne.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class PrinterDecotrator implements Printer {

    protected final Printer printer; // obiekt ktory dekotujemy, nasz 'ludzik'
}
