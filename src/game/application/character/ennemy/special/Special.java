package game.application.character.ennemy.special;
/*
 * 
 * class pour les coup special utilisable une fois.
 * 
 */
public abstract class Special {
	
	private int usable; 
	
	public Special(int usable) {
		this.usable = usable;
	}
	
	public boolean Use() {
		boolean tmp = this.usable > 0;
		if (tmp)
			this.usable--;
		return tmp;
	}
	
	public boolean getUse() {
		return this.usable > 0;
	}
	
	public abstract int specialSkill();
	
	
	public abstract String toString();
	
}
