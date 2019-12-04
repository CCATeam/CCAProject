/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underthebeam.application.items;

import game.application.interfaces.Takeable;
import game.application.interfaces.Usable;
import game.application.items.Item;

/**
 *
 * @author Fabien
 */
public class ChestKey extends Item implements Takeable, Usable {
    
    public ChestKey(String NAME, String DESCRIPTION) {
        super(NAME, DESCRIPTION);
    }
    
    public static boolean isChestKey(Object o) {
        return o instanceof ChestKey;
    }
}
