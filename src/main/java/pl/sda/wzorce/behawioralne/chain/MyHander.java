package pl.sda.wzorce.behawioralne.chain;

// interfejs dla "okienka"
interface MyHander {
    void consider(Proporsal proporsal);

    boolean test(Proporsal proporsal);
}
