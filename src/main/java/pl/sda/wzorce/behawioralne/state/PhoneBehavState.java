package pl.sda.wzorce.behawioralne.state;

interface PhoneBehavState {
    void call();

    void callEnd();

    void sms();

    void sendSms();

    void turnOn();

    void turnOff();
}
