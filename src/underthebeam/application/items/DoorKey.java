/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.items;

import game.application.interfaces.Takeable;
import game.application.interfaces.Usable;

public class DoorKey extends Item implements Takeable, Usable{
    
    public DoorKey(String NAME, String DESCRIPTION) {
        super(NAME, DESCRIPTION);
    }
    
    public static boolean isDoorKey(Object o) {
        return o instanceof DoorKey;
    }
}
