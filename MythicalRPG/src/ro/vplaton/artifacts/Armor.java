package ro.vplaton.artifacts;

/**
 * Created by plato on 2/23/2016.
 */
public class Armor extends Artifact {
    private int defence;

    public Armor(String name, int defence) {
        super(name);
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }
}
