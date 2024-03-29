package underthebeam.application.characters.enemies.special;

import game.application.items.weapon.Weapon;

public class StrongHit extends Special{
	
	private Weapon weapon;
	
	public StrongHit(Weapon weapon) {
		super(1);
		this.weapon = weapon;
	}
	
	@Override
	public int specialSkill() {
		if (Use()) {
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