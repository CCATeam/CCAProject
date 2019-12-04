package underthebeam.application.characters.enemies.special;

import underthebeam.application.characters.Hero;
import game.application.items.weapon.Weapon;

public class StrongHit extends Special{
	
	private Weapon weapon;
	
	public StrongHit(Weapon weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public int specialSkill() {
		if (getUse()) {
			if (Math.random() < 0.5) {
				return weapon.getDamage()*2;
			}
			else {
				return weapon.getDamage() / 2;
			}
		}
		return -1;
	}
	@Override
	public String toString() {
		return "Coup puissant";
	}
}
