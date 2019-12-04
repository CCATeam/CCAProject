/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.places;

import game.application.interfaces.Actionnable;
import game.application.interfaces.Lookable;
import game.application.interfaces.Usable;
import game.application.characters.Character;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonAvailableActionException;
import game.application.items.DoorKey;

public class LockedExit extends Exit implements Lookable, Actionnable {
    
    private boolean locked;
    
    public LockedExit(String Description, String name, boolean locked) {
        super(Description, name);
        this.locked = locked;
    }

    @Override
    public void action(Usable u) throws NonAvailableActionException {
        if(!DoorKey.isDoorKey(u)) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.locked == false) {
            throw new NonAvailableActionException("Vous essayez d'ouvrir une porte déjà ouverte ...");
        }
        else {
            this.unlock();
        }
    }

    @Override
    public boolean canPass(Character c) throws LockedExitException {
        if(this.locked) {
            throw new LockedExitException();
        }
        
        return true;
    }
    
    public void unlock() {
        this.locked = false;
    }
    
    public void lock() {
        this.locked = true;
    }
    
    @Override
    public String toString() {
        String open = this.locked ? "Non" : "Oui";
        if (this.locked){
            return "Cette " + this.getNAME() + "est vérouillée.";
        } else  {
            return "Cette " + this.getNAME() + "est ouvete.\n"
                    + this.getDescription();
        }
//         return "Exit: " + this.getNAME() + "\n "
//              + "Description: " + this.getDescription() +"\n "
//              + "Ouverte: " + open;
              
    }
}
