package ro.vplaton;

import ro.vplaton.characters.Hero;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by plato on 2/24/2016.
 */
public class Player {
    private Hero hero;
    private ArrayList<Hero> heroes;
    private String username;

    public Player(String username) {
        this.username = username;
        this.heroes = new ArrayList<Hero>(5);
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public Hero getHero() {
        return hero;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void selectHero(String heroName) {
        for (Hero h: heroes) {
            if (h.getName() == heroName) {
                hero = h;
            }
        }
    }

    public String getUsername() {
        return username;
    }
}
