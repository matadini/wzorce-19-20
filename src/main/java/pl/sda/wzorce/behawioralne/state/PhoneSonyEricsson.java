package pl.sda.wzorce.behawioralne.state;

class PhoneSonyEricsson implements Phone {

    PhoneBehavState currentBehaveState;

    PhoneSonyEricsson() {
        this.currentBehaveState = new PhoneBahveStateOff(this);
    }

    @Override
    public void call() {
        currentBehaveState.call();
    }

    @Override
    public void callEnd() {
        currentBehaveState.callEnd();
    }

    @Override
    public void sms() {
        currentBehaveState.sms();
    }

    @Override
    public void sendSms() {
        currentBehaveState.sendSms();
    }

    @Override
    public void turnOn() {
        currentBehaveState.turnOn();
    }

    @Override
    public void turnOff() {
        currentBehaveState.turnOff();
    }

    @Override
    public void setState(PhoneState phoneState) {
        if (PhoneState.OFF.equals(phoneState))
            currentBehaveState = new PhoneBahveStateOff(this);
        if (PhoneState.ON.equals(phoneState))
            currentBehaveState = new PhoneBehaveStateOn(this);
    }
}
