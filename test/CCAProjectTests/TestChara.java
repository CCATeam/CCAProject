package CCAProjectTests;


import underthebeam.application.items.weapons.Axe;
import game.application.characters.Bag;
import game.application.items.Item;
import underthebeam.application.characters.Hero;
import game.application.places.Place;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestChara {

	@Test
	public void testAddItem() {
		Hero hero = new Hero("hero", 10, null, null);
                Item i = new Axe();
		hero.addItem(i);
		assertEquals(hero.getItemFromBag("Axe"), i);
	}
	
	@Test
	public void testRemoveItem() {
		Hero hero = new Hero("hero", 10, null, null);
                Item i = new Axe();
		hero.addItem(i);
		assertTrue(hero.removeItem("Axe").equals(i));
	}
	
	@Test
	public void testChangeWeapon() {
		Hero hero = new Hero("hero", 10, null, null);
                Item i = new Axe();
		hero.addItem(i);
		hero.changeWeapon("Axe");
		assertTrue(hero.getCurrentWeapon().equals(i));
	}
	
	@Test
	public void testTakeDamage() {
		Hero hero = new Hero("hero", 10, null, null);
		hero.takeDamage(3);
		assertTrue(hero.getLife() == 7);
	}
	
	@Test
	public void testAttaque() {
		Hero hero = new Hero("hero", 10, new Axe(), null);
		Hero hero2 = new Hero("hero", 10, new Axe(), null);
		int damage = hero.attack(hero2);
		assertTrue(hero2.getLife() == 10 - damage);
	}
}
