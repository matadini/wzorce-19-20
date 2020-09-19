package pl.sda.wzorce.konstrukcyjne.singleton;

class SingletonConfigLazy {

    private static Config config;

    public static synchronized Config getInstance() {
        if (config == null) {
            config = new Config("janusz", "nasacz123", "localhost", "88");
        }
        return config;
    }
}
