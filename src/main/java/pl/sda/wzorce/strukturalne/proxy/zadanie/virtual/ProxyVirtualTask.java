package pl.sda.wzorce.strukturalne.proxy.zadanie.virtual;

// zadanie dotyczy implementacji w wariancie virtual
// 1. utworz intefejs Terminator z metodami shot() and fight()
// 2. utworz klase implementujaca Terminator np. TerminatorExpensive, zaimplementuj metody
// 3. utworz klase Proxy o nazwie TerminatorProxyExpensive
// w klasie TerminatorProxyExpensive ma znalezc sie pole Terminator
// tak jak w przykladzie z zajec jednak z ta roznica ze ma byc ono
// polem statycznym.
// Sugerujac sie singletonem w trybie lazy zaimplementuj obsluge tworzenia
// obiektu terminatora jedynie w przypadku gdy zostanie wywolana metoda na
// obiekcie proxy, przyklad:
//    public class ExpensiveObjectProxy implements ExpensiveObject {
//        private static ExpensiveObject object;
//
//        @Override
//        public void process() {
//            if (object == null) {
//                object = new ExpensiveObjectImpl();
//            }
//            object.process();
//        }
//    }

import lombok.RequiredArgsConstructor;


interface Terminator {
    void shot();
    void fight();
}

class TerminatorExpensive implements Terminator {
    @Override
    public void shot() {
        System.out.println("Termiantor strzela");
    }

    @Override
    public void fight() {
        System.out.println("Termiantor walczy");
    }
}

@RequiredArgsConstructor
class TermoiantorProxyExpensive implements Terminator {

    private final String user;
    private static Terminator terminator;

    public static Terminator getTerminator(){
        if(terminator == null){
            terminator = new TerminatorExpensive();
        }
        return terminator;
    }

    @Override
    public void shot() {
        if (user.equals("janek")) {
            terminator.fight();
        } else {
            System.out.println("Nie mozesz sie bawic");
        }
    }

    @Override
    public void fight() {
        if (user.equals("janek")) {
            terminator.fight();
        } else {
            System.out.println("Nie mozesz walczyc");
        }
    }
}

class ProxyVirtualTask {
    public static void main(String[] args) {
        Terminator terminator = TermoiantorProxyExpensive.getTerminator();

        Terminator terminatorOlka = new TermoiantorProxyExpensive("olek");
        terminatorOlka.fight();
        terminatorOlka.shot();

        Terminator terminatorJanka = new TermoiantorProxyExpensive("janek");
        terminatorJanka.fight();
        terminatorJanka.shot();
    }

}
