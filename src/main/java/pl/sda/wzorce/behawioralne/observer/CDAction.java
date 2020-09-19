package pl.sda.wzorce.behawioralne.observer;

import java.util.ArrayList;
import java.util.List;

// generuje informacje o nowym numerze
class CDAction implements Procuder {

    private final List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void sendSignal() {
        subscriberList.forEach(Subscriber::update);
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        if (!subscriberList.contains(subscriber))
            subscriberList.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        if (subscriberList.contains(subscriber))
            subscriberList.remove(subscriber);
    }
}
