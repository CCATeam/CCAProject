package underthebeam.application.characters.enemies.special;

import underthebeam.application.items.weapons.BeamWeapon;
import game.application.items.weapon.Weapon;

public class BeamThrowing extends Special {

	private final int TIMER = 3;
	private int count;
	private Weapon weapon = new BeamWeapon();
	
	public BeamThrowing() {
		super(1);
		this.count = 0;
	}
	
	@Override
	public int specialSkill() {
		if (Use() && count >= TIMER) {
			if (Math.random() < 0.7)
				return this.weapon.getDamage() * 3;
		}
		return 0;
	}
	
	public void incrementCount() {
		this.count ++;
	}

	@Override
	public String toString() {
		return "Lancer de poutre";
	}
	
	
	
}
