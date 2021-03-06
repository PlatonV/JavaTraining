package ro.vplaton.models.characters;

/**
 * Created by plato on 2/23/2016.
 */
public class Villain extends Character {
    protected Villain(String name, int level) {
        super(name, level);
    }

    @Override
    public void getDamage(int damage) {
        health -= damage;
        super.getDamage(damage);
    }

    @Override
    public int computeDamage() {
        return 30 + 5 * level;
    }
}
