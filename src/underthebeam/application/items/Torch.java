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
public class Torch extends Item implements Takeable, Usable {
    
    public Torch(String NAME, String DESCRIPTION) {
        super(NAME, DESCRIPTION);
    }
    
    public static boolean isTorch(Object o) {
        return o instanceof Torch;
    }
}
