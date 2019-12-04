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
import game.application.items.weapon.Sword;
import game.application.places.Place;

public class Hero extends Character implements Actionnable{
    
    public Hero(String NAME, int life, Place p) {
        super(NAME, life, new Sword(), p);
    }

    @Override
    public void action(Usable u) throws NonAvailableActionException{
        if (Consumable.isConsumable(u)) {
            Consumable cons = (Consumable) u;
            if (this.getLife() + cons.getNbEffect() <= this.getMAXLIFE()) {
            	this.setLife(this.getLife() + cons.getNbEffect());
            	this.removeItem(cons.getNAME());
            }
            if (this.getLife() < this.getMAXLIFE()) {
            	this.setLife(this.getMAXLIFE());
            	this.removeItem(cons.getNAME());
            }
        }
        
    }

}
