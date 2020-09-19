package pl.sda.wzorce.strukturalne.proxy;

class TerminatorIbm implements Terminator {

    @Override
    public void shot() {
        System.out.println("terminator ibm strzela");
    }

    @Override
    public void fight() {
        System.out.println("terminator ibm walczy");
    }
}
