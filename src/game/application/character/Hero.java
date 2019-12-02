/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.character;

import game.application.interfaces.Actionnable;
import game.application.interfaces.Usable;
import game.application.exceptions.NonAvailableActionException;
import game.application.items.Consumable;
import java.util.List;

public class Hero extends Character implements Actionnable{
    
    public Hero(String NAME, int life) {
        super(NAME, life);
    }

    @Override
    public void action(List<Usable> listUsables) throws NonAvailableActionException{
        for(Usable u: listUsables) {
            if (Consumable.isConsumable(u)) {
                Consumable cons = (Consumable) u;
                this.setLife(this.getLife() + cons.getNbEffect());
                this.removeItem(cons.getNAME());
            }
        }
    }

}
