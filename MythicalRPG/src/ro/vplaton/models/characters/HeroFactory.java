package ro.vplaton.models.characters;

/**
 * Created by plato on 2/29/2016.
 */
public class HeroFactory {

    private static HeroFactory instance;

    private HeroFactory() {}

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero createHero(HeroType type, String name, int level) {
        switch (type) {
            case ELF:
                return new Elf(name, level);
            case KNIGHT:
                return new Knight(name, level);
            case ORC:
                return new Orc(name, level);
            case MAGE:
                return new Mage(name, level);
        }
        return null;
    }
}
