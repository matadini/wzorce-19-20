package pl.sda.wzorce.behawioralne.observer;

interface Procuder {
    void sendSignal();

    void subscribe(Subscriber subscriber);

    void unSubscribe(Subscriber subscriber);
}
