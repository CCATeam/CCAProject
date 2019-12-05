package game.ihm;

import game.application.Command;
import game.application.Game;
import game.application.exceptions.InvalidCommandException;
import game.application.exceptions.InvalidTaget;
import game.application.interfaces.Lookable;
import game.application.interfaces.Takeable;
import game.application.items.Item;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonAvailableActionException;
import game.application.exceptions.NonExistantActionnableException;
import game.application.exceptions.NonExistantPlaceException;
import game.application.places.Place;
import game.application.exceptions.NonExistantLookableException;
import game.application.exceptions.NonExistantTakeableException;
import game.application.exceptions.NonTakeableException;
import java.util.Scanner;

public class IHM {

    private Game game;
    private boolean quit = false;
    private final Scanner SCANNER;

    public IHM() {
        this.game = new Game();
        this.game.initializeGame();      
        this.SCANNER = new Scanner(System.in);
    }

    public IHM(Game game) {
        this.game = game;
        this.game.initializeGame();      
        this.SCANNER = new Scanner(System.in);
    }
        
    /**
     * Returns String from user's input. 
     * @return
     */
    public String scan() {
        return this.SCANNER.nextLine();
    }

    /**
     * Prints String text
     * @param text
     */
    public void refreshConsole(String text) {
        System.out.println(text);
    }
    
    /**
     * Calls for game.go() to move player to close location whose name equals param String.
     * Print informations accordingly. 
     * @param param
     */
    public void go(String param) {
        try {
                String newP = this.game.go(param);
                this.refreshConsole(newP);
        } catch (NonExistantPlaceException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nIl n'y a pas d'endroit avec le nom indiquié à proximité !");
            } catch (LockedExitException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nVous ne pouvez pas passer par là pour le moment. Peut être n'avez vous pas l'objet adéquat ?");
            }
    }
    
    /**
     * Calls games.lookInPlace() to print returned description of a Lookable in hero's
     * location whose name equals String param. 
     * @param param
     */
    public void lookSmthg(String param) {
        try {
            String l;
            l = this.game.lookInPlace(param);
            this.refreshConsole(l);
        } catch (NonExistantLookableException ex) {
            this.refreshConsole(this.game.getHeroPlace().toString()
                    + "\nVous essayez de regarder quelque chose d'innexistant ! (Si vous y arrivez, bravo !)");
        }
    }
    
    /**
     * Prints descriptions of every Item in hero's location.
     */
    public void lookAround() {
        this.refreshConsole(this.game.getHeroPlace().toString());
    }

    /**
     * Calls game.take() to move location's item whose name equals to String 
     * param to hero's bag and remove it from place, then uses returned
     * String to print informations accordingly.
     * accordingly.
     * @param param
     */
    public void take (String param) {
            try {
                String taken = this.game.take(param,this.game.getHero());
                this.refreshConsole("Vous avez ramassé" + taken);
            } catch (NonTakeableException ex) {
                this.refreshConsole("\nVous ne pouvez pas ramasser ceci" );
            } catch (NonExistantTakeableException ex) {
                this.refreshConsole("\nVous essayez de ramasser un objet qui n'existe pas !");
            }
    }
    
    /**
     * Calls game.use() to use items described in tabParameters and uses returned
     * String to print informations accordingly.
     * @param tabParameters
     */
    public void use (String tabParameters[]) {
            try {
                Lookable l = this.game.use(tabParameters);
                this.refreshConsole(l.lookedInBag());
            } catch (NonExistantActionnableException ex) {
                this.refreshConsole("Nothing happened ...\n");
            } catch (NonAvailableActionException ex) {
                this.refreshConsole(ex.getMessage());
            } 
    }
    
    /**
     *Prints available commands and their description.
     */
    public void help() {
        this.refreshConsole("Les commandes suivantes sont disponibles :\n "
                + "GO <lieu> : se déplacer\n"
                + "LOOK <lieu / objet / personnage> : examiner\n"
                + "BAG : lister le contenu de votre sac\n"
                + "TAKE <objet> : ramasser un objet\n"
                + "USE <objet> : utiliser un objet\n"
                + "USE <objet> <objet> : utiliser un objet sur quelque-chose\n"
                + "ATTACK <ennemy> : attaque l'ennemy\n"
                + "QUIT : quitter le jeu");
    }
    
    /**
     * Allows player to exit the game
     */
    public void quit() {
            this.refreshConsole("Êtes-vous sûr ?\n");
            Command c;
            String answer=this.scan();
            try {
                c = Command.getCommand(answer);
            }catch (InvalidCommandException ex) {
                c = null;
            }
            if (c==Command.YES) {
//                this.refreshConsole("Voulez-vous sauvegarder ?");
//                answer=this.scan();
//                try {
//                    c = Command.getCommand(answer);
//                }
//                catch (InvalidCommandException ex){
//                    c = null;
//                }
//                if (c.equals(Command.YES)) {
//                    ;  //Eventuelle fonction de sauvegarde
//                }
                this.quit=true;
            }    
        }

    /**
     * Stops the game.
     */
    public void Die() {
    	this.refreshConsole("You died....");
    	Command c;
        String answer=this.scan();
        try {
            c = Command.getCommand(answer);
        }catch (InvalidCommandException ex) {
            c = null;
        }
        if (c==Command.YES) {
            this.refreshConsole("Do you wish to load a save ?");
            answer=this.scan();
            try {
                c = Command.getCommand(answer);
            }
            catch (InvalidCommandException ex){
                c = null;
            }
            if (c.equals(Command.YES)) {
            	// Load a save
            }
            this.quit=true;
        }    
    	
    }

    /**
     * Stops the game and prints victory message.
     */
    public void Win() {
    	if (this.game.isWin()) {
    		this.quit = true;
    		this.refreshConsole("Congratulations, you have finished this game !");
    	}
    }
    
    /**
     * Ask to game the datas corresponding to the command c and its parameters.
     * 
     * @param c
     * @param tabParameters
     */
    public void action(Command c, String[] tabParameters) {     
        //GO
        if(c.equals(Command.GO)) {
            if (tabParameters.length > 0) {
                this.go(tabParameters[0]);
            } else {
                this.refreshConsole("Vous n'avez pas indiqué de lieu.");
            }
        }
        //LOOK
        else if(c.equals(Command.LOOK) && tabParameters.length > 0) {     
           this.lookSmthg(tabParameters[0]); 
        }
        else if(c.equals(Command.LOOK) && tabParameters.length == 0) {
           this.lookAround();
        }
        //LOOK IN BAG
        else if(c.equals(Command.BAG) && tabParameters.length >= 0) {     
            Lookable l = this.game.lookBag();
            this.refreshConsole(l.lookedInBag());
        }
        //TAKE
        else if(c.equals(Command.TAKE)) {
            if (tabParameters.length > 0) {
                take(tabParameters[0]);
            }else {
                this.refreshConsole("Vous n'avez pas indiqué d'objet à ramasser.");
            }
        }
        //USE
        else if(c.equals(Command.USE)) {
            if (tabParameters.length > 0) {
                this.use(tabParameters);
            } else {
                this.refreshConsole("Vous n'avez pas indiqué ce que vous souhaitiez utiliser.");
            }   
        }
        //HELP
        else if(c.equals(Command.HELP)) {
            this.help();
        }
        //QUIT 
        else if(c.equals(Command.QUIT)) 
            this.quit();
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
            System.out.println("------------------------------------------------------------------------");
            System.out.println("");
            line = this.scan();
            try {
                c = Command.getCommand(line);
                parameters = Command.getParameters(line);
                this.action(c, parameters);
            }
            catch(InvalidCommandException ex) {
                refreshConsole("Commande invalide\n" 
                        + this.game.getHeroPlace().toString());
            }  
            
        } while(this.quit == false);
        this.quit = false;
    }

    /**
     * Returns game associated with instance. 
     * @return
     */
    public Game getGame() {
        return game;
    }
}
