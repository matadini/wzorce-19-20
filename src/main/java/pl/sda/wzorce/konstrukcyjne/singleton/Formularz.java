package pl.sda.wzorce.konstrukcyjne.singleton;

class Formularz {

    void work() {
        Config instance = SingletonConfigLazy.getInstance();
        System.out.println("konfig z baza w formularzu: " + instance);
        instance.setUsername("jakub");
    }
}
