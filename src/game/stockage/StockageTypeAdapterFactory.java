/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import game.application.character.Hero;
import game.application.character.ennemy.Orc;
import game.application.items.Chest;
import game.application.items.ChestKey;
import game.application.items.DoorKey;
import game.application.items.Item;
import game.application.items.weapon.Axe;
import game.application.places.Exit;
import game.application.places.LockedExit;
import game.application.places.WoodenDoorExit;
import game.application.character.Character;
import game.application.items.weapon.Sword;
import game.application.items.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;

public class StockageTypeAdapterFactory {

    public StockageTypeAdapterFactory() {
    }
    
    /**
     * Set the subtype of specifics class so as to gson can manage
     * polymorphism. By default, cannot.
     * 
     * @param gb 
     */
    public void setAdapterFactoriesToGsonBuilder(GsonBuilder gb) {
         //Define subtypes for Character
       gb.registerTypeAdapterFactory(
               RuntimeTypeAdapterFactory
                .of(game.application.character.Character.class, "type")
                .registerSubtype(Hero.class, "hero")
                .registerSubtype(Orc.class, "orc")
       );
        
        //Define subtypes for Exit
        gb.registerTypeAdapterFactory( 
                RuntimeTypeAdapterFactory
                .of(Exit.class, "type")
                .registerSubtype(Exit.class, "exit")
                .registerSubtype(WoodenDoorExit.class, "wooden door")
                .registerSubtype(LockedExit.class, "locked exit")
        );

        //Define subtypes for Item
        gb.registerTypeAdapterFactory(
                RuntimeTypeAdapterFactory
                .of(Item.class, "type")
                .registerSubtype(Item.class, "item")
                .registerSubtype(DoorKey.class, "door key")
                .registerSubtype(ChestKey.class, "chest key")
                .registerSubtype(Chest.class, "chest")
                .registerSubtype(Axe.class, "axe")
                .registerSubtype(Weapon.class, "weapon")
                .registerSubtype(Sword.class, "sword")
        );
    }
}
