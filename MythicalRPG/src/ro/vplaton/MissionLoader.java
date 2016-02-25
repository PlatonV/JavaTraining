package ro.vplaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by plato on 2/25/2016.
 */
public class MissionLoader {
    protected String directoryPath;

    public MissionLoader(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Mission loadMission(String missionName) throws IOException {
        Mission mission = new Mission(missionName);
        String s;
        BufferedReader reader = new BufferedReader(new FileReader("data\\" + directoryPath + "\\" + missionName + ".mis"));
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        return mission;
    }
}
