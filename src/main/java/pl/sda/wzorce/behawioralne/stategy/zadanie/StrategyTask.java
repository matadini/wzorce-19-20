package pl.sda.wzorce.behawioralne.stategy.zadanie;

// utworz klase Context a metodamy setStrategy(Strategy strategia) i metoda draw();
// ktora przechowuje pole PaintingStrategy, metoda draw bedzie delegowala do metody drawLikeMaster
// utworz interfejs PaintingStrategy z metoda drawLikeMaster();
// zaimplementuj interfejs context w klasie np. PainterContext
// utworz 2-3 klasy implementujace PaintingStrategy np. akwarele, olowek.
// w metodzie glownej aplikacji utworz obiekt malarza (PainterContext)
// i ustaw przez setter przykladowa strategie, wykonaj metode draw
// ponownie zmien strategie dla kontekstu i wykonaj metode draw
// zaobserwuj jak zmienia sie zachowanie metody draw(); czy widzisz podobniestwo z wzorcem state?

interface Context {
    void setStrategy(PaintingStrategy strategia);
    void draw();
}

interface PaintingStrategy{
    void drawLikeMaster();
}

class Akwarele implements PaintingStrategy {
    @Override
    public void drawLikeMaster() {
    System.out.println("Maluję farbami");
    }
}

class Olowek implements PaintingStrategy{
    @Override
    public void drawLikeMaster() {
    System.out.println("Maluje olówkiem");
    }
}

class Węgiel implements PaintingStrategy{
    @Override
    public void drawLikeMaster() {
    System.out.println("Maluję węglem");
    }
}

class Artist implements Context{

    private PaintingStrategy paintingStrategy;

    @Override
    public void setStrategy(PaintingStrategy strategia) {
        this.paintingStrategy = strategia;
    }

    @Override
    public void draw() {
        paintingStrategy.drawLikeMaster();
    }
}


public class StrategyTask {
    public static void main(String[] args) {
        Context artystaJanusz = new Artist();
        artystaJanusz.setStrategy(new Olowek());
        artystaJanusz.draw();
        artystaJanusz.setStrategy(new Węgiel());
        artystaJanusz.draw();
        artystaJanusz.setStrategy(new Akwarele());
        artystaJanusz.draw();
    }
}
