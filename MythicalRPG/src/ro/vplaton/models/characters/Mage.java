package ro.vplaton.models.characters;

/**
 * Created by plato on 2/23/2016.
 */
public class Mage extends Hero {
    protected Mage(String name, int level) {
        super(name, level);
        health = 150 + level * 10;
    }
}
