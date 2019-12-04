package game.application.places;

import game.application.exceptions.NonAvailableActionException;
import game.application.interfaces.Actionnable;
import game.application.interfaces.Lookable;
import game.application.interfaces.Usable;
import underthebeam.application.items.DoorKey;
import underthebeam.application.items.FinalKey;

public class ExitFinal extends LockedExit implements Lookable, Actionnable{
    
	
	public ExitFinal() {
		super("impossible a ouvrir", "Grand porte", true);
	}

    @Override
    public void action(Usable u) throws NonAvailableActionException {
        if(!FinalKey.isFinalKey(u)) {
            throw new NonAvailableActionException("Action impossible !");
        }
        
        if(this.isLocked() == false) {
            throw new NonAvailableActionException("Vous essayez d'ouvrir une porte d�ja ouverte ...");
        }
        else {
            this.unlock();
        }
    }

    @Override
    public String toString() {
         return "Exit: " + this.getNAME() + "\n "
             + "Description: " + this.getDescription();
    }
}
