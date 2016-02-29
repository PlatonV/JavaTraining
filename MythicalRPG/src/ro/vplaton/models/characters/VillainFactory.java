package ro.vplaton.models.characters;

/**
 * Created by plato on 2/29/2016.
 */
public class VillainFactory {
    private static VillainFactory instance;

    private VillainFactory() {}

    public static VillainFactory getInstance() {
        if (instance == null) {
            instance = new VillainFactory();
        }
        return instance;
    }

    public Villain createVillain(VillainType type, String name, int level) {
        switch (type) {
            case DARK_MAGE:
                return new DarkMage(name, level);
            case DEVIL:
                return new Devil(name, level);
            case NECROMANCER:
                return new Necromancer(name, level);
        }
        return null;
    }
}
