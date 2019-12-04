/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.places;

import game.application.interfaces.Lookable;
import game.application.places.Exit;

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
