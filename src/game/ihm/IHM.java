package game.ihm;

import game.application.Command;
import game.application.Game;
import game.application.exceptions.InvalidCommandException;
import game.application.exceptions.InvalidTaget;
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
    private boolean quit = false;
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
        else if(c.equals(Command.USE) && tabParameters.length > 0) {     
            try {
                Lookable l = this.game.use(tabParameters);
                this.refreshConsole(l.looked());
            } catch (NonExistantActionnableException ex) {
                this.refreshConsole("Rien ne se produit ...\n");
            } catch (NonAvailableActionException ex) {
                this.refreshConsole(ex.getMessage());
            } 
        }
        //HELP
        else if(c.equals(Command.HELP)) {
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
        //ATTACK
        else if(c.equals(Command.ATTACK) && tabParameters.length > 0) {
        	try {
            	int damage = this.game.attack(tabParameters[0]);
				this.refreshConsole("Vous attaque " + tabParameters[0] + " et il perd " + damage);
				this.refreshConsole(this.game.EnnemyAttack(tabParameters[0]));
			} catch (InvalidTaget e) {
				this.refreshConsole("la cible de votre attaque n'existe pas");
			}
        }
        //QUIT 
        else if(c.equals(Command.QUIT)) {
            this.refreshConsole("Êtes-vous sûr ?\n");
            tabParameters[0]=this.scan();
            try {
                c = Command.getCommand(tabParameters[0]);
            }catch (InvalidCommandException ex) {
                c = null;
            }
            if (c==Command.YES) {
                this.refreshConsole("Voulez-vous sauvegarder ?");
                tabParameters[0]=this.scan();
                try {
                    c = Command.getCommand(tabParameters[0]);
                }
                catch (InvalidCommandException ex){
                    c = null;
                }
                if (c.equals(Command.YES)) {
                    ;  //Fonction de sauvegarde
                }
                this.quit=true;
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
            System.out.println("------------------------------------------------------------------------");
            System.out.println("");
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
            
        } while(this.quit == false);
        this.quit = false;
    }

}
