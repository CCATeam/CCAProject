/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.items;

import game.application.interfaces.Takeable;

/**
 *
 * @author anon
 */
abstract public class TakeableItem extends Item implements Takeable {
    
    private String BAGDESCRIPTION;
    
    public TakeableItem(String NAME, String DESCRIPTION, String BAGDESCRIPTION) {
        super(NAME, DESCRIPTION);
        this.BAGDESCRIPTION=BAGDESCRIPTION;
    }
    
    @Override
    public String lookedInBag() {
        return this.BAGDESCRIPTION;
    }
    
    public String lookedInMap() {
        return this.getDESCRIPTION();
    }
}
