/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.InstanceCreator;
import game.application.character.Character;
import java.lang.reflect.Type;

/**
 *
 * @author Fabien
 */
class CharacterInstanceCreator implements InstanceCreator<Character>
{

    @Override
    public Character createInstance(Type type) {
        return new Character(null, 0, null) { };
    }
}
