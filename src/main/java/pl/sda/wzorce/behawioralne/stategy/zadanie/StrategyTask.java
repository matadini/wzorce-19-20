package pl.sda.wzorce.behawioralne.stategy.zadanie;

// utworz klase Context a metodamy setStrategy(Strategy strategia) i metoda draw();
// ktora przechowuje pole PaintingStrategy, metoda draw bedzie delegowala do metody
// drawLikeMaster
// utworz interfejs PaintingStrategy z metoda drawLikeMaster();
// zaimplementuj interfejs context w klasie np. PainterContext
// utworz 2-3 klasy implementujace PaintingStrategy np. akwarele, olowek.
// w metodzie glownej aplikacji utworz obiekt malarza (PainterContext)
// i ustaw przez setter przykladowa strategie, wykonaj metode draw
// ponownie zmien strategie dla kontekstu i wykonaj metode draw
// zaobserwuj jak zmienia sie zachowanie metody draw(); czy widzisz podobniestwo z wzorcem
// state?

import lombok.AllArgsConstructor;

public class StrategyTask {
  public static void main(String[] args) {
    PainterContext malarz = new PainterContext();
    malarz.setStrategy(new Akwarele());
    malarz.draw();
    malarz.setStrategy(new Olowek());
    malarz.draw();
  }
}

class PainterContext {
  PaintingStrategy paintingStrategy;

  void setStrategy(PaintingStrategy strategy) {
    paintingStrategy = strategy;
  }

  void draw() {
    paintingStrategy.drawLikeMaster();
  }
}

interface PaintingStrategy {
  void drawLikeMaster();
}

class Akwarele implements PaintingStrategy {

  @Override
  public void drawLikeMaster() {
    System.out.println("malujesz akwarelami");
  }
}

class Olowek implements PaintingStrategy {

  @Override
  public void drawLikeMaster() {
    System.out.println("malujesz olowkiem");
  }
}
