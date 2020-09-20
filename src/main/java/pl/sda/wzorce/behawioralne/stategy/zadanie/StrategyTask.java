package pl.sda.wzorce.behawioralne.stategy.zadanie;

// utworz klase Context z metodami setStrategy(Strategy strategia) i metoda draw();
// ktora przechowuje pole PaintingStrategy, metoda draw bedzie delegowala do metody drawLikeMaster
// utworz interfejs PaintingStrategy z metoda drawLikeMaster();
// zaimplementuj interfejs context w klasie np. PainterContext
// utworz 2-3 klasy implementujace PaintingStrategy np. akwarele, olowek.
// w metodzie glownej aplikacji utworz obiekt malarza (PainterContext)
// i ustaw przez setter przykladowa strategie, wykonaj metode draw
// ponownie zmien strategie dla kontekstu i wykonaj metode draw
// zaobserwuj jak zmienia sie zachowanie metody draw(); czy widzisz podobniestwo z wzorcem state?


interface Context {
    void draw();
    void setStrategy(PaintingStrategy strategia);
}

//sposób malowania
interface PaintingStrategy {
    void drawLikeMaster();
}

class PaintingStrategyWatercolors implements PaintingStrategy{
    @Override
    public void drawLikeMaster() {
        System.out.println("Maluje akwarelami");
    }
}

class PaintingStrategyOil implements PaintingStrategy{
    @Override
    public void drawLikeMaster() {
        System.out.println("Maluje farbami olejnymi");
    }
}

class PaintingStrategyPoster implements PaintingStrategy{
    @Override
    public void drawLikeMaster() {
        System.out.println("Maluje farbami plakatowymi");
    }
}


class PainterContext implements Context {
    private PaintingStrategy paintingStrategy;

    @Override
    public void draw() {
        paintingStrategy.drawLikeMaster();
    }

    @Override
    public void setStrategy(PaintingStrategy strategy) {
       this.paintingStrategy = strategy;
    }
}

public class StrategyTask {
    public static void main(String[] args) {
        Context malarzMistrz = new PainterContext();
        malarzMistrz.setStrategy(new PaintingStrategyOil());
        malarzMistrz.draw();
        malarzMistrz.setStrategy(new PaintingStrategyPoster());
        malarzMistrz.draw();
    }
}
