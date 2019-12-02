/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.items;

import game.application.interfaces.Usable;

/**
 *
 * @author Fabien
 */
public class Consumable extends Item {
    
    private int nbEffect;
    private boolean available;
    
    public Consumable(String NAME, String DESCRIPTION, int nbEffect) {
        super(NAME, DESCRIPTION);
        this.nbEffect = nbEffect;
        this.available = true;
    }

    public int getNbEffect() {
        return nbEffect;
    }

    public void setNbEffect(int nbEffect) {
        this.nbEffect = nbEffect;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public static boolean isConsumable(Object o) {
        return o instanceof Consumable;
    }
}
