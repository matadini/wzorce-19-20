package pl.sda.wzorce.behawioralne.stategy;

// strategy owner, nasz 'uczen'
interface Context {

    void learn();

    void setStrategy(LearnStrategy strategy);
}
