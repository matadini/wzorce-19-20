package pl.sda.wzorce.behawioralne.stategy;


// strategy owner, nasz 'uczen'
interface Context {

    void learn();
    void setStrategy(LearnStrategy strategy);
}

class Student implements Context {

    private LearnStrategy learnStrategy;

    @Override
    public void learn() {
        learnStrategy.learn();
    }

    @Override
    public void setStrategy(LearnStrategy strategy) {
        this.learnStrategy = strategy;
    }
}

// sposob nauki
interface LearnStrategy {
    void learn();
}

class LearnStrategyReading implements LearnStrategy {

    @Override
    public void learn() {
        System.out.println("ucze sie czytajac");
    }
}

class LearnStrategyWithFriends implements LearnStrategy {

    @Override
    public void learn() {
        System.out.println("ucze sie z przyjaciolmi");
    }
}

public class StrategyApp {
    public static void main(String[] args) {
        Context studentMaciej = new Student();
        studentMaciej.setStrategy(new LearnStrategyReading());
        studentMaciej.learn();
        studentMaciej.setStrategy(new LearnStrategyWithFriends());
        studentMaciej.learn();
    }
}
