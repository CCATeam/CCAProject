/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.places;

import game.application.Lookable;

/**
 *
 * @author Fabien
 */
public class WoodenDoorExit extends Exit implements Lookable {
    
    private final String NAME;
    
    public WoodenDoorExit(String Description, String name) {
        super(Description);
        this.NAME = name;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
         return "Exit: " + this.NAME + "\n "
             + "Description: " + this.getDescription();
    }
    
    
}
