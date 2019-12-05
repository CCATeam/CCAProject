package CCAProjectTests;

import static org.junit.Assert.*;
import org.junit.Test;

import underthebeam.application.characters.Hero;
import game.application.items.Consumable;
import underthebeam.application.items.Wine;
import underthebeam.application.items.weapons.Axe;

public class TestHero {

	@Test
	public void testAction() {
		Hero hero = new Hero("hero", 10, new Axe(), null);
		hero.setLife(hero.getLife() - 2);
		Consumable c = (Consumable)new Wine();
		try {
			hero.action(c);
		}
		catch (Exception e) {
			
		}
		assertTrue(hero.getLife() == hero.getMAXLIFE());
	}
	
	@Test
	public void testAction2() {
		Hero hero = new Hero("hero", 10, new Axe(), null);
                Consumable c = (Consumable)new Wine();
		hero.addItem(c);
		try {
			hero.action((Consumable)hero.getItemFromBag("pomme"));
		}
		catch (Exception e) {
		}
		assertTrue(hero.getLife() == hero.getMAXLIFE());
		assertEquals(hero.getItemFromBag("wine"), c);
	}
	
}
