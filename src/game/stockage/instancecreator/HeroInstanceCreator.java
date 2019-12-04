/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage.instancecreator;

import com.google.gson.InstanceCreator;
import underthebeam.application.characters.Hero;
import java.lang.reflect.Type;

public class HeroInstanceCreator implements InstanceCreator<Hero>
{

    @Override
    public Hero createInstance(Type type) {
        return new Hero(null, 0, null);
    }
}