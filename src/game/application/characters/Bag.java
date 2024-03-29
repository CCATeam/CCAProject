package game.application.characters;

import game.application.items.Item;
import java.util.*;

public class Bag {

    private Map<String, Item> items;

    public Bag() {
        this.items = new HashMap<String, Item>();
    }

    /**
     * 
     * @param nom
     * @return 
     */
    public Item findItem(String nom) {
        return this.items.get(nom);
    }
    
    /**
     * 
     * @param nom
     * @return Item
     */
    public Item removeItem(String nom) {
        return this.items.remove(nom);
    }

    /**
     * 
     * @param item
     */
    public void addItem(Item item) {
        this.items.put(item.getNAME(), item);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Item i : this.items.values()) {
            sb.append(" ")
              .append(i.toString())
              .append("\n");
        }
        return sb.toString();
    }

}