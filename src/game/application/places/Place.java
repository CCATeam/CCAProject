package game.application.places;

import game.application.interfaces.Actionnable;
import game.application.interfaces.Lookable;
import game.application.items.Item;
import game.application.characters.Character;
import underthebeam.application.characters.enemies.Ennemy;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Place {
    
    private final String NAME;
    private final String DESCRIPTION;
    private Map<String, Character> characters;
    private Map<String, Exit> exits;
    private Map<String, Item> items;
    private Map<String, Lookable>lookables;
    private Map<String, Actionnable>actionnables;
    
    public Place(String name, String description, Map<String, Character> characters, Map<String, Exit> exits, Map<String, Item> items) {
        this.NAME = name;
        this.characters = characters;
        this.exits = exits;
        this.items = items;
        this.DESCRIPTION = description;
    }
    
    /**
     * Initialize the "ables" Map objects from the data contained in 
     * CHARACTERS, EXITS, ITEMS 
     */
    public void initialize() {      
        //If one of the map is null, initialize it
        this.characters = this.characters == null ? new HashMap<>() : this.characters;
        this.exits = this.exits == null ? new HashMap<>() : this.exits;
        this.items = this.items == null ? new HashMap<>() : this.items;
        
        this.lookables = new HashMap<>();
        this.actionnables = new HashMap<>();
        
        //Get the lookables from data
        for(Item i : this.items.values()) {
            if(Lookable.isLookable(i)) {
                this.lookables.put(i.getNAME(), i);
            }           
            if(Actionnable.isActionnable(i)) {
                this.actionnables.put(i.getNAME(), (Actionnable)i);
            }
        }
        
        //Get the actionnable from data
        for(Exit ex : this.exits.values()) {
            if(Lookable.isLookable(ex)) {
                this.lookables.put(((Lookable)ex).getNAME(), (Lookable)ex);
            }   
            if(Actionnable.isActionnable(ex)) {
                this.actionnables.put(ex.getNAME(), (Actionnable)ex);
            }
        }
    }
    
    /**
     * Get the lookables
     * @return a Map<String,Lookable> the string being the name of the 
     * Lookable
     */
    public Map<String,Lookable> getLookables() {
        return this.lookables;
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
        return this.exits.get(name);
    }
    
    public void addItem(Item i) {
        this.items.put(i.getNAME(), i);
    }
    
    public List<Item> getItems() {
        return (List)this.items.values();
    }

    
    /**
     * Get an item by its name
     * @param s
     * @return 
     */
    public Item getItemByName(String s) {
        return this.items.get(s);
    }

    /**
     * Add a character to the characters map
     * @param c 
     */
    public void addCharacter(Character c) {
        if(c != null) {
            this.characters.put(c.getNAME(), c);
        }
    }
    
    /**
     * 
     * @param s
     * @return 
     */
    public Character getCharacterByName(String s) {
       return this.characters.get(s);
    }

    public void removeItem(Item item) {
        for (Map.Entry<String,Item> entry : this.items.entrySet()) {
            if (item==entry.getValue()) {
                this.items.remove(entry.getKey());
                break;
            }
        }
    }
    
    public void removeCharacter(Character chara) {
    	for (Map.Entry<String, Character> entry : this.characters.entrySet()) {
    		if(chara == entry.getValue()) {
    			this.characters.remove(entry.getKey()).setCurrentPlace(null);
    			break;
    		}
    	}
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
}
