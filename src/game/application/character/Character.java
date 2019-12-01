package game.application.character;

import game.application.Lookable;
import game.application.items.Item;
import game.application.items.weapon.Weapon;
import game.application.places.Place;

public abstract class Character implements Lookable {

    private Bag bag;
    private final String NAME;
    private int life;
    private final int MAX_LIFE;

    private Weapon weaponCourante;
    private Place placeCourante;
    
    /**
     * 
     * @param place
     * @param NAME
     * @param life
     */
    public Character(String name, int life) {
        this.NAME = name;
        this.life = life;
        this.MAX_LIFE = life;
        this.bag = new Bag();
    }
    
    /**
     * 
     * @param place
     * @param NAME
     * @param life
     * @param weapon
     */
    public Character(String name, int life, Weapon weapon) {
        this.NAME = name;
        this.life = life;
        this.MAX_LIFE = life;
        this.weaponCourante = weapon;
    }
    

    /**
     * 
     * @param item
     */
    public void addItem(Item item) {
        this.bag.addItem(item);
    }

    /**
     * 
     * @param nom
     * @return Item
     */
    public Item removeItem(String nom) {
        return this.bag.removeItem(nom);
    }

    public void changeWeapon(String nom) {
        Weapon tmp = (Weapon) removeItem(nom);
        addItem(weaponCourante);
        this.weaponCourante = tmp;
    }
    
    public Place getPlace() {
        return this.placeCourante;
    }
    
    /**
     *
     * @return
     */
    public String getNAME() {
        return NAME;
    }

    public void attaque(Character chara) {
    	chara.takeDamage(this.weaponCourante.getDamage());
    }
    
    /**
     *
     * @return
     */
    public int getLife() {
        return life;
    }

    /**
     *
     * @param life
     */
    public void setLife(int life) {
        this.life = life;
    }
    
    public void takeDamage(int damage) {
    	this.life -= damage;
    }
    
    @Override
    public String toString() {
        return this.NAME + " \n"
             + "life: " + this.life; 
    }
    
}