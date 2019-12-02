package game.ihm;

import game.application.Command;
import game.application.Game;
import game.application.exceptions.InvalidCommandException;
import game.application.interfaces.Lookable;
import game.application.interfaces.Takeable;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonAvailableActionException;
import game.application.exceptions.NonExistantActionnableException;
import game.application.exceptions.NonExistantPlaceException;
import game.application.places.Place;
import game.application.exceptions.NonExistantLookableException;
import game.application.exceptions.NonExistantTakeableException;
import game.application.exceptions.NonTakeableException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IHM {

    private Game game;
    private final Scanner SCANNER;

    public IHM() {
        this.game = new Game();
        this.game.initializeGame();      
        this.SCANNER = new Scanner(System.in);
    }
        

    public String scan() {
        return this.SCANNER.nextLine();
    }

    /**
     * 
     * @param text
     */
    public void refreshConsole(String text) {
        System.out.println(text);
    }
    
    /**
     * Ask to game the datas corresponding to the command c and its parameters.
     * 
     * @param c
     * @param tabParameters
     */
    public void action(Command c, String[] tabParameters) {     
        //GO
        if(c.equals(Command.GO) && tabParameters.length > 0) {
            try {
                Place p = this.game.go(tabParameters[0]);
                this.refreshConsole(p.toString());
                
            } catch (NonExistantPlaceException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nIl n'y a pas d'endroit avec le nom indiquié à proximité !");
            } catch (LockedExitException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nVous ne pouvez pas passer par là pour le moment. Peut être n'avez vous pas l'objet adéquat ?");
            }
        }
        //LOOK
        else if(c.equals(Command.LOOK) && tabParameters.length > 0) {     
            try {
                Lookable l = this.game.lookInPlace(tabParameters[0]);
                this.refreshConsole(l.looked());
            } catch (NonExistantLookableException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nVous essayez de regarder quelque chose d'innexistant ! (Si vous y arrivez, bravo !)");
            }
        }
        //LOOK IN BAG
        else if(c.equals(Command.LOOKBAG) && tabParameters.length >= 0) {     
            Lookable l = this.game.lookBag();
            this.refreshConsole(l.looked());
            
        }
        //TAKE
        else if(c.equals(Command.TAKE) && tabParameters.length > 0) {
            try {
                Takeable taken = this.game.take(tabParameters[0]);
                this.refreshConsole("Vous avez ramassé" + taken.toString());
                this.refreshConsole(taken.taken(this.game.getHero()));
            } catch (NonTakeableException ex) {
                this.refreshConsole("\nVous ne pouvez pas ramasser cet objet");
            } catch (NonExistantTakeableException ex) {
                this.refreshConsole("\nVous essayez de ramasser un objet qui n'existe pas !");
            }
        }
        //USE
        else if(c.equals(Command.USE) && tabParameters.length > 1) {     
            try {
                Lookable l = this.game.use(tabParameters);
                this.refreshConsole(l.looked());
            } catch (NonExistantActionnableException ex) {
                this.refreshConsole("Rien ne se produit ...\n");
            } catch (NonAvailableActionException ex) {
                this.refreshConsole(ex.getMessage());
            } 
        }
    }
    
    /**
     * Main function of our IHM, here show what need to be shouw and wait for 
     * a user action.
     */
    public void run() {       
        Command c = null;
        String[] parameters;
        String line;
        
        refreshConsole(this.game.getHeroPlace().toString());
        
        do {       
            System.out.println("");
            System.out.println("Quelle action effectuer ? (help pour voir la liste des commandes disponibles)");
            line = this.scan();
            try {
                c = Command.getCommand(line);
                parameters = Command.getParameters(line);
                this.action(c, parameters);
            }
            catch(InvalidCommandException ex) {
                refreshConsole(this.game.getHeroPlace().toString() 
                        + "\nCommande invalide");
            }  
            
        } while(c != Command.QUIT);
    }

}
