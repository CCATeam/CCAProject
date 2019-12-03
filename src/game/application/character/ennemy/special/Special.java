package game.application.character.ennemy.special;
/*
 * 
 * class pour les coup special utilisable une fois.
 * 
 */
public abstract class Special {
	
	private boolean usable = true; 
	
	public boolean getUse() {
		if (this.usable)
			this.usable = !usable;
		return usable;
	}
	
	public abstract int specialSkill();
	
	
	public abstract String toString();
}
