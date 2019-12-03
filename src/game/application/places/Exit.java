package game.application.places;

import game.application.character.Character;
import game.application.exceptions.LockedExitException;

public class Exit {
    
    private final String DESCRIPTION;
    private final String NAME;

    public Exit(String Description, String name) {
        this.DESCRIPTION = Description;
        this.NAME = name;
    }
    
    public boolean canPass(Character c) throws LockedExitException {
        if(c.getLife() < 1) {
            throw new LockedExitException();
        }
        return true;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getNAME() {
        return NAME;
    }
}