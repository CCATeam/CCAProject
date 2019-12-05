package game.application;

import game.application.interfaces.Usable;
import game.application.interfaces.Takeable;
import game.application.interfaces.Lookable;
import game.application.interfaces.Actionnable;
import game.application.items.Item;
import game.application.places.Place;
import game.application.places.Exit;
import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.Enemy;
import game.application.characters.Character;
import game.application.exceptions.NonExistantPlaceException;
import game.application.exceptions.InvalidTaget;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonAvailableActionException;
import game.application.exceptions.NonExistantActionnableException;
import game.application.exceptions.NonExistantLookableException;
import game.application.exceptions.NonExistantTakeableException;
import game.application.exceptions.NonLookableException;
import game.application.exceptions.NonTakeableException;
import game.application.places.FinalPlace;
import game.stockage.Stockage;
import java.util.List;

public class Game {

    private List<Place> places;
    private Place finalPlace; // the last place in the list.
    private Hero hero; // int the first place in the list.

    public Game() {
    }
    
    /**
     * Recup the data and initialize the differents components.
     */
    public void initializeGame() {
        Stockage s = new Stockage();
        this.places = s.getDataGame();
        this.hero = (Hero)this.places.get(0).getCharacterByName("player");
        this.finalPlace = new FinalPlace(); //TODO
        //this.finalPlace = (FinalPlace)this.places.get(this.places.size());
        
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
    public String go(String location) throws NonExistantPlaceException, LockedExitException{
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
            this.getHero().setCurrentPlace(placeOut);
        }   
        return placeOut.toString();
    }
    
    /**
     *
     * @param s
     * @return 
     * @throws game.application.exceptions.NonExistantLookableException 
     */
    public String lookInPlace(String s) throws NonExistantLookableException {
        Lookable l = this.getHeroPlace().getLookable(s);
        
        if(l == null) {
            throw new NonExistantLookableException();
        }
     
        return l.lookedInPlace();
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
            String nameActionnable = params[1];    
        
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
        usable = (Usable)item;
           
        actionnable.action(usable);
        this.getHero().removeItem(item.getNAME());
        return (Lookable)actionnable;
    }

    public Place getHeroPlace() {
        return this.hero.getPlace();
    }
    
    public String lookAround () {
        return this.getHeroPlace().toString();

    }
    
    /**
     * Returns game's hero
     * 
     * @return this.hero
     */
    public Hero getHero() {
        return hero;
    }

    /**
     *
     * @param str
     * @return
     * @throws NonTakeableException
     * @throws NonExistantTakeableException
     */
    public String take(String str, Character chara) throws NonTakeableException, NonExistantTakeableException {
        Item item = this.getHeroPlace().getItemByName(str);
        if (item==null) {
            throw new NonExistantTakeableException();
        }
        else if (item instanceof Takeable){
            Takeable takeable = (Takeable) item;
            String taken = takeable.taken(chara);
            return takeable.taken(chara);
        } else {
            throw new NonTakeableException();
        }
    }
    
    public boolean isWin() {
    	return this.getHeroPlace().getNAME().equals(this.finalPlace.getNAME());
    }
}
