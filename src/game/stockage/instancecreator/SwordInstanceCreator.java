package game.stockage.instancecreator;


import com.google.gson.InstanceCreator;
import game.application.items.weapon.Sword;
import java.lang.reflect.Type;

public class SwordInstanceCreator implements InstanceCreator<Sword>
{

    @Override
    public Sword createInstance(Type type) {
        return new Sword();
    }

}