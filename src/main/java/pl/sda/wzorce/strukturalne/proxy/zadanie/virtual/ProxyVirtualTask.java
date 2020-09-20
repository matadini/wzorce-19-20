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

class ProxyVirtualTask {




}
