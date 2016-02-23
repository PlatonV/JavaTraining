package ro.vplaton.artifacts;

/**
 * Created by plato on 2/23/2016.
 */
public class Weapon extends Artifact {
    private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
