package pl.sda.wzorce.konstrukcyjne.singleton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
class ConfigMyown {
    String username;
    String password;
    String address;
    String port;

    private static ConfigMyown config;

    public static synchronized ConfigMyown getInstance() {
        if (config == null) {
            config = new ConfigMyown("janusz", "nasacz123", "localhost", "88");
        }
        return config;
    }
}
