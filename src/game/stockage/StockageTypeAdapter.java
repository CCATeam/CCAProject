package game.stockage;

import com.google.gson.GsonBuilder;
import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.Orc;
import underthebeam.application.items.weapons.Axe;
import underthebeam.application.items.weapons.Sword;
import game.stockage.instancecreator.*;

public class StockageTypeAdapter {

    public StockageTypeAdapter() {
        
    }
    
    /**
     * Set the InstanceCreators to the GsonBuilder.
     * The InstanceCreators force gson to use a specific constructor for a given class.
     * By default gson doesn't use any constructor.
     * 
     * @param gb 
     */
    public void setAdapterToGsonBuilder(GsonBuilder gb) {
        gb.registerTypeAdapter(Hero.class, new HeroInstanceCreator())
        .registerTypeAdapter(Axe.class, new AxeInstanceCreator())
        .registerTypeAdapter(Orc.class, new OrcInstanceCreator())
        .registerTypeAdapter(Sword.class, new SwordInstanceCreator());
    }
}
