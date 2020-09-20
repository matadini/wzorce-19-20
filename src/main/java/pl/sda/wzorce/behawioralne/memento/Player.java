package pl.sda.wzorce.behawioralne.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Player {
    int score;

    void scoreUp() {
        score += 10;
    }

    void print() {
        System.out.println("Mam tyle punktow: " + score);
    }
}

interface PlayerManager {
    int save(Player player);
    Player load(int saveIndex);
}

class PlayerManagerImpl implements PlayerManager {

    Map<Integer, Player> data = new HashMap<>();
    int seq = 0;

    @Override
    public int save(Player player) {
        seq++;
        Player cloned = new Player(player.getScore());
        data.put(seq, cloned);
        return seq;
    }

    @Override
    public Player load(int saveIndex) {
        return new Player(data.get(saveIndex).getScore());
    }
}

class MementoApp {

    public static void main(String[] args) {

        PlayerManager manager = new PlayerManagerImpl();

        Player player = new Player(0);
        player.scoreUp();
        player.scoreUp();
        player.scoreUp();
        player.print();
        int saveIndex = manager.save(player);
        player.scoreUp();
        player.scoreUp();
        System.out.println("Przed wczytaniem: ");
        player.print();
        player = manager.load(saveIndex);
        System.out.println("Po wczytaniem: ");
        player.print();


    }
}
