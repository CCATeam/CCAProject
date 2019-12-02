package game.application.places;

import game.application.interfaces.Actionnable;
import game.application.interfaces.Lookable;
import game.application.items.Item;
import game.application.character.Character;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Place {
    
    private final String NAME;
    private final String DESCRIPTION;
    private final Map<String, Character> CHARACTERS;
    private final Map<String, Exit> EXITS;
    private final Map<String, Item> ITEMS;
    private Map<String, Lookable>lookables;
    private Map<String, Actionnable>actionnables;
    
    public Place(String NAME, String DESCRIPTION, Map<String, Character> CHARACTERS, Map<String, Exit> EXITS, Map<String, Item> ITEMS) {
        this.NAME = NAME;
        this.CHARACTERS = CHARACTERS;
        this.EXITS = EXITS;
        this.ITEMS = ITEMS;
        this.DESCRIPTION = DESCRIPTION;
    }
    
    /**
     * Initialize the "ables" Map objects from the data contained in 
     * CHARACTERS, EXITS, ITEMS and attribute the current map to the Characters
     */
    public void initialize() {
        
        for(Character c : this.CHARACTERS.values()) {
            c.setPlaceCourante(this);
        }
        
        this.lookables = new HashMap<>();
        this.actionnables = new HashMap<>();

        //Get the lookables from data
        for(Item i : this.ITEMS.values()) {
            if(Lookable.isLookable(i)) {
                this.lookables.put(i.getNAME(), i);
            }
            
            if(Actionnable.isActionnable(i)) {
                this.actionnables.put(i.getNAME(), (Actionnable)i);
            }
        }
        
        //Get the actionnable from data
        for(Exit ex : this.EXITS.values()) {
            if(Lookable.isLookable(ex)) {
                this.lookables.put(((Lookable)ex).getNAME(), (Lookable)ex);
            }
            
            if(Actionnable.isActionnable(ex)) {
                this.actionnables.put(ex.getNAME(), (Actionnable)ex);
            }
        }
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
     * Get a Lookable by its name.
     * @param name String
     * @return Return null if non found object, else the lookable.
     */
    public Actionnable getActionnable(String name) {
        return this.actionnables.get(name);
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
        List<Item> res = new ArrayList<>();
        this.ITEMS.values().forEach((item) -> {
            res.add(item);
        });
        return res;
    }

    /**
     * 
     * @param s
     * @return 
     */
    public Item getItemByName(String s) {
        return this.ITEMS.get(s);
    }

    public void addCharacter(Character c) {
        this.CHARACTERS.put(c.getNAME(), c);
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

    public void removeItem(Item item) {
        for (Map.Entry<String,Item> entry : this.ITEMS.entrySet()) {
            if (item==entry.getValue()) {
                this.ITEMS.remove(entry.getKey());
            }
        }
    }
    
}
