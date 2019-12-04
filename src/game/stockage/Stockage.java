/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import game.stockage.instancecreator.*;
import game.application.character.Hero;
import game.application.character.Character;
import game.application.character.ennemy.Orc;
import game.application.items.Chest;
import game.application.items.ChestKey;
import game.application.items.DoorKey;
import game.application.items.Item;
import game.application.items.weapon.Axe;
import game.application.items.weapon.Weapon;
import game.application.places.LockedExit;
import game.application.places.Exit;
import game.application.places.Place;
import game.application.places.WoodenDoorExit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabien
 */
public class Stockage {
    
    /**
     * Get the data to generate the game from a json file
     * @return List of Place that conatains all the data
     */
    public List<Place> getDataGame() {
        BufferedReader br = null;
        final String NAMEFILE = "./src/datas/datasJson.js";
        
        try{
            InputStream ips = new FileInputStream(NAMEFILE); 
            InputStreamReader ipsr = new InputStreamReader(ips);
            br = new BufferedReader(ipsr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stockage.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        //Define subtypes 
        RuntimeTypeAdapterFactory<Character> runtimeTypeAdapterFactoryCharacter;
        runtimeTypeAdapterFactoryCharacter = RuntimeTypeAdapterFactory
                .of(Character.class, "type")
                .registerSubtype(Hero.class, "hero")
                .registerSubtype(Orc.class, "orc");
        
        //Défini les sous-types de Exit pour pouvoir récupérer tout d'un coup 
        //dans le json
        RuntimeTypeAdapterFactory<Exit> runtimeTypeAdapterFactoryExit;
        runtimeTypeAdapterFactoryExit = RuntimeTypeAdapterFactory
                .of(Exit.class, "type")
                .registerSubtype(Exit.class, "exit")
                .registerSubtype(WoodenDoorExit.class, "wooden door")
                .registerSubtype(LockedExit.class, "locked exit");

        //Défini les sous-types de Item pour pouvoir récupérer tout d'un coup 
        //dans le json
        RuntimeTypeAdapterFactory<Item> runtimeTypeAdapterFactoryItem;
        runtimeTypeAdapterFactoryItem = RuntimeTypeAdapterFactory
                .of(Item.class, "type")
                .registerSubtype(Item.class, "item")
                .registerSubtype(DoorKey.class, "door key")
                .registerSubtype(ChestKey.class, "chest key")
                .registerSubtype(Chest.class, "chest")
                .registerSubtype(Axe.class, "axe");
        
        GsonBuilder gb = new GsonBuilder()
            .registerTypeAdapterFactory(runtimeTypeAdapterFactoryCharacter)
            .registerTypeAdapterFactory(runtimeTypeAdapterFactoryExit)
            .registerTypeAdapterFactory(runtimeTypeAdapterFactoryItem)
            .registerTypeAdapter(Hero.class, new HeroInstanceCreator())
            .registerTypeAdapter(Axe.class, new AxeInstanceCreator())
            .registerTypeAdapter(Weapon.class, new WeaponInstanceCreator())
            .registerTypeAdapter(Orc.class, new OrcInstanceCreator());
        
        new GraphAdapterBuilder()
            .addType(Place.class)
            .registerOn(gb);
        
        Gson g = gb.create();
        List<Place> lp = g.fromJson(br , new TypeToken<List<Place>>(){}.getType());
       
        return lp;
    }
    
    /*
    public static void main(String[] args) {
        
        Stockage s = new Stockage();
        List<Place> lp = s.getDataGame();
        System.out.println(lp.get(0).getNAME());
        System.out.println(lp.get(0).getDESCRIPTION());
        System.out.println(lp.get(0).getExit("test2").getDescription());
        System.out.println(lp.get(0).getCharacters().get(0).toString());
        System.out.println(lp.get(1).getNAME());
        System.out.println(lp.get(1).getDESCRIPTION());

    }*/
}
