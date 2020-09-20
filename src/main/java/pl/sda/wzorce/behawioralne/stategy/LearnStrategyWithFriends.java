package pl.sda.wzorce.behawioralne.stategy;

class LearnStrategyWithFriends implements LearnStrategy {

    @Override
    public void learn() {
        System.out.println("ucze sie z przyjaciolmi");
    }
}
