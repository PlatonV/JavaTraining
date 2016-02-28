package ro.vplaton.controllers;

import ro.vplaton.models.Mission;
import ro.vplaton.MissionLoader;
import ro.vplaton.models.characters.Villain;

import java.io.IOException;

/**
 * Created by plato on 2/28/2016.
 */
public class MissionController {
    private Mission mission;

    public MissionController(Mission mission) {
        this.mission = mission;
    }

    public Villain getVillain() {
        return mission.getVillains().getFirst();
    }

    public Villain nextVillain() {
        return mission.getVillains().removeFirst();
    }
}
