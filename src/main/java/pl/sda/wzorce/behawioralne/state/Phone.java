package pl.sda.wzorce.behawioralne.state;

interface Phone {

    void call();

    void callEnd();

    void sms();

    void sendSms();

    void turnOn();

    void turnOff();

    void setState(PhoneState on);
}
