package ro.vplaton.models;

import ro.vplaton.models.characters.Villain;

import java.util.LinkedList;

/**
 * Created by plato on 2/24/2016.
 */
public class Mission {
    private final String name;
    private LinkedList<Villain> villains;

    public Mission(String name) {
        this.name = name;
        villains = new LinkedList<Villain>();
    }

    public String getName() {
        return name;
    }

    public void addVillain(Villain villain) {
        villains.add(villain);
    }

    public LinkedList<Villain> getVillains() {
        LinkedList<Villain> result = new LinkedList<Villain>();
        for (Villain v: villains) {
            if (!v.isDead()) {
                result.add(v);
            }
        }
        return result;
    }

    public boolean isFinished() {
        int alive = 0;
        for (Villain v: villains) {
            if (!v.isDead()) {
                alive++;
            }
        }
        return alive == 0;
    }
}