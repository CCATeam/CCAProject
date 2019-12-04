package underthebeam.application.items;

import game.application.interfaces.Takeable;
import game.application.interfaces.Usable;
import game.application.items.Item;

public class Umbrella extends Item implements Takeable, Usable {
    
    public Umbrella(String NAME, String DESCRIPTION) {
        super(NAME, DESCRIPTION);
    }
    
    public static boolean isUmbrella(Object o) {
        return o instanceof Umbrella;
    }
}
