/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.items;

import game.application.exceptions.NonAvailableActionException;
import game.application.interfaces.Usable;
import game.application.items.Container;
import game.application.items.Item;
import game.application.places.Place;

/**
 *
 * @author Fabien
 */
public class Chest extends Container {
    
    public Chest(String NAME, String DESCRIPTION, boolean locked, Item i, Place p) {
        super(NAME, DESCRIPTION, locked, i, p);
    }
    @Override
    public void action(Usable u) throws NonAvailableActionException {
        if(!ChestKey.isChestKey(u)) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.isLocked() == false) {
            throw new NonAvailableActionException("Vous essayez d'ouvrir une porte déjà ouverte ...");
        }
        else {
            this.unlock();
            this.getPlace().addItem(this.getContainedItem());
        }
    }
    
    @Override
    public String toString() {
        String message;
        if(this.isLocked()) {
            message = "Un coffre fermé.";
        }
        else {
            message = "Un coffre ouvert, il contient: \n " + this.getContainedItem().lookedInPlace();
        }
        return message;
    }
    
}
