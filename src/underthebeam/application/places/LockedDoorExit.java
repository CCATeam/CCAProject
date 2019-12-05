/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.places;

import game.application.exceptions.NonAvailableActionException;
import game.application.interfaces.Usable;
import game.application.places.LockedExit;
import underthebeam.application.items.DoorKey;

/**
 *
 * @author Fabien
 */
public class LockedDoorExit extends LockedExit{

    public LockedDoorExit(String Description, String name, boolean locked) {
        super(Description, name, locked);
    }
    
    @Override
    public void action(Usable u) throws NonAvailableActionException {
        if(!DoorKey.isDoorKey(u)) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.isLocked() == false) {
            throw new NonAvailableActionException("You are trying to unock an open door ...");
        }
        else {
            this.unlock();
        }
    }
}
