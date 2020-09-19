package pl.sda.wzorce.behawioralne.state;

import lombok.RequiredArgsConstructor;


class PhoneApp {
    public static void main(String[] args) {
        Phone phone = new PhoneNokia();
        phone.call();
        phone.turnOn();
        phone.call();

        System.out.println("\n");

        Phone sonyEricsson = new PhoneSonyEricsson();
        sonyEricsson.call();
        sonyEricsson.turnOn();
        sonyEricsson.call();

    }
}
