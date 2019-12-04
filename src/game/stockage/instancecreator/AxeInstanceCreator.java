package game.stockage.instancecreator;

import com.google.gson.InstanceCreator;
import underthebeam.application.items.weapons.Axe;
import java.lang.reflect.Type;

public class AxeInstanceCreator implements InstanceCreator<Axe>
{

    @Override
    public Axe createInstance(Type type) {
        return new Axe(null, null, null, 0);
    }

}