package game.application.character.ennemy;

import game.application.character.Character;
import game.application.character.Hero;
import game.application.character.ennemy.special.Special;
import game.application.items.Item;
import game.application.items.weapon.Weapon;
import game.application.places.Place;

public abstract class Ennemy extends Character{
	
    private Special skill; // permet de realiser une capacit� special
    private Item loot; // null si pas de loot

    public Ennemy(String name, int life, Weapon weapon, Special skill, Place p, Item loot) {
        super(name, life, weapon, p);
        this.skill = skill;
        this.loot = loot;
    }

    public int special() {
        return this.skill.specialSkill();
    }

    public boolean canUseSpecial() {
        return this.skill.getUse();
    }

    public Special getSpecial() {
        return this.skill;
    }

    public abstract String action(Hero h);

    public Item loot() {
            return this.loot;
    }
	
    public static boolean isEnnemy(Object o) {
        return o instanceof Ennemy;
    }
}
