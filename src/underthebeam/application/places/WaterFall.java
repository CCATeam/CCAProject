/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.places;

import game.application.exceptions.NonAvailableActionException;
import game.application.interfaces.Usable;
import game.application.places.LockedExit;
import underthebeam.application.items.Torch;

/**
 *
 * @author Fabien
 */
public class WaterFall extends LockedExit {
    
     public WaterFall(String Description, String name, boolean locked) {
        super(Description, name, locked);
    }
    
    @Override
    public void action(Usable u) throws NonAvailableActionException {
        if(!Torch.isTorch(u)) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.isLocked() == false) {
            throw new NonAvailableActionException("Vous essayez d'ouvrir une porte déjà ouverte ...");
        }
        else {
            this.unlock();
        }
    }
}
