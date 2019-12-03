/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.InstanceCreator;
import game.application.items.weapon.Axe;
import java.lang.reflect.Type;

class AxeInstanceCreator implements InstanceCreator<Axe>
{

    @Override
    public Axe createInstance(Type type) {
        return new Axe();
    }

}