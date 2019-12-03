package game.application.character.ennemy;

import game.application.character.Hero;
import game.application.character.ennemy.special.StrongHit;
import game.application.items.weapon.Axe;
import game.application.places.Place;

public class Orc extends Ennemy {
	
	public Orc(Place p) {
		super("Orc", 10, new Axe(), new StrongHit(new Axe()), p);
	}

	@Override
	public String action(Hero h) {
		int damage;
		if (Math.random() < 0.6 || !this.canUseSpecial()) {
			damage = this.attack(h);				
			h.takeDamage(damage);
			return "L'orc effectue une attaque et vous perdez " + damage + "poin de vie";
		}
		else {
			damage = this.special();
			h.takeDamage(damage);
			return "L'orc effectue son special : " + this.getSpecial() + "vous perdez " + damage + "point de vie !" ;
		}
	}
}
