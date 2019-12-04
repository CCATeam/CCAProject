package underthebeam.application.characters.enemies;

import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.special.StrongHit;
import underthebeam.application.items.weapons.Axe;
import game.application.places.Place;

public class Orc extends Ennemy {
	
	public Orc(String name, Place p) {
		super(name, 10, new Axe(), new StrongHit(new Axe()), p, null);
	}

	@Override
	public String action(Hero h) {
		int damage;
		if (Math.random() < 0.6 || !this.canUseSpecial()) {
			damage = this.attack(h);
			return "L'orc effectue une attaque et vous perdez " + damage + " point de vie";
		}
		else {
			damage = this.special();
			if (damage == -1) {
				damage = this.attack(h);
			}
			else {
				h.takeDamage(damage);
			}
			return "L'orc effectue son special : " + this.getSpecial() + " vous perdez " + damage + " point de vie !" ;
		}
	}
}
