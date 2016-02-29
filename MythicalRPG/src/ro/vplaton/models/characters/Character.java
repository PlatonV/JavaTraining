package ro.vplaton.models.characters;

import java.util.Observable;

/**
 * Created by plato on 2/23/2016.
 */
public abstract class Character extends Observable {
    protected int health;
    protected int level;
    protected boolean isDead;
    protected final String name;
    private final int id;
    private static int idCounter = 0;

    protected Character(String name, int level) {
        super();
        this.level = level;
        this.name = name;
        this.isDead = false;
        this.id = idCounter;
        idCounter++;
    }

    private void stateChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    public int getId() {
        return id;
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
        if (health <= 0) {
            isDead = true;
        }
        stateChanged();
    }

    public boolean isDead() {
        return isDead;
    }

    public abstract int computeDamage();

    @Override
    public String toString() {
        return "[" + id + "]" + name + " has " + health + "hp";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Character) {
            return this.id == ((Character) obj).id;
        } else {
            return false;
        }
    }

    public void saveData(String filePath) {
    }
}
