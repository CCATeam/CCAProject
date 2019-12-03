package game.application.character.ennemy;

import game.application.character.Hero;
import game.application.character.ennemy.special.StrongHit;
import game.application.items.weapon.Axe;
import game.application.places.Place;

public class Orc extends Ennemy {
	
	public Orc(String name, Hero hero, Place p) {
            super(name, 10, new Axe(), new StrongHit(hero, new Axe()), p);
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
