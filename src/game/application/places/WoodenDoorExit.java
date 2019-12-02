/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.places;

import game.application.interfaces.Lookable;

/**
 *
 * @author Fabien
 */
public class WoodenDoorExit extends Exit implements Lookable {
    
    
    public WoodenDoorExit(String Description, String name) {
        super(Description, name);
    }

    @Override
    public String toString() {
         return "Exit: " + this.getNAME() + "\n "
             + "Description: " + this.getDescription();
    }

}
