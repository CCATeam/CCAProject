/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.characters;

import game.application.characters.Warrior;
import game.application.interfaces.Actionnable;
import game.application.interfaces.Usable;
import game.application.exceptions.NonAvailableActionException;
import game.application.items.Consumable;
import game.application.items.weapon.Weapon;
import game.application.places.Place;

public class Hero extends Warrior implements Actionnable{
    
    public Hero(String NAME, int life, Weapon w, Place p) {
        super(NAME, life, w, p);
    }

    @Override
    public void action(Usable u) throws NonAvailableActionException{
        if (Consumable.isConsumable(u)) {
            Consumable cons = (Consumable) u;
            
            if (this.getLife() + cons.getNbEffect() <= this.getMAXLIFE()) {
            	this.setLife(this.getLife() + cons.getNbEffect());
            }
            else if (this.getLife() < this.getMAXLIFE()) {
            	this.setLife(this.getMAXLIFE());
            }
        }
        
    }

}
