package ro.vplaton.characters;

/**
 * Created by plato on 2/23/2016.
 */
public class Knight extends Hero {
    public Knight(String name, int level) {
        super(name, level);
        health = 300 + level * 10;
    }
}
