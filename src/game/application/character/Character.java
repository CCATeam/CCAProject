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
     * @param name
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
     * @param name
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

    public void changeWeapon() {
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getNAME() {
        return NAME;
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
    
    
    @Override
    public String toString() {
        return this.NAME + " \n"
             + "life: " + this.life; 
    }
    
    public Place getPlace() {
        return this.placeCourante;
    }
    
}