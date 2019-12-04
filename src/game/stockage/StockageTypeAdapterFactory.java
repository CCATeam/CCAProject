/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import underthebeam.application.characters.Hero;
import underthebeam.application.characters.enemies.Orc;
import underthebeam.application.items.Chest;
import underthebeam.application.items.ChestKey;
import underthebeam.application.items.DoorKey;
import game.application.items.Item;
import underthebeam.application.items.weapons.Axe;
import game.application.places.Exit;
import game.application.places.LockedExit;
import game.application.places.WoodenDoorExit;
import underthebeam.application.items.weapons.Sword;
import game.application.items.weapon.Weapon;

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
       gb.registerTypeAdapterFactory(RuntimeTypeAdapterFactory
                .of(game.application.characters.Character.class, "type")
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
