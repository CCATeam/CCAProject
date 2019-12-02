package game.application.places;

import game.application.Lookable;
import game.application.items.Item;
import game.application.character.Character;
import java.util.*;

public class Place {
    
    private final String NAME;
    private final String DESCRIPTION;
    private final Map<String, Character> CHARACTERS;
    private final Map<String, Exit> EXITS;
    private final Map<String, Item> ITEMS;
    private Map<String, Lookable>lookables;
    
    public Place(String NAME, String DESCRIPTION, Map<String, Character> CHARACTERS, Map<String, Exit> EXITS, Map<String, Item> ITEMS) {
        this.NAME = NAME;
        this.CHARACTERS = CHARACTERS;
        this.EXITS = EXITS;
        this.ITEMS = ITEMS;
        this.DESCRIPTION = DESCRIPTION;
    }
    
    /**
     * Initialize the "ables" Map objects from the data contained in 
     * CHARACTERS, EXITS, ITEMS
     */
    public void initialize() {
        this.lookables = new HashMap<>();
        this.lookables.putAll(Lookable.GetLookables(this.EXITS.values()));
        this.lookables.putAll(Lookable.GetLookables(this.CHARACTERS.values()));
        this.lookables.putAll(Lookable.GetLookables(this.ITEMS.values()));
    }
    
    /**
     * Get a Lookable by its name.
     * @param name String
     * @return Return null if non found object, else the lookable.
     */
    public Lookable getLookable(String name) {
        return this.lookables.get(name);
    }
    
    /**
     * Get an Exit by its name.
     * @param name String
     * @return Return null if non found object, else the lookable.
     */
    public Exit getExit(String name) {   
        return this.EXITS.get(name);
    }
    
    public List<Item> getItems() {
            // TODO - implement Place.getItems
            throw new UnsupportedOperationException();           
    }

    /**
     * 
     * @param s
     * @return 
     */
    public Item getItemByName(String s) {
        return this.ITEMS.get(s);
    }

    /**
     * 
     * @param s
     * @return 
     */
    public Character getCharacterByName(String s) {
       return this.CHARACTERS.get(s);
    }

    public String getNAME() {
        return NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
    @Override
    public String toString() {
        return this.NAME + "\n"
            + "   Description: " + this.DESCRIPTION;
    }

    public void removeItem(int hashCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}