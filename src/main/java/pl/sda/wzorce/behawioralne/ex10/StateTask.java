package pl.sda.wzorce.behawioralne.ex10;

// utworz interfejs CoffeExpress reprezentujacy ekspres do kawy, ma on zawierac metody
// wlacz, wylacz, zaparz kawe, wyczysc sie, setState - nazwy metod moga byc po angielsku
// zaimplementuj interfejs w klasie a wewnatrz klasy obsluguj stany przy pomocy instancji interfejsu
// CoffeExpresState, dla interfejsu utworz 4 klasy implementujace pojedyncze zachowanie
// interfejs CoffeExpressState ma pokrywac sie swoimi metodami z interfejsem CoffeExpress
// dla poszczegolnego stanu np.
// CoffeExpresStateOn
// CoffeExpresStateOff
// CoffeExpresStateMakeCoffe
// CoffeExpresStateCleanUp
// zaprezentuj zmiennosc zachowania metod expresu na przykladzie

import lombok.RequiredArgsConstructor;

enum ExpressState {
    ON, OFF, MAKE_COFFE, CLEAN_UP
}

interface CoffeeExpress {
    void turnOn();
    void turnOff();
    void makeCoffe();
    void makeCoffeEnd();
    void cleanUp();
    void cleanUpEnd();
    void setState(ExpressState on);
}

interface CoffeExpressState {
    void stateTurnOn();
    void stateTurnOff();
    void stateMakeCoffe();
    void stateMakeCoffeEnd();
    void stateCleanUp();
    void stateCleanUpEnd();
}

@RequiredArgsConstructor
class CoffeExpressStateOn implements CoffeExpressState {
    private final CoffeeExpress expressUser;

    @Override
    public void stateTurnOn() {
    System.out.println("Jestem już włączony");
    }

    @Override
    public void stateTurnOff() {
    System.out.println("Wyłączam się");
    }

    @Override
    public void stateMakeCoffe() {
    System.out.println("Jestem włączony. Możesz parzyć kawę.");
    }

    @Override
    public void stateMakeCoffeEnd() {
    System.out.println("Jestem włączony. Możesz skończyć parzyć kawę.");
    }

    @Override
    public void stateCleanUp() {
        System.out.println("Jestem włączony. Możesz rozpocząć czyszczenie.");
    }

    @Override
    public void stateCleanUpEnd() {
        System.out.println("Jestem włączony. Możesz zakończyć czyszczenie");
    }
}

@RequiredArgsConstructor
class CoffeExpressStateOff implements CoffeExpressState {
    private final CoffeeExpress expressUser;

    @Override
    public void stateTurnOn() {
    expressUser.setState(ExpressState.ON);
    System.out.println("Włączam się");
    }

    @Override
    public void stateTurnOff() {
    System.out.println("Jestem już wyłączony.");
    }

    @Override
    public void stateMakeCoffe() {
    System.out.println("Jestem wyłączony, nie zrobisz kawy");
    }

    @Override
    public void stateMakeCoffeEnd() {
    System.out.println("Jestem wyłączony, nie skończysz robić kawy");
    }

    @Override
    public void stateCleanUp() {
    System.out.println("Jestem wyłączony, nie rozpoczniesz czyszczenia");
    }

    @Override
    public void stateCleanUpEnd() {
        System.out.println("Jestem wyłączony, nie zakończysz czyszczenia");
    }
}

class CoffeExpressDelonghi implements CoffeeExpress {
    CoffeExpressState currentExpressState;
    CoffeExpressDelonghi(){
        this.currentExpressState = new CoffeExpressStateOff(this);
    }

    @Override
    public void turnOn() {
        currentExpressState.stateTurnOn();
    }

    @Override
    public void turnOff() {
currentExpressState.stateTurnOff();
    }

    @Override
    public void makeCoffe() {
currentExpressState.stateMakeCoffe();
    }

    @Override
    public void makeCoffeEnd() {
currentExpressState.stateMakeCoffeEnd();
    }

    @Override
    public void cleanUp() {
currentExpressState.stateCleanUp();
    }

    @Override
    public void cleanUpEnd() {
currentExpressState.stateCleanUpEnd();
    }

    @Override
    public void setState(ExpressState expressState) {
    if(ExpressState.OFF.equals(expressState)){
      currentExpressState = new CoffeExpressStateOff(this);
    }
    if(ExpressState.ON.equals(expressState)){
      currentExpressState = new CoffeExpressStateOn(this);
    }
    }
}

class CoffeExpressPhilips implements CoffeeExpress {
   ExpressState state = ExpressState.OFF;

  @Override
  public void turnOn() {
    if(ExpressState.OFF.equals(state)) {
      state = ExpressState.ON;
      System.out.println("expres start");
    } else {
      System.out.println("nie moge wlaczyc expresu ponownie!");
    }
  }

  @Override
  public void turnOff() {
    if(ExpressState.ON.equals(state)) {
      state = ExpressState.OFF;
      System.out.println("express end");
    } else {
      System.out.println("Przestan cos robic na expresie to go wylacze");
    }
  }

  @Override
  public void makeCoffe() {
    if(state.equals(ExpressState.OFF) || state.equals(ExpressState.MAKE_COFFE)) {
      System.out.println("Nie moge zrobić kawy");
    }
    if(state.equals(ExpressState.ON)) {
      System.out.println("Robie kawę");
      state = ExpressState.MAKE_COFFE;
    }
  }

  @Override
  public void makeCoffeEnd() {
    if(state.equals(ExpressState.MAKE_COFFE)) {
      state = ExpressState.ON;
    }
  }

  @Override
  public void cleanUp() {
    if(state.equals(ExpressState.ON)) {
      System.out.println("Czyszczenie expresu");
    } else {
      System.out.println("Nie mogę rozpocząć czyszczenia");
    }
  }

  @Override
  public void cleanUpEnd() {
    if(state.equals(ExpressState.CLEAN_UP)) {
      state = ExpressState.ON;
    }
  }

  @Override
  public void setState(ExpressState on) {

  }
}

public class StateTask {
      public static void main(String[] args) {
          CoffeeExpress expressDelonghi = new CoffeExpressDelonghi();
          expressDelonghi.makeCoffe();
          expressDelonghi.turnOn();
          expressDelonghi.makeCoffe();
          System.out.println("\n");
          CoffeeExpress expressPhilips = new CoffeExpressPhilips();
          expressPhilips.makeCoffe();
          expressPhilips.turnOn();
          expressPhilips.makeCoffe();
      }
}
