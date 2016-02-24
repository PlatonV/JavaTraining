package ro.vplaton;

import ro.vplaton.characters.Hero;

/**
 * Created by plato on 2/24/2016.
 */
public class Player {
    private Hero hero;
    private String username;

    public Player(String username, Hero hero) {
        this.username = username;
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public String getUsername() {
        return username;
    }
}
