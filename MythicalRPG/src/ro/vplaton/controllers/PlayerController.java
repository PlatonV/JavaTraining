package ro.vplaton.controllers;

import ro.vplaton.models.Player;
import ro.vplaton.models.characters.Hero;

import java.util.LinkedList;

/**
 * Created by plato on 2/28/2016.
 */
public class PlayerController {
    Player player;

    public PlayerController() {
        player = new Player("player");
    }

    public PlayerController(String name) {
        player = new Player(name);
    }

    public void changeName(String playerName) {
        player.setUsername(playerName);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LinkedList<String> getHeroesNames() {
        LinkedList<String> result = new LinkedList<String>();
        for (Hero h: player.getHeroes()) {
            result.add(h.getName());
        }
        return result;
    }
}
