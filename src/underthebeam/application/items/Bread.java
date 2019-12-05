/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.items;

import game.application.items.Consumable;

/**
 *
 * @author Fabien
 */
public class Bread extends Consumable {
    
    public static int nbEffect = 5;
    
    public Bread(String NAME, String DESCRIPTION, String BAGDESCRIPTION, int nbEffect) {
        super(NAME, DESCRIPTION, BAGDESCRIPTION, nbEffect);
    }
    
}
