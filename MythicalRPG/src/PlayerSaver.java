import ro.vplaton.models.Player;
import ro.vplaton.models.characters.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by plato on 2/25/2016.
 */
public class PlayerSaver {
    public static void savePlayer(Player player) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("data\\" + player.getUsername() + ".plr"));
        for (Hero hero: player.getHeroes()) {
            writer.println(hero.getName() + " " + hero.getLevel() + " " + hero.getClass().getSimpleName());
        }
    }
}
