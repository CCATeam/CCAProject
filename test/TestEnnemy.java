import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import game.application.character.Hero;
import game.application.character.ennemy.Ennemy;
import game.application.character.ennemy.Orc;
import game.application.items.weapon.Sword;



public class TestEnnemy {
	
	@Test
	public void testGetUse() {
		Ennemy orc = new Orc("orc", null);
		assertTrue(orc.canUseSpecial());
		orc.special();
		assertFalse(orc.canUseSpecial());
	}
	
	@Test
	public void testSpecial() {
		Ennemy orc = new Orc("orc", null);
		int damage = orc.special();
		assertTrue(damage == (orc.getCurrentWeapon().getDamage()*2) || damage == (orc.getCurrentWeapon().getDamage() / 2));
	}
	
	@Test
	public void testAction() {
		int life = 10;
		Ennemy orc = new Orc("orc", null);
		Hero h = new Hero("hero", life, null);
		String resu = orc.action(h);
		assertTrue(resu.equals("L'orc effectue son special : " + orc.getSpecial() + " et vous perdez 1 point de vie")
				|| resu.equals("L'orc effectue une attaque et vous perdez 3 point de vie")
				|| resu.equals("L'orc effectue son special : " + orc.getSpecial() + "  et vous perdez 6 point de vie"));
	}
}
