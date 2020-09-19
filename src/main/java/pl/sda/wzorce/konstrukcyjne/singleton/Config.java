package pl.sda.wzorce.konstrukcyjne.singleton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
class Config {
    String username;
    String password;
    String address;
    String port;
}
