/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.InstanceCreator;
import game.application.items.weapon.Axe;
import game.application.items.weapon.Weapon;
import java.lang.reflect.Type;

class WeaponInstanceCreator implements InstanceCreator<Weapon>
{

    @Override
    public Weapon createInstance(Type type) {
        return new Weapon(null, null) {};
    }

}
