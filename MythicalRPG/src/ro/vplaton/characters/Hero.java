package ro.vplaton.characters;

import ro.vplaton.artifacts.*;

/**
 * Created by plato on 2/23/2016.
 */
public class Hero extends Character {

    protected Weapon weapon;
    protected Armor armor;

    public Hero(String name, int level) {
        super(name, level);
    }

    public void giveWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void giveArmor(Armor armor) {
        this.armor = armor;
    }

    public void levelUp() {
        level++;
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
