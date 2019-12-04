package game.application.character.ennemy.special;

import game.application.items.weapon.Weapon;

public class WingShot extends Special {

	private Weapon weapon;
	
	public WingShot(Weapon weapon) {
		super(4);
		this.weapon = weapon;
	}

	@Override
	public int specialSkill() {
		if (Use()) {
			return 5; 
		}
		return this.weapon.getDamage();
	}

	@Override
	public String toString() {
		return "Coup d'aile";
	}
	
}
