package game.application.items;

import game.application.interfaces.Lookable;

public class Item implements Lookable{

    private final String NAME;
    private final String DESCRIPTION;

    public Item(String NAME, String DESCRIPTION) {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getNAME() {
        return NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
    @Override
    public String toString() {
        return this.NAME + " : " +this.DESCRIPTION;
    }

}