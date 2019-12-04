package game.stockage.instancecreator;


import com.google.gson.InstanceCreator;
import underthebeam.application.items.weapons.Sword;
import java.lang.reflect.Type;

public class SwordInstanceCreator implements InstanceCreator<Sword>
{

    @Override
    public Sword createInstance(Type type) {
        return new Sword(null, null, null, 0);
    }

}