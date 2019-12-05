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
import underthebeam.application.characters.Hero;

/**
 *
 * @author Fabien
 */
public class ClassicBeam extends Container {

    public ClassicBeam(String NAME, String DESCRIPTION, boolean locked, Item i, Place p) {
        super(NAME, DESCRIPTION, locked, i, p);
    }
    
    @Override
    public void action(Usable u) throws NonAvailableActionException {
        throw new NonAvailableActionException("Action impossible !");
    }

    @Override
    public String lookedInPlace() {
        this.getPlace().addItem(this.getContainedItem());
        return super.lookedInPlace(); 
    }
}
