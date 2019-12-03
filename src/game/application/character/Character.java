package game.application.character;

import game.application.interfaces.Lookable;
import game.application.items.Item;
import game.application.items.weapon.Weapon;
import game.application.places.Place;

public abstract class Character implements Lookable {

    //The GSON library doesn't use the constructor so for
    //now the bag is created here. Atttribute transient to be ignore by 
    //gson
    private Bag bag;
    private final String NAME;
    private int life;
    private final int MAX_LIFE;

    private Weapon weaponCourante;
    private Place currentPlace;
    
    /**
     * 
     * @param place
     * @param NAME
     * @param life
     */
    public Character(String name, int life, Place p) {
        this.NAME = name;
        this.life = life;
        this.MAX_LIFE = life;
        this.currentPlace = p;
        this.bag = new Bag();
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
        return this.currentPlace;
    }

    public void setPlaceCourante(Place placeCourante) {
        this.currentPlace = placeCourante;
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