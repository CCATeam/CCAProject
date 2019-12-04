package game.application.items;

import game.application.interfaces.Takeable;
import game.application.interfaces.Usable;

public class FinalKey extends Item implements Takeable, Usable {

	public FinalKey() {
		super("Grand clef", "Clef important qui doit ouvrire un lieu important");
	}
	
    public static boolean isFinalKey(Object o) {
        return o instanceof FinalKey;
    }
}
