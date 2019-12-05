/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.items;

import game.application.items.Consumable;

public class Wine extends Consumable {
    
    public static int nbEffect = 5;
    
    public Wine(String NAME, String DESCRIPTION, String BAGDESCRIPTION, int nbEffect) {
        super(NAME, DESCRIPTION, BAGDESCRIPTION, nbEffect);
    }
    
}
