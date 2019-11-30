package game.application;

import game.application.items.Item;
import game.application.places.Place;
import game.application.places.Exit;
import game.application.character.Hero;
import game.application.character.Character;
import game.application.exceptions.NonExistantPlaceException;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonExistantLookableException;
import game.application.exceptions.NonLookableException;
import game.stockage.Stockage;
import java.util.List;

public class Game {

    private List<Place> places;
    private Place currentHeroPlace; 
    private Character hero;

    public Game() {
    }
    
    /**
     * Recup the data and initialize the differents components.
     */
    public void initializeGame() {
        Stockage s = new Stockage();
        this.places = s.getDataGame();
        
        //Initialize all the places, i.e. Get the lookables, and other "ables" 
        //from the data contain in each place.
        for(Place p : this.places) {
            p.initialize();
        }
        
        this.hero = new Hero("hero", 100);      
        this.currentHeroPlace = this.places.get(0);
    }

    /**
     * 
     * @param i
     * @return 
     */
    public Item take(Item i) {
            // TODO - implement Game.take
            throw new UnsupportedOperationException();
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
        Exit e = this.currentHeroPlace.getExit(location);
        if(e == null) {
            throw new NonExistantPlaceException();
        }
        
        if(e.canPass(this.hero)) {
            for(Place p : this.places) {
                if(p.getNAME().equals(location)) {
                    placeOut = p;
                }
            }                                               
            this.currentHeroPlace = placeOut;
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
    
    /**
     *
     * @param s
     * @return 
     * @throws game.application.exceptions.NonLookableException 
     * @throws game.application.exceptions.NonExistantLookableException 
     */
    public Lookable lookInBag(String s) throws NonLookableException, NonExistantLookableException {
        return null;
    }

    /**
     * 
     * @param s
     */
    private boolean existsPlace(String s) {
            // TODO - implement Game.existsPlace
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param item
     */
    public void use(String item) {
        
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
        return currentHeroPlace;
    }

}