import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import game.application.character.Hero;
import game.application.items.Consumable;

public class TestHero {

	@Test
	public void testAction() {
		Hero hero = new Hero("hero", 10, null);
		hero.setLife(hero.getLife() - 2);
		Consumable c = new Consumable("pomme", "pomme vert comme on les aimes", 2);
		try {
			hero.action(c);
		}
		catch (Exception e) {
			
		}
		assertTrue(hero.getLife() == hero.getMAXLIFE());
	}
	
	@Test
	public void testAction2() {
		Hero hero = new Hero("hero", 10, null);
		hero.addItem(new Consumable("pomme", "pomme vert comme on les aimes", 2));
		try {
			hero.action((Consumable)hero.getItemFromBag("pomme"));
		}
		catch (Exception e) {
		}
		assertTrue(hero.getLife() == hero.getMAXLIFE());
		assertEquals(hero.getItemFromBag("pomme"), new Consumable("pomme", "pomme vert comme on les aimes", 2));
	}
	
}
