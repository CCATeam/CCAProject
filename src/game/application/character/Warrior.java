package game.application.character;

import game.application.items.weapon.Weapon;
import game.application.places.Place;

public class Warrior extends Character {


    private Weapon currentWeapon;
	
    public Warrior(String name, int life, Weapon w ,Place place) {
    	super(name, life, place);
        this.currentWeapon = w;
    }
    
    /*
     * switch the current weapon with a other weapon in the bag
     * @param name
     */
    
    public void changeWeapon(String name) {
        Weapon tmp = (Weapon) removeItem(name);
        addItem(currentWeapon);
        this.currentWeapon = tmp;
    }
    
    public Weapon getCurrentWeapon() {
    	return this.currentWeapon;
    }
    
    /*
     * make a attack
     * @param Character
     */
    public int attack(Character chara) {
    	chara.takeDamage(this.currentWeapon.getDamage());
    	return this.currentWeapon.getDamage();
    }


}
