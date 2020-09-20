package pl.sda.wzorce.konstrukcyjne.ex1_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
class Config {
    String address;
    String port;
    String login;
    String password;
}


class SingletonConfigLazy {
    private static Config config;
    public static synchronized Config getInstance(){
        if (config == null){
            config = new Config("localhost", "88", "root", "root");
        }
        return config;
    }
}

@Getter
@ToString
@AllArgsConstructor
class LoggedUser {

    private String userName;
    private LocalDateTime time;
}

class SingletonLoggedUserEadger {
    private static final LoggedUser loggedUser = new LoggedUser("janusz", LocalDateTime.now());
    public static LoggedUser getInstance() {
        return loggedUser;
    }
}

class SingletonLoggedUserLazy {
    private static LoggedUser loggedUser;
    public static synchronized LoggedUser getInstance(){
        if (loggedUser == null){
            loggedUser = new LoggedUser("janusz", LocalDateTime.now());
        }
        return loggedUser;
    }
}

public class Ex1 {
    public static void main(String[] args) {
        LoggedUser instance1 = SingletonLoggedUserEadger.getInstance();
        System.out.println(instance1.toString());
        LoggedUser instance2 = SingletonLoggedUserLazy.getInstance();
        System.out.println(instance2.toString());
    }
}




