package pl.sda.wzorce.behawioralne.chain;

import java.util.ArrayList;
import java.util.List;



class ChainApp {
    public static void main(String[] args) {
        // lancuch
        List<MyHander> chain = new ArrayList<>();
        chain.add(new HandlerCar());
        chain.add(new HandlerHome());
        chain.add(new HandlerInsurance());

        // zadanie
        Proporsal proporsal = new Proporsal("Janusz Nosacz", Proporsal.Type.CAR);

        // obrobka
        for(MyHander hander : chain) {
            if(hander.test(proporsal)) { // jezeli pani obsluguje papier
                hander.consider(proporsal);
                break;
            }
        }
    }
}
