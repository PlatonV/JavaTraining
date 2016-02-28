package ro.vplaton;

import ro.vplaton.models.Mission;
import ro.vplaton.models.characters.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by plato on 2/25/2016.
 */
public class MissionLoader {
    public static Mission loadMission(String missionName) throws IOException {
        Mission mission = new Mission(missionName);
        String s;
        BufferedReader reader = new BufferedReader(new FileReader("data\\" + missionName + ".mis"));
        while ((s = reader.readLine()) != null) {
            String[] data = s.split(" ");
            if (data[2].equals("Dark Mage")) {
                mission.addVillain(new DarkMage(data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Devil")) {
                mission.addVillain(new Devil(data[0], Integer.parseInt(data[1])));
            } else if (data[2].equals("Necromancer")) {
                mission.addVillain(new Necromancer(data[0], Integer.parseInt(data[1])));
            }
        }
        return mission;
    }
}
