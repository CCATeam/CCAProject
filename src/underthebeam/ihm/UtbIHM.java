
package underthebeam.ihm;

import game.application.Command;
import game.application.Game;
import game.application.exceptions.InvalidTaget;
import game.application.items.Item;
import game.ihm.IHM;
import underthebeam.application.UtbGame;

public class UtbIHM extends IHM{

    public UtbIHM() {
        super(new UtbGame());
    }
    
    
    
    public void attack(String tabParameters[]) {
        UtbGame utbGame = (UtbGame)this.getGame();
        
        try {
            int damage = utbGame.attack(tabParameters[0]);
            this.refreshConsole("Vous attaque " + tabParameters[0] + " et il perd " + damage + " point de vie");
            if (!utbGame.ennemyIsDie(tabParameters[0])) {
                    this.refreshConsole(utbGame.EnnemyAttack(tabParameters[0]));
            }
            else {
                    Item loot = utbGame.ennemyDie(tabParameters[0]);
                    if (loot == null) {
                            this.refreshConsole(tabParameters[0] + " meure et ne loot rien");
                    }
                    else {
                            this.refreshConsole(tabParameters[0] + "meure et loot : \n"
                                            + loot);
                    }
            }
        } catch (InvalidTaget e) {
                this.refreshConsole("la cible de votre attaque n'existe pas");
        }
    }
    
    @Override
     /**
     * Ask to game the datas corresponding to the command c and its parameters.
     * 
     * @param c
     * @param tabParameters
     */
    public void action(Command c, String[] tabParameters) { 
        //ATTACK
        if(c.equals(Command.ATTACK) && tabParameters.length > 0) {
            this.attack(tabParameters);
        }
        
        else {
            super.action(c, tabParameters);
        }
    }
}
