
import game.application.character.Bag;
import game.application.character.Hero;
import game.application.items.weapon.*;
import game.application.places.Place;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class TestChara {

	@Test
	public void testAddItem() {
		Hero hero = new Hero("hero", 10, null);
		hero.addItem(new Axe());
		assertEquals(hero.getItemFromBag("épée"), new Axe());
	}
	
	@Test
	public void testRemoveItem() {
		Hero hero = new Hero("hero", 10, null);
		hero.addItem(new Axe());
		assertTrue(hero.removeItem("épée").equals(new Axe()));
	}
	
	@Test
	public void testChangeWeapon() {
		Hero hero = new Hero("hero", 10, null);
		hero.addItem(new Axe());
		hero.changeWeapon("Hache");
		assertTrue(hero.getCurrentWeapon().equals(new Axe()));
	}
	
	@Test
	public void testTakeDamage() {
		Hero hero = new Hero("hero", 10, null);
		hero.takeDamage(3);
		assertTrue(hero.getLife() == 7);
	}
	
	@Test
	public void testAttaque() {
		Hero hero = new Hero("hero", 10, null);;
		Hero hero2 = new Hero("hero", 10, null);;
		int damage = hero.attack(hero2);
		assertTrue(hero2.getLife() == 10 - damage);
	}
}
