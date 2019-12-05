/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.items.weapon;

import game.application.interfaces.Lookable;
import game.application.interfaces.Takeable;
import game.application.interfaces.Usable;
import game.application.items.Item;
import game.application.items.TakeableItem;

/**
 *
 * @author cbastin
 */

public abstract class Weapon extends TakeableItem {


	private int damage;
	
    public Weapon(String name, String description, String bagDescription, int damage) {
        super(name, description, bagDescription);
        this.damage = damage;
    }
    
    public int getDamage() {
    	return this.damage;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + damage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (damage != other.damage)
			return false;
		return true;
	}

}
