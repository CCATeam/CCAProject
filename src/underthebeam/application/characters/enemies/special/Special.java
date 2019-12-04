package underthebeam.application.characters.enemies.special;
/*
 * 
 * class pour les coup special utilisable une fois.
 * 
 */
public abstract class Special {
	
	private boolean usable = true; 
	
	public boolean getUse() {
		boolean tmp = this.usable;
		if (this.usable)
			this.usable = !usable;
		return tmp;
	}
	
	public abstract int specialSkill();
	
	
	public abstract String toString();
	
}
