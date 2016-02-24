package ro.vplaton;

import ro.vplaton.characters.Villain;

import java.util.ArrayList;

/**
 * Created by plato on 2/24/2016.
 */
public class Mission {
    private final String name;
    private ArrayList<Villain> villains;

    public Mission(String name) {
        this.name = name;
        villains = new ArrayList<Villain>(10);
    }

    public String getName() {
        return name;
    }

    public void addVillain(Villain villain) {
        villains.add(villain);
    }

    public ArrayList<Villain> getVillains() {
        ArrayList<Villain> result = new ArrayList<Villain>(10);
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