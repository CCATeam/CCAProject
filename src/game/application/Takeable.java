/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application;
import game.application.items.Item;
import game.application.character.Character;

/**
 *
 * @author antoine
 */
public interface Takeable {
    
    /**
     *
     * @param chara
     * @return
     */
    default String taken (Character chara)
    {
        if (this instanceof Item) {
            chara.addItem((Item)this);
            chara.getPlace().removeItem((Item)this);
        return("String not yet decided");
        }
        return("String not yet decided.");
    }
}
