package ro.vplaton.characters;

import ro.vplaton.artifacts.*;

import java.util.ArrayList;

/**
 * Created by plato on 2/23/2016.
 */
public class Hero extends Character {

    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<Artifact> inventory;
    protected int experiece;

    public Hero(String name, int level) {
        super(name, level);
    }

    public void equipItem(Artifact artifact) {
        if (artifact instanceof Armor) {
            armor = (Armor) artifact;
        } else {
            weapon = (Weapon) artifact;
        }
    }

    public void equipItem(String itemName) {
        for (Artifact item: inventory) {
            if (item.getName() == itemName) {
                if (item instanceof Armor) {
                    armor = (Armor) item;
                } else {
                    weapon = (Weapon) item;
                }
            }
        }
    }

    public void giveItem(Artifact artifact) throws ArrayStoreException {
        if (inventory.size() < level * 2) {
            inventory.add(artifact);
        } else {
            throw new ArrayStoreException("No more inventory space!");
        }
    }

    public void giveExperience(int amount) {
        experiece += amount;
        if (experiece > level * 10) {
            experiece = 0;
            level++;
        }
    }

    @Override
    public void getDamage(int damage) {
        health -= damage - armor.getDefence();
        super.getDamage(damage);
    }

    @Override
    public int computeDamage() {
        if (weapon != null) {
            return weapon.getDamage() + (level / 2);
        } else {
            return 0;
        }
    }
}
