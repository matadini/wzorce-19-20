package pl.sda.wzorce.behawioralne.observer;

import lombok.RequiredArgsConstructor;

// odbierajacy
@RequiredArgsConstructor
class Company implements Subscriber {

    private final String nip;

    @Override
    public void update() {
        System.out.println("firma o nipie: " + nip + "dostala info o nowym numerze, nie kupuejmy");
    }
}
