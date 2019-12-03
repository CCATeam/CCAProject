package game.application.character.ennemy.special;

import game.application.character.Hero;
import game.application.items.weapon.Weapon;

public class StrongHit extends Special{
	
	private Hero hero;
	private Weapon weapon;
	
	public StrongHit(Hero hero, Weapon weapon) {
		this.hero = hero;
		this.weapon = weapon;
	}
	
	@Override
	public boolean specialSkill() {
		if (getUse()) {
			if (Math.random() < 0.5) {
				this.hero.takeDamage(weapon.getDamage()*2);
			}
			else {
				this.hero.takeDamage(weapon.getDamage() / 2);
			}
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Coup puissant vous perdez " + (weapon.getDamage()*2) + "poind de vie !";
	}
}
