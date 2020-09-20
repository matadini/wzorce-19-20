package pl.sda.wzorce.behawioralne.observer;

public class ObserverApp {

    public static void main(String[] args) {

        Person jas = new Person("jas");
        Person ola = new Person("ola");
        Company ibm = new Company("ibm");

        Procuder cdaction = ProducerFactory.create();
        cdaction.subscribe(ola);
        cdaction.subscribe(jas);
        cdaction.subscribe(ibm);
        cdaction.sendSignal();
    }

}

