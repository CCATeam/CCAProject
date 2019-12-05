package CCAProjectTests;


import underthebeam.application.items.weapons.Axe;
import game.application.characters.Bag;
import underthebeam.application.characters.Hero;
import game.application.places.Place;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestChara {

	@Test
	public void testAddItem() {
		Hero hero = new Hero("hero", 10, null, null);
		hero.addItem(new Axe());
		assertEquals(hero.getItemFromBag("�p�e"), new Axe());
	}
	
	@Test
	public void testRemoveItem() {
		Hero hero = new Hero("hero", 10, null, null);
		hero.addItem(new Axe());
		assertTrue(hero.removeItem("�p�e").equals(new Axe()));
	}
	
	@Test
	public void testChangeWeapon() {
		Hero hero = new Hero("hero", 10, null, null);
		hero.addItem(new Axe());
		hero.changeWeapon("Hache");
		assertTrue(hero.getCurrentWeapon().equals(new Axe()));
	}
	
	@Test
	public void testTakeDamage() {
		Hero hero = new Hero("hero", 10, null, null);
		hero.takeDamage(3);
		assertTrue(hero.getLife() == 7);
	}
	
	@Test
	public void testAttaque() {
		Hero hero = new Hero("hero", 10, null, null);
		Hero hero2 = new Hero("hero", 10, null, null);
		int damage = hero.attack(hero2);
		assertTrue(hero2.getLife() == 10 - damage);
	}
}
