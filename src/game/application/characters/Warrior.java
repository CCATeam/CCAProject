package game.application.characters;

import game.application.characters.Character;
import game.application.items.weapon.Weapon;
import game.application.places.Place;

public abstract class Warrior extends Character {


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
        if(this.currentWeapon != null) {
            addItem(currentWeapon);
        }
        this.currentWeapon = tmp;
    }
    
    public Weapon getCurrentWeapon() {
    	return this.currentWeapon;
    }
    
    /*
     * make an attack
     * @param Character
     */
    public int attack(Character chara) {
    	chara.takeDamage(this.currentWeapon.getDamage());
    	return this.currentWeapon.getDamage();
    }

}
