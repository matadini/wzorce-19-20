package pl.sda.wzorce.behawioralne.state;

class PhoneNokia implements Phone {
    PhoneState state = PhoneState.OFF;

    @Override
    public void call() {
        if (state.equals(PhoneState.OFF) || state.equals(PhoneState.SMS)) {
            System.out.println("Nie moge zadzwonic");
        }
        if (state.equals(PhoneState.ON)) {
            System.out.println("Dzwonie");
            state = PhoneState.CALL;
        }
    }

    @Override
    public void callEnd() {
        if (state.equals(PhoneState.CALL)) {
            state = PhoneState.ON;
        }
    }

    @Override
    public void sms() {
        if (state.equals(PhoneState.ON)) {
            System.out.println("pisze smsa");
        } else {
            System.out.println(" nie moge pisac smsa");

        }
    }

    @Override
    public void sendSms() {
        if (PhoneState.SMS.equals(state)) {
            state = PhoneState.ON;
        }
    }

    @Override
    public void turnOn() {
        if (PhoneState.OFF.equals(state)) {
            state = PhoneState.ON;
            System.out.println("phone start");
        } else {
            System.out.println("nie moge wlaczyc telefony ponownie!");
        }
    }

    @Override
    public void turnOff() {
        if (PhoneState.ON.equals(state)) {
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
