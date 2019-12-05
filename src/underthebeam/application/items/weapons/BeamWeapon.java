package underthebeam.application.items.weapons;

import game.application.items.weapon.Weapon;

public class BeamWeapon  extends Weapon{
	
	public BeamWeapon(String name, String description, String bagDescription, int damages) {
		super(name, description, bagDescription, damages);
	}
        
        public BeamWeapon() {
            super("beamweapon", "A beam that is use as a weapon", "A beam that is use as a weapon", 5);
        }
}
