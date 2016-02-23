package ro.vplaton.characters;

/**
 * Created by plato on 2/23/2016.
 */
public class Villain extends Character {
    public Villain(String name, int level) {
        super(name, level);
    }

    public int computeDamage() {
        return 30;
    }
}
