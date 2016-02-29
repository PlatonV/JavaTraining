package ro.vplaton.models.characters;

/**
 * Created by plato on 2/23/2016.
 */
public class Orc extends Hero {
    protected Orc(String name, int level) {
        super(name, level);
        health = 350 + level * 10;
    }
}
