package ro.vplaton;

import ro.vplaton.models.Player;
import ro.vplaton.models.characters.*;

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
                player.addHero(HeroFactory.getInstance().createHero(HeroType.ELF, data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Orc")) {
                player.addHero(HeroFactory.getInstance().createHero(HeroType.ORC, data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Mage")) {
                player.addHero(HeroFactory.getInstance().createHero(HeroType.MAGE, data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Knight")) {
                player.addHero(HeroFactory.getInstance().createHero(HeroType.KNIGHT, data[0], Integer.parseInt(data[1])));
            }
        }
        return player;
    }
}
