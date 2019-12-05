package CCAProjectTests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.Enemy;
import underthebeam.application.characters.enemies.Orc;



public class TestEnnemy {
	
	@Test
	public void testGetUse() {
		Enemy orc = new Orc("orc", null);
		assertTrue(orc.canUseSpecial());
		orc.special();
		assertFalse(orc.canUseSpecial());
	}
	
	@Test
	public void testSpecial() {
		Enemy orc = new Orc("orc", null);
		int damage = orc.special();
		assertTrue(damage == (orc.getCurrentWeapon().getDamage()*2) || damage == (orc.getCurrentWeapon().getDamage() / 2));
	}
	
	@Test
	public void testAction() {
		int life = 10;
		Enemy orc = new Orc("orc", null);
		Hero h = new Hero("hero", life, null, null);
		String resu = orc.action(h);
		assertTrue(resu.equals("L'orc effectue son special : " + orc.getSpecial() + " et vous perdez 1 point de vie")
				|| resu.equals("L'orc effectue une attaque et vous perdez 3 point de vie")
				|| resu.equals("L'orc effectue son special : " + orc.getSpecial() + "  et vous perdez 6 point de vie"));
	}
}
