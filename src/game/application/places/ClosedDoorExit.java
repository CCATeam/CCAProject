/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.places;

import game.application.interfaces.Actionnable;
import game.application.interfaces.Lookable;
import game.application.interfaces.Usable;
import game.application.character.Character;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonAvailableActionException;
import game.application.items.DoorKey;
import java.util.List;

public class ClosedDoorExit extends Exit implements Lookable, Actionnable {
    
    private boolean closed;
    
    public ClosedDoorExit(String Description, String name, boolean closed) {
        super(Description, name);
        this.closed = closed;
    }

    @Override
    public void action(List<Usable> listUsables) throws NonAvailableActionException {
        if(listUsables.size() > 1 || !DoorKey.isDoorKey(listUsables.get(0))) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.closed == false) {
            throw new NonAvailableActionException("Vous essayez d'ouvrir une porte déjà ouverte ...");
        }
        else {
            this.open();
        }
    }

    @Override
    public boolean canPass(Character c) throws LockedExitException {
        if(this.closed) {
            throw new LockedExitException();
        }
        
        return true;
    }
    
    
    
    public void open() {
        this.closed = false;
    }
    
    public void close() {
        this.closed = true;
    }
    
    @Override
    public String toString() {
        String open = this.closed ? "Non" : "Oui";
         return "Exit: " + this.getNAME() + "\n "
              + "Description: " + this.getDescription() +"\n "
              + "Ouvert: " + open;
              
    }
}
