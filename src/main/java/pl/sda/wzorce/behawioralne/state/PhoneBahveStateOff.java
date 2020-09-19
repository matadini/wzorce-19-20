package pl.sda.wzorce.behawioralne.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PhoneBahveStateOff implements PhoneBehavState {

    private final Phone phoneStateOwner;

    @Override
    public void call() {
        System.out.println("jestem wylaczony nie zadzwonisz");
    }

    @Override
    public void callEnd() {
        System.out.println("jestem wylaczony nie skonczysz rozmowy");
    }

    @Override
    public void sms() {
        System.out.println("jestem wylaczony nie smsujesz");
    }

    @Override
    public void sendSms() {
        System.out.println("jestem wylaczony nie wyslesz sms");
    }

    @Override
    public void turnOn() {
        phoneStateOwner.setState(PhoneState.ON);
        System.out.println("wlaczam sie....");
    }

    @Override
    public void turnOff() {
        System.out.println("jestem juz wylaczony!");
    }
}
