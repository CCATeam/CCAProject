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

    private Place currentPlace;
    
    /**
     * 
     * @param name
     * @param place
     * @param life
     */
    public Character(String name, int life, Place place) {
        this.NAME = name;
        this.life = life;
        this.MAX_LIFE = life;
        this.currentPlace = place;
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

    /*
     * @return placeCourant
     */
    public Place getPlace() {
        return this.currentPlace;
    }

    /*
     * @param place
     */
    public void setPlaceCourante(Place placeCourante) {
        this.currentPlace = placeCourante;
    }
    
    
    /**
     *
     * @return NAME
     */
    public String getNAME() {
        return NAME;
    }

    
    /**
     *
     * @return life
     */
    public int getLife() {
        return life;
    }
    
    public int getMAXLIFE() {
    	return this.MAX_LIFE;
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
