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
public abstract class Container extends Item implements Actionnable{
    
    private Place place;
    private Item containedItem;
    private boolean locked;
    
    public Container(String NAME, String DESCRIPTION, boolean locked, Item i, Place p) {
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
    
    public boolean isLocked() {
        return this.locked;
    }
}
