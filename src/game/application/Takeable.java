/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application;
import game.application.items.Item;


/**
 *
 * @author antoine
 */
public abstract class Takeable extends Item {

    private boolean stuck;


    
    /**
     *
     * @param NAME
     * @param DESCRIPTION
     * @param stuck
     */
    
    public Takeable(String NAME, String DESCRIPTION, boolean stuck) {
        super(NAME, DESCRIPTION);
        this.stuck = stuck;
    }
    
    /**
     *
     * @param chara
     * @return
     */
    public String taken (game.application.character.Character chara)
    {
        chara.addItem(this);
        chara.getPlace().removeItem(this.hashCode());
        return("not yet decided string");
    }
}
