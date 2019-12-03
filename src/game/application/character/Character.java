package game.application.character;

import game.application.interfaces.Lookable;
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

    /*
     * switch the courznt weapon with a other weapon in the bag
     * @param name
     */
    
    public void changeWeapon(String name) {
        Weapon tmp = (Weapon) removeItem(name);
        addItem(weaponCourante);
        this.weaponCourante = tmp;
    }

    /*
     * @return placeCourant
     */
    public Place getPlace() {
        return this.placeCourante;
    }

    /*
     * @param place
     */
    public void setPlaceCourante(Place placeCourante) {
        this.placeCourante = placeCourante;
    }
    
    
    /**
     *
     * @return NAME
     */
    public String getNAME() {
        return NAME;
    }

    /*
     * make a attack
     * @param Character
     */
    public int attack(Character chara) {
    	chara.takeDamage(this.weaponCourante.getDamage());
    	return this.weaponCourante.getDamage();
    }
    
    /**
     *
     * @return life
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
    
    /*
     * remove damage to life
     * @param damage
     */
    public void takeDamage(int damage) {
    	this.life -= damage;
    }
    
    @Override
    public String toString() {
        return this.NAME + " \n"
             + "life: " + this.life; 
    }
    
    public Item getItemFromBag (String S) {
        return this.bag.findItem(S);
    }
    
    public Lookable lookedBag() {
        return new Lookable() {
            @Override
            public String getNAME() {
                return "Bag";
            }

            @Override
            public String looked() {
                return bag.toString(); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
}