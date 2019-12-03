package game.application.character.ennemy;

import game.application.character.Hero;
import game.application.character.ennemy.special.StrongHit;
import game.application.items.weapon.Axe;
import game.application.items.weapon.Weapon;

public class Orc extends Ennemy {
	
	public Orc(Hero hero) {
		super("Orc", 10, new Axe(), new StrongHit(hero, new Axe()));
	}

	@Override
	public String action(Hero h) {
		if (Math.random() < 0.6 || !this.canUseSpecial()) {
			int damage = this.attack(h);				
			return "L'orc effectue une attaque et vous perdez " + damage + "poin de vie";
		}
		else {
			this.special();
			return "L'orc effectue son special : " + this.getSpecial();
		}
	}
}
