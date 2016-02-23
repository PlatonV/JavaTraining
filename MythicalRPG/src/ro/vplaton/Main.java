package ro.vplaton;

import ro.vplaton.artifacts.Armor;
import ro.vplaton.artifacts.Weapon;
import ro.vplaton.characters.Character;
import ro.vplaton.characters.Elf;
import ro.vplaton.characters.Necromancer;

/**
 * Created by plato on 2/23/2016.
 */
public class Main {

    public static void attack(Character attacker, Character defender) {
        int previousHealth = defender.getHealth();
        defender.getDamage(attacker.computeDamage());
        System.out.println(attacker.getName() + " gave " +
                defender.getName() + " " +
                (previousHealth - defender.getHealth()) + " damage");
    }

    public static void main(String[] args) {
        Elf hero = new Elf("Leonidas", 1);
        Necromancer ovidiu = new Necromancer("Ovidiu", 1);

        hero.giveWeapon(new Weapon("Mighty bow", 75));
        hero.giveArmor(new Armor("Pants", 15));

        System.out.println(ovidiu);
        attack(hero, ovidiu);
        System.out.println(ovidiu);
        System.out.println(hero);
        attack(ovidiu, hero);
        System.out.println(hero);
    }
}