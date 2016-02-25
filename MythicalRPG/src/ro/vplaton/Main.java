package ro.vplaton;

import ro.vplaton.characters.*;
import ro.vplaton.characters.Character;

import java.io.IOException;

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

    public static void saveGame(Player player) {
        try {
            PlayerSaver.savePlayer(player);
        }
        catch  (Exception e) {
            System.out.println("Cannot save");
        }
    }

    public static void playMission(Player player, Mission mission) {
        int turn = 1;
        System.out.println("Player \"" + player.getUsername() + "\" has started entered " + mission.getName() + " with " + player.getHero().getName());
        player.selectHero(player.getHeroes().get(0).getName());
        while (!mission.isFinished() && !player.getHero().isDead()) {
            System.out.println("Turn: " + turn);
            for (Villain v: mission.getVillains()) {
                System.out.println(player.getHero());
                attack(player.getHero(), v);
                System.out.println(v);
                if (v.isDead()) {
                    System.out.println(v.getName() + " has died...");
                    player.getHero().giveExperience(v.getLevel());
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
        saveGame(player);
    }

    public static void main(String[] args) {
        Mission mission = null;
        MissionLoader missionLoader = new MissionLoader("missions");
        try {
            mission = missionLoader.loadMission("Level1");
        }
        catch (IOException e) {
            System.out.println("Mission not found!");
        }
        catch (Exception e) {
            System.out.println("Error loading mission!");
        }

        try {
            playMission(PlayerLoader.loadPlayer("player1"), mission);
        } catch (Exception e) {
            System.out.println("Could not load player!");
        }
    }
}
