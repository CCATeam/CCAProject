/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.interfaces;
import game.application.items.Item;
import game.application.characters.Character;

/**
 *
 * @author antoine
 */
public interface Takeable {
    
    /**
     * Removes Item from place and adds it to character's bag.
     * @param chara
     * @return
     */
    default String taken (Character chara)
    {
        if (this instanceof Item) {
            chara.addItem((Item)this);
            chara.getPlace().removeItem((Item)this);
 
        }
        return(this.toString());
    }
}
