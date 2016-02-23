package ro.vplaton.characters;

/**
 * Created by plato on 2/23/2016.
 */
public class Character {
    protected int health;
    protected int level;
    protected String name;

    public Character(String name, int level) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void getDamage(int amount) {
        health -= amount;
    }

    public int computeDamage() {
        return 0;
    }

    public String toString() {
        return name + " has " + health + "hp";
    }
}
