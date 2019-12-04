/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.items;

import game.application.exceptions.NonAvailableActionException;
import game.application.interfaces.Actionnable;
import game.application.interfaces.Usable;
import game.application.places.Place;

/**
 *
 * @author Fabien
 */
public class Chest extends Item implements Actionnable {
    
    private Place place;
    private Item containedItem;
    private boolean locked;
    
    public Chest(String NAME, String DESCRIPTION, boolean locked, Item i, Place p) {
        super(NAME, DESCRIPTION);
        this.locked = locked;
        this.containedItem = i;
        this.place = p;
    }

    public void unlock() {
        this.locked = false;
    }
    
    public void lock() {
        this.locked = true;
    }
    
    @Override
    public void action(Usable u) throws NonAvailableActionException {
        if(!ChestKey.isChestKey(u)) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.locked == false) {
            throw new NonAvailableActionException("Vous essayez d'ouvrir une porte déjà ouverte ...");
        }
        else {
            this.unlock();
            this.place.addItem(containedItem);
        }
    }
    
    @Override
    public String toString() {
        String message;
        if(this.locked) {
            message = "Un coffre fermé.";
        }
        else {
            message = "Un coffre ouvert, il contient: \n " + this.containedItem.lookedInBag();
        }
        return message;
    }
    
}
