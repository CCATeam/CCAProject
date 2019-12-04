package underthebeam.application;

import game.application.Game;
import game.application.characters.Character;
import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.Ennemy;
import game.application.exceptions.InvalidTaget;
import game.application.items.Item;


public class UtbGame extends Game{
    
    public int attack(String nameEnnemy) throws InvalidTaget {
    	Ennemy ennemy;
        Character c = this.getHeroPlace().getCharacterByName(nameEnnemy);
        
        if(!Ennemy.isEnnemy(c) || !c.getNAME().equalsIgnoreCase(nameEnnemy)) {
            throw new InvalidTaget();           
        }
        ennemy = (Ennemy)this.getHeroPlace().getCharacterByName(nameEnnemy);
        int resu = this.getHero().attack(ennemy);
        return resu;
    }
    
    public boolean ennemyIsDie(String nameEnnemy) {
    	game.application.characters.Character ennemy = this.getHeroPlace().getCharacterByName(nameEnnemy);
        if (ennemy.getLife() <= 0)
        	return true;
        return false;
    }
    
    public Item ennemyDie(String nameEnnemy) {
    	game.application.characters.Character ennemy = this.getHeroPlace().getCharacterByName(nameEnnemy);
    	this.getHeroPlace().removeCharacter(ennemy);
    	Item i = ((Ennemy)ennemy).loot();
    	this.getHero().addItem(i);;
    	return i;
    }
    
    public String EnnemyAttack(String nameEnnemy) {
    	Ennemy ennemy = (Ennemy)this.getHeroPlace().getCharacterByName(nameEnnemy);
    	return ennemy.action((Hero)this.getHero());
    }
}
