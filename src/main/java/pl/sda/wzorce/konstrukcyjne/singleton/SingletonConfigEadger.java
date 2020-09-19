package pl.sda.wzorce.konstrukcyjne.singleton;

class SingletonConfigEadger {

    private static final Config config = new Config("janusz", "nasacz123", "localhost", "88");

    public static Config getInstance() {
        return config;
    }
}
