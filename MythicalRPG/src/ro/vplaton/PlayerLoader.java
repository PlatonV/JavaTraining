package ro.vplaton;

import ro.vplaton.models.Player;
import ro.vplaton.models.characters.Elf;
import ro.vplaton.models.characters.Knight;
import ro.vplaton.models.characters.Mage;
import ro.vplaton.models.characters.Orc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by plato on 2/25/2016.
 */
public class PlayerLoader {
    public static Player loadPlayer(String playerName) throws IOException {
        Player player = new Player(playerName);
        String s;
        BufferedReader reader = new BufferedReader(new FileReader("data\\" + playerName + ".plr"));
        while ((s = reader.readLine()) != null) {
            String[] data = s.split(" ");
            if (data[2].equals("Elf")) {
                player.addHero(new Elf(data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Orc")) {
                player.addHero(new Orc(data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Mage")) {
                player.addHero(new Mage(data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Knight")) {
                player.addHero(new Knight(data[0], Integer.parseInt(data[1])));
            }
        }
        return player;
    }
}
