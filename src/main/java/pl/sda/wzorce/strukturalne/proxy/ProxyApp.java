package pl.sda.wzorce.strukturalne.proxy;


class ProxyApp {

    public static void main(String[] args) {
        Terminator terminator = new TerminatorIbm();

        Terminator terminatorOlka = new TerminatorProxy("olek", terminator);
        terminatorOlka.fight();
        terminatorOlka.shot();

        Terminator terminatorJanka = new TerminatorProxy("janek", terminator);
        terminatorJanka.fight();
        terminatorJanka.shot();
    }

}
