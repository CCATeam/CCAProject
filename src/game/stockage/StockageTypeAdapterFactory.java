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
import underthebeam.application.places.WoodenDoorExit;
import underthebeam.application.items.weapons.Sword;
import game.application.items.weapon.Weapon;
import game.application.places.FinalPlace;
import game.application.places.Place;
import game.application.characters.Character;
import underthebeam.application.characters.enemies.LordDuck;
import underthebeam.application.items.Bread;
import underthebeam.application.items.ClassicBeam;
import underthebeam.application.items.TrapedBeam;
import underthebeam.application.items.Wine;
import underthebeam.application.items.weapons.BeamWeapon;
import underthebeam.application.places.FogExit;
import underthebeam.application.places.LockedDoorExit;
import underthebeam.application.places.WaterFallExit;

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
                .of(Character.class, "type")
                .registerSubtype(Hero.class, "hero")
                .registerSubtype(Orc.class, "orc")
                .registerSubtype(LordDuck.class, "lord duck")
       );
        
        //Define subtypes for Exit
        gb.registerTypeAdapterFactory( 
                RuntimeTypeAdapterFactory
                .of(Exit.class, "type")
                .registerSubtype(Exit.class, "exit")
                .registerSubtype(WoodenDoorExit.class, "wooden door")
                .registerSubtype(LockedDoorExit.class, "locked exit")
                .registerSubtype(FogExit.class, "fog")
                .registerSubtype(WaterFallExit.class, "waterfall")
        );

        //Define subtypes for Item
        gb.registerTypeAdapterFactory(
                RuntimeTypeAdapterFactory
                .of(Item.class, "type")
                .registerSubtype(Item.class, "item")
                .registerSubtype(DoorKey.class, "door key")
                .registerSubtype(ChestKey.class, "chest key")
                .registerSubtype(Chest.class, "chest")
                .registerSubtype(Weapon.class, "weapon")
                .registerSubtype(Axe.class, "axe")
                .registerSubtype(Sword.class, "sword")
                .registerSubtype(BeamWeapon.class, "beam weapon")
                .registerSubtype(Wine.class, "wine")
                .registerSubtype(Bread.class, "bread")
                .registerSubtype(ClassicBeam.class, "beam classic")
                .registerSubtype(TrapedBeam.class, "beam traped")
        );
    }
}
