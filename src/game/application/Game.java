package game.application;

import game.application.interfaces.Usable;
import game.application.interfaces.Takeable;
import game.application.interfaces.Lookable;
import game.application.interfaces.Actionnable;
import game.application.items.Item;
import game.application.places.Place;
import game.application.places.Exit;
import game.application.character.Hero;
import game.application.character.ennemy.Ennemy;
import game.application.character.Character;
import game.application.exceptions.NonExistantPlaceException;
import game.application.exceptions.InvalidTaget;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonAvailableActionException;
import game.application.exceptions.NonExistantActionnableException;
import game.application.exceptions.NonExistantLookableException;
import game.application.exceptions.NonExistantTakeableException;
import game.application.exceptions.NonLookableException;
import game.application.exceptions.NonTakeableException;
import game.stockage.Stockage;
import java.util.List;

public class Game {

    private List<Place> places;
    private Hero hero;

    public Game() {
    }
    
    /**
     * Recup the data and initialize the differents components.
     */
    public void initializeGame() {
        Stockage s = new Stockage();
        this.places = s.getDataGame();
        this.hero = (Hero)this.places.get(0).getCharacterByName("Me");
        
        //Initialize all the places, i.e. Get the lookables, and other "ables" 
        //from the data contain in each place.
        for(Place p : this.places) {
            p.initialize();
        }
    }

    /**
     * Check if a Place with a name equals to the string location exists
     * near the actual Place. If it is the case then change the actual place
     * to the founded one. Return the new Place if successfull else a 
     * NonExistantPlaaceException.
     * 
     * @param location
     * @return 
     * @throws game.application.exceptions.NonExistantPlaceException
     * @throws game.application.exceptions.LockedExitException
     */
    public Place go(String location) throws NonExistantPlaceException, LockedExitException{
        Place placeOut = null;
        Exit e = this.getHero().getPlace().getExit(location);
        if(e == null) {
            throw new NonExistantPlaceException();
        }
        
        if(e.canPass(this.hero)) {
            for(Place p : this.places) {
                if(p.getNAME().equals(location)) {
                    placeOut = p;
                }
            }                                               
            this.getHero().setPlaceCourante(placeOut);
        }   
        return placeOut;
    }
    
    
    
    /**
     *
     * @param s
     * @return 
     * @throws game.application.exceptions.NonExistantLookableException 
     */
    public Lookable lookInPlace(String s) throws NonExistantLookableException {
        Lookable l = this.getHeroPlace().getLookable(s);
        
        if(l == null) {
            throw new NonExistantLookableException();
        }
     
        return l;
    }
    
    public Lookable lookBag() {
        return this.getHero().lookedBag();
    }
    
    /**
     *
     * @param s
     * @return 
     * @throws game.application.exceptions.NonLookableException 
     * @throws game.application.exceptions.NonExistantLookableException 
     */
    public Lookable searchInBag(String s) throws NonLookableException, NonExistantLookableException {
        Item item = this.hero.getItemFromBag(s);
        if (item==null){
            throw new NonExistantLookableException();
        } else if (item instanceof Lookable) {
            return item;
        }
        throw new NonLookableException();
    }

    /**
     * 
     * @param s
     */
    private boolean searchPlace(String s) {
            // TODO - implement Game.existsPlace
            throw new UnsupportedOperationException();
    }

    /**
     * Triggered an Actionnable that needs an Usable to its action.
     * @param params params[0] -> The Usable's name
     * params[1] -> The Actionnable name
     * @return 
     * @throws game.application.exceptions.NonExistantActionnableException
     * @throws game.application.exceptions.NonAvailableActionException
     */
    public Lookable use(String params[]) throws NonExistantActionnableException, NonAvailableActionException{
        
        Usable usable;
        Actionnable actionnable;
       
        if(params.length > 1) {
            //Get the actionnable from the place
            String nameActionnable = params[params.length - 1];    
        
            actionnable = this.getHeroPlace().getActionnable(nameActionnable);    
            if(actionnable == null) {
                throw new NonExistantActionnableException();
            }
        }
        else {
            actionnable = this.hero;
        }
        
        //Get the usable from the bag, if none is found throw an exception
        Item item = this.getHero().getItemFromBag(params[0]);
        if(item == null || !Usable.isUsable(item)) {
            throw new NonAvailableActionException("Il n'y a pas d'item utilisable avec ce nom");
        }
        usable = ((Usable)item);
           
        actionnable.action(usable);
        return (Lookable)actionnable;
    }

    /**
     * 
     * @param item1
     * @param item2
     */
    public void use(String item1, String item2) {
            // TODO - implement Game.use
            throw new UnsupportedOperationException();
    }

    public Place getHeroPlace() {
        return this.hero.getPlace();
    }

    
    public int attack(String nameEnnemy) throws InvalidTaget {
    	Ennemy ennemy = this.hero.getPlace().getEnnemy();
    	if (ennemy != null && ennemy.getNAME().equalsIgnoreCase(nameEnnemy)) {
    		return this.hero.attack(ennemy);
		}
    	else {
    		throw new InvalidTaget();
    	}
    }
    
    public String EnnemyAttack() {
    	Ennemy ennemy = this.hero.getPlace().getEnnemy();
    	return ennemy.action((Hero)this.hero);
    }
    
    /**
     * Returns game's hero
     * 
     * @return this.hero
     */
    public Character getHero() {
        return hero;
    }

    /**
     *
     * @param str
     * @return
     * @throws NonTakeableException
     * @throws NonExistantTakeableException
     */
    public Takeable take(String str) throws NonTakeableException, NonExistantTakeableException {
        Item item = this.getHeroPlace().getItemByName(str);
        if (item==null) {
            throw new NonExistantTakeableException();
        }
        else if (item instanceof Takeable){
            Takeable takeable = (Takeable) item;
            String taken = takeable.taken(this.getHero());
            return takeable;
        } else {
            throw new NonTakeableException();
        }
    }
}
