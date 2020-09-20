package pl.sda.wzorce.behawioralne.stategy;

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
