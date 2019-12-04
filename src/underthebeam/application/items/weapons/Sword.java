package underthebeam.application.items.weapons;

import game.application.items.weapon.Weapon;

public class Sword extends Weapon{

	public Sword(String name, String description, String bagDescription, int damages) {
		super(name, description, bagDescription, damages);
	}
	
        public Sword() {
            super("Sword", "A sword", "A sword", 4);
        }
}
