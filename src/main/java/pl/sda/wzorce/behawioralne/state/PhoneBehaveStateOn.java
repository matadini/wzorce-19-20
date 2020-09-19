package pl.sda.wzorce.behawioralne.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PhoneBehaveStateOn implements PhoneBehavState {

    private final Phone phoneOwner;

    @Override
    public void call() {
        System.out.println("jestem wlaczony  zadzwonisz");
    }

    @Override
    public void callEnd() {
        System.out.println("jestem wlaczony mozesz skonczyc rozmowe");
    }

    @Override
    public void sms() {
        System.out.println("jestem wlaczony mozesz sms");
    }

    @Override
    public void sendSms() {

    }

    @Override
    public void turnOn() {
        System.out.println("jestem juz wlaczony");
    }

    @Override
    public void turnOff() {
        System.out.println("wylaczam sie");

    }

}
