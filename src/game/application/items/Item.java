package game.application.items;

import game.application.interfaces.Lookable;

public class Item implements Lookable{

    private final String NAME;
    private final String DESCRIPTION;

    public Item(String NAME, String DESCRIPTION) {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
    @Override
    public String toString() {
        return this.NAME + " : " +this.DESCRIPTION;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DESCRIPTION == null) ? 0 : DESCRIPTION.hashCode());
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (DESCRIPTION == null) {
			if (other.DESCRIPTION != null)
				return false;
		} else if (!DESCRIPTION.equals(other.DESCRIPTION))
			return false;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}

}
