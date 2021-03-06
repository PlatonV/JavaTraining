package ro.vplaton.models.characters;

import ro.vplaton.models.artifacts.Armor;
import ro.vplaton.models.artifacts.Artifact;
import ro.vplaton.models.artifacts.Weapon;

import java.util.ArrayList;

/**
 * Created by plato on 2/23/2016.
 */
public class Hero extends Character {

    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<Artifact> inventory;
    protected HeroType heroType;
    protected int experiece;

    protected Hero(String name, int level) {
        super(name, level);
    }

    public HeroType getHeroType() {
        return heroType;
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

    public void drinkPotion() {
        health += 50;
    }

    @Override
    public void getDamage(int damage) {
        if (armor != null) {
            health -= damage - armor.getDefence();
        } else {
            health -= damage;
        }
        super.getDamage(damage);
    }

    @Override
    public int computeDamage() {
        if (weapon != null) {
            return 10 + weapon.getDamage() + (level / 2);
        } else {
            return 10;
        }
    }

    public String getClassString() {
        if (this instanceof Knight) {
            return "Knight";
        }
        if (this instanceof Orc) {
            return "Orc";
        }
        if (this instanceof Mage) {
            return "Mage";
        }
        if (this instanceof Elf) {
            return "Elf";
        }
        return "Hero";
    }
}
