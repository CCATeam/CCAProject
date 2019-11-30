package game.ihm;

import game.application.Command;
import game.application.Game;
import game.application.exceptions.InvalidCommandException;
import game.application.Lookable;
import game.application.Takeable;
import game.application.exceptions.LockedExitException;
import game.application.exceptions.NonExistantPlaceException;
import game.application.places.Place;
import game.application.exceptions.NonExistantLookableException;
import game.application.exceptions.NonExistantTakeableException;
import game.application.exceptions.NonLookableException;
import game.application.exceptions.NonTakeableException;
import java.util.Scanner;

public class IHM {

    private Game game;
    private final Scanner SCANNER;

    public IHM() {
       /* List<Place> places = new ArrayList();
        List<Character> ch = new ArrayList();
        List<Item> it = new ArrayList();
        Map<String, Exit> exits = new HashMap<>();
        
        exits.put("test2", new Exit("exit2"));
        exits.put("test3", new Exit());
        
        places.add(new Place("test", "testd", ch, exits, it));
        exits = new HashMap<>();
        exits.put("test", new Exit());
        exits.put("test3", new Exit());
        
        places.add(new Place("test2", "testd", ch, exits, it));
        exits = new HashMap<>();
        exits.put("test", new Exit());
        exits.put("test2", new Exit());
        
        places.add(new Place("test3", "testd", ch, exits, it));*/
        
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
        if(c.equals(Command.GO) && tabParameters.length > 1) {
            try {
                Place p = this.game.go(tabParameters[1]);
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
        else if(c.equals(Command.LOOK) && tabParameters.length > 1) {     
            try {
                Lookable l = this.game.lookInPlace(tabParameters[1]);
                this.refreshConsole(l.look());
            } catch (NonLookableException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nIl n'y a rien à voir ici !");
            } catch (NonExistantLookableException ex) {
                this.refreshConsole(this.game.getHeroPlace().toString()
                        + "\nVous essayez de regarder quelque chose d'innexistant ! (Si vous y arrivez, bravo !)");
            }
        }
        
        else if(c.equals(Command.TAKE) && tabParameters.length > 1) {
            try {
                Takeable taken = this.game.strToItem(tabParameters[1]);
                this.refreshConsole(taken.taken(this.game.getHero()));
            } catch (NonTakeableException ex) {
                this.refreshConsole("\nVous ne pouvez pas ramasser cet objet");
            } catch (NonExistantTakeableException ex) {
                this.refreshConsole("\nVous essayez de ramasser un objet qui n'existe pas !");
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
                System.out.println(c);
                this.action(c, parameters);
            }
            catch(InvalidCommandException ex) {
                refreshConsole(this.game.getHeroPlace().toString() 
                        + "\nCommande invalide");
            }  
            
        } while(c != Command.QUIT);
    }

}