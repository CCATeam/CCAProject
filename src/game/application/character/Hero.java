/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.character;

import game.application.Actionnable;
import game.application.Usable;
import game.application.items.Consumable;
import java.util.List;

/**
 *
 * @author Fabien
 */
public class Hero extends Character implements Actionnable{
    
    private String location;
    public Hero(String NAME, int life) {
        super(NAME, life);
    }
    
    @Override
    public String toString() {
        return super.toString() + this.location;
    }

    @Override
    public void action(List<Usable> listUsables) {
        for(Usable u: listUsables) {
            if (Consumable.isConsumable(u)) {
                Consumable cons = (Consumable) u;
                this.setLife(this.getLife() + cons.getNbEffect());
                this.removeItem(cons.getNAME());
            }
        }
    }

}
