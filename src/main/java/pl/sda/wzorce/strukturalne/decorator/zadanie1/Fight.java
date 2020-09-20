package pl.sda.wzorce.strukturalne.decorator.zadanie1;

import lombok.RequiredArgsConstructor;

interface FightCombo{
    int calculate(int hits);
}

class Fighter implements FightCombo {
    @Override
    public int calculate(int hits) {
        return hits*10;
    }
}

@RequiredArgsConstructor
abstract class FighterDecorator implements FightCombo {
    protected final FightCombo fightCombo;
}

class RepleaceFighterDecorator extends FighterDecorator {
public RepleaceFighterDecorator(FightCombo fightCombo) {super(fightCombo);}
    @Override
    public int calculate(int hits) {
        return hits*10 + 10;
    }
}

public class Fight {
  public static void main(String[] args) {
    FightCombo fighter = new Fighter();
    System.out.println(fighter.calculate(3));

    FightCombo repleaceFighter = new RepleaceFighterDecorator(fighter);

    System.out.println(repleaceFighter.calculate(3));

  }
}
