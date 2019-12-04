/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.items;

import game.application.interfaces.Takeable;
import game.application.interfaces.Usable;

/**
 *
 * @author Fabien
 */
public class ChestKey extends TakeableItem implements Takeable, Usable {
    
    public ChestKey(String NAME, String DESCRIPTION, String BAGDESCRIPTION) {
        super(NAME, DESCRIPTION,BAGDESCRIPTION);
    }
    
    public static boolean isChestKey(Object o) {
        return o instanceof ChestKey;
    }
}
