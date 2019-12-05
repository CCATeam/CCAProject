package underthebeam.application.items.weapons;

import game.application.items.weapon.Weapon;

public class Axe extends Weapon {
	
	public Axe(String name, String description, String bagDescription, int damages) {
		super(name, description, bagDescription, damages);
	}
        
        public Axe() {
            super("Axe", "An axee", "An axe", 3);
        }
	
}
