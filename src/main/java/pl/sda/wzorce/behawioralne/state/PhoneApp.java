package pl.sda.wzorce.behawioralne.state;

import lombok.RequiredArgsConstructor;

enum PhoneState {
    ON, OFF, CALL, SMS
}

interface Phone {
    void call();
    void callEnd();
    void sms();
    void sendSms();
    void turnOn();
    void turnOff();
    void setState(PhoneState on);
}

interface PhoneBehavState {
    void call();
    void callEnd();
    void sms();
    void sendSms();
    void turnOn();
    void turnOff();
}

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

@RequiredArgsConstructor
class PhoneBehaveStateCall implements PhoneBehavState {
    private final Phone phoneOwner;
    @Override
    public void call() {
        System.out.println("już dzwonie");
    }
    @Override
    public void callEnd() {
        System.out.println("rozmowa skończona");
    }
    @Override
    public void sms() {
        System.out.println("nie możesz pisać sms jak dzwonisz");
    }
    @Override
    public void sendSms() {
        System.out.println("nie możesz wysłać sms jak dzwonisz");
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

@RequiredArgsConstructor
class PhoneBehaveStateSMS implements PhoneBehavState {
    private final Phone phoneOwner;
    @Override
    public void call() {
        System.out.println("nie możesz dzwonić jak piszesz sms");
    }
    @Override
    public void callEnd() {
        System.out.println("nie prowadzisz żadnej rozmowy");
    }
    @Override
    public void sms() {
        System.out.println("piszę sms");
    }
    @Override
    public void sendSms() {
        System.out.println("sysyłam sms");
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
        if(PhoneState.OFF.equals(phoneState))
            currentBehaveState = new PhoneBahveStateOff(this);
        if(PhoneState.ON.equals(phoneState))
            currentBehaveState = new PhoneBehaveStateOn(this);
        if(PhoneState.CALL.equals(phoneState))
            currentBehaveState = new PhoneBehaveStateCall(this);
        if(PhoneState.SMS.equals(phoneState))
            currentBehaveState = new PhoneBehaveStateSMS(this);

    }
}

class PhoneNokia implements Phone {
    PhoneState state = PhoneState.OFF;
    @Override
    public void call() {
        if(state.equals(PhoneState.OFF) || state.equals(PhoneState.SMS)) {
            System.out.println("Nie moge zadzwonic");
        }
        if(state.equals(PhoneState.ON)) {
            System.out.println("Dzwonie");
            state = PhoneState.CALL;
        }
    }
    @Override
    public void callEnd() {
        if(state.equals(PhoneState.CALL)) {
            state = PhoneState.ON;
        }
    }
    @Override
    public void sms() {
        if(state.equals(PhoneState.ON)) {
            System.out.println("pisze smsa");
        } else {
            System.out.println(" nie moge pisac smsa");
        }
    }
    @Override
    public void sendSms() {
        if(PhoneState.SMS.equals(state)) {
            state = PhoneState.ON;
        }
    }
    @Override
    public void turnOn() {
        if(PhoneState.OFF.equals(state)) {
            state = PhoneState.ON;
            System.out.println("phone start");
        } else {
            System.out.println("nie moge wlaczyc telefony ponownie!");
        }
    }
    @Override
    public void turnOff() {
        if(PhoneState.ON.equals(state)) {
            state = PhoneState.OFF;
            System.out.println("phone end");
        } else {
            System.out.println("Przestan cos robic na telefonie a go wylacze");
        }
    }
    @Override
    public void setState(PhoneState on) {
    }
}

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