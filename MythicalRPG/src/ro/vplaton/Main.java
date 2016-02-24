package ro.vplaton;

import ro.vplaton.artifacts.*;
import ro.vplaton.characters.*;
import ro.vplaton.characters.Character;

import java.util.ArrayList;

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

    public static void playMission(Player player, Mission mission) {
        int turn = 1;
        ArrayList<Villain> deadVillains = new ArrayList<Villain>(10);
        System.out.println("Player \"" + player.getUsername() + "\" has started entered " + mission.getName() + " with " + player.getHero().getName());
        while (!mission.isFinished() && !player.getHero().isDead()) {
            System.out.println("Turn: " + turn);
            for (Villain v: mission.getVillains()) {
                System.out.println(player.getHero());
                attack(player.getHero(), v);
                System.out.println(v);
                if (v.isDead()) {
                    System.out.println(v.getName() + " has died...");
                    continue;
                }
                attack(v, player.getHero());
                if (player.getHero().isDead()) {
                    System.out.println(player.getHero().getName() + " has died...");
                    break;
                }
            }
            turn++;
        }
        if (!player.getHero().isDead()) {
            System.out.println(player.getUsername() + " has won!");
        } else {
            System.out.println(player.getUsername() + " has lost!");
        }
    }

    public static void main(String[] args) {
        Elf hero = new Elf("Leonidas", 1);

        hero.giveWeapon(new Weapon("Mighty bow", 75));
        hero.giveArmor(new Armor("Pants", 15));

        Necromancer ovidiu = new Necromancer("Ovidiu", 1);
        Devil mark = new Devil("Mark", 1);
        DarkMage johann = new DarkMage("Johann", 1);

        Mission level1 = new Mission("Level 1");

        level1.addVillain(ovidiu);
        level1.addVillain(mark);
        level1.addVillain(johann);

        Player player1 = new Player("player1", hero);

        playMission(player1, level1);
    }
}