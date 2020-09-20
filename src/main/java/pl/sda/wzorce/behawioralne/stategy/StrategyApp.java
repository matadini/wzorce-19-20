package pl.sda.wzorce.behawioralne.stategy;


public class StrategyApp {
    public static void main(String[] args) {
        Context studentMaciej = new Student();
        studentMaciej.setStrategy(new LearnStrategyReading());
        studentMaciej.learn();
        studentMaciej.setStrategy(new LearnStrategyWithFriends());
        studentMaciej.learn();
    }
}
