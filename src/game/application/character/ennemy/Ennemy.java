package game.application.character.ennemy;

import game.application.character.Character;
import game.application.character.Hero;
import game.application.character.ennemy.special.Special;
import game.application.items.weapon.Weapon;

public abstract class Ennemy extends Character{
	
	private Special skill; // permet de realiser une capacité special
	
	public Ennemy(String name, int life, Weapon weapon, Special skill) {
		super(name, life, weapon);
		this.skill = skill;
	}
	
	public boolean special() {
		return this.skill.specialSkill();
	}
	
	public boolean canUseSpecial() {
		return this.skill.getUse();
	}
	
	public Special getSpecial() {
		return this.skill;
	}
	
	public abstract String action(Hero h);
	
}
