package pl.sda.wzorce.strukturalne.ex5;


// dekorator
// napisz interfej FightCombo z metoda int calculate(int hits) gdzie
// wynikiem bedzie hits*10, zaimplementuj interfejs w odpowiedniej klasie
// utworz klase bazowa dla dekoratorow dla interfejsu FightCombo
// utworz klase dekoratora ktora bedzie dodawała do rezultatu metody calcuate
// bedzie dodawala wartosc 10
// uzycie metody z dekoratorem i bez wyswietl na ekranie

import lombok.RequiredArgsConstructor;
import lombok.ToString;


interface FightCombo {
    int calculate(int hits);
}

@ToString
class StandardCombo implements FightCombo {
    @Override
    public int calculate(int hits) {
        return 10*hits;
    }
}

@ToString
@RequiredArgsConstructor
abstract class ComboDecorator implements FightCombo {
   protected final FightCombo fightCombo;
}

@ToString
class ReplaceFightComboDecorator extends ComboDecorator{
    public ReplaceFightComboDecorator(FightCombo fightCombo){
        super (fightCombo);
    }

    @Override
    public int calculate(int hits) {
    return fightCombo.calculate(10)+10;
    }
}



public class Ex5 {
  public static void main(String[] args) {

    FightCombo standardCombo = new StandardCombo();
    System.out.println("Standard combo: " + standardCombo.calculate(10));

    FightCombo replaceFightCombo =  new ReplaceFightComboDecorator(standardCombo);
    System.out.println("Replace Standard Combo: "+ replaceFightCombo.calculate(10));
  }
}
