package pl.sda.wzorce.behawioralne.observer;

class ProducerFactory {
    static Procuder create() {
        return new CDAction();
    }
}
