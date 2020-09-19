package pl.sda.wzorce.behawioralne.observer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Person implements Subscriber {

    private final String name;

    @Override
    public void update() {
        System.out.println("osoba: " + name + " dostala info");
    }
}
