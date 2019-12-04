package underthebeam.application.characters.enemies;

import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.special.BeamThrowing;
import underthebeam.application.characters.enemies.special.Special;
import underthebeam.application.characters.enemies.special.WingShot;
import underthebeam.application.items.FinalKey;
import game.application.items.weapon.Beam;
import game.application.places.Place;

public class LordDuck extends Enemy {
	
	private final Special secondSkill;
	
	public LordDuck(Place p) {
		super("Lord Canard", 50, new Beam(), new BeamThrowing(), p, new FinalKey());
		this.secondSkill = new WingShot(getCurrentWeapon());
	}

	
	
	@Override
	public String action(Hero h) {
		int damage = 0;
		if (this.canUseSpecial()) {
			damage = this.special();
			return this.getNAME() + " utilise son coup special : " + this.getSpecial() + " vous perdez " + damage + " point de vie !";
		}
		else if(Math.random() < 0.8 && this.secondSkill.getUse()) {
			damage =  this.secondSkill.specialSkill();
			return this.getNAME() + " utilise son coup special : " + this.secondSkill + " vous perdez " + damage + " point de vie !";
		}
		else {
			return this.getNAME() + " effectue une attaque et vous perdez " + damage + " point de vie";
		}
	}
	
}
