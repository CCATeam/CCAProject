/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage.instancecreator;

import com.google.gson.InstanceCreator;
import underthebeam.application.characters.enemies.Orc;
import java.lang.reflect.Type;

public class OrcInstanceCreator implements InstanceCreator<Orc>
{

    @Override
    public Orc createInstance(Type type) {
        return new Orc(null, null);
    }
}