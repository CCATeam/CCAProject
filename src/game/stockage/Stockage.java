/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stockage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import game.application.character.Hero;
import game.application.character.Character;
import game.application.items.DoorKey;
import game.application.items.Item;
import game.application.places.ClosedDoorExit;
import game.application.places.Exit;
import game.application.places.Place;
import game.application.places.WoodenDoorExit;
import java.util.List;

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
        
        //Défini les sous-types de Character pour pouvoir récupérer tout d'un coup 
        //dans le json
        RuntimeTypeAdapterFactory<Character> runtimeTypeAdapterFactoryCharacter;
        runtimeTypeAdapterFactoryCharacter = RuntimeTypeAdapterFactory
                .of(Character.class, "type")
                .registerSubtype(Hero.class, "hero");
        
        //Défini les sous-types de Exit pour pouvoir récupérer tout d'un coup 
        //dans le json
        RuntimeTypeAdapterFactory<Exit> runtimeTypeAdapterFactoryExit;
        runtimeTypeAdapterFactoryExit = RuntimeTypeAdapterFactory
                .of(Exit.class, "type")
                .registerSubtype(Exit.class, "exit")
                .registerSubtype(WoodenDoorExit.class, "wooden door")
                .registerSubtype(ClosedDoorExit.class, "closed door");

        //Défini les sous-types de Exit pour pouvoir récupérer tout d'un coup 
        //dans le json
        RuntimeTypeAdapterFactory<Item> runtimeTypeAdapterFactoryItem;
        runtimeTypeAdapterFactoryItem = RuntimeTypeAdapterFactory
                .of(Item.class, "type")
                .registerSubtype(Item.class, "item")
                .registerSubtype(DoorKey.class, "door key");
        
        Gson g = new GsonBuilder()
            .registerTypeAdapterFactory(runtimeTypeAdapterFactoryCharacter)
            .registerTypeAdapterFactory(runtimeTypeAdapterFactoryExit)
            .registerTypeAdapterFactory(runtimeTypeAdapterFactoryItem)
            .create();
        
        List<Place> lp = g.fromJson("["
                                    + "{"
                                        +"\"NAME\": \"chambre\","
                                        +"\"DESCRIPTION\": \"premiere place, il y a un item1,une doorkey et une woodendoor\","
                                        +"\"CHARACTERS\": {"
                                                        + "\"testCharMap1\": {"
                                                               +"\"type\": \"hero\","
                                                               +"\"NAME\": \"testCharMap1\","
                                                               +"\"life\": 100,"
                                                               +"\"location\": \"location1\""
                                                        + "},"
                                                        + " \"test2CharMap1\": {"
                                                               +"\"type\": \"hero\","
                                                               +"\"NAME\": \"test2CharMap1\","
                                                               +"\"life\": 100"
                                                        + "}"
                                                       +"},"
                                        +"\"EXITS\": {"
                                                    + "\"couloir\": {"
                                                           +"\"type\": \"wooden door\","
                                                           +"\"NAME\": \"woodendoor\","
                                                           +"\"DESCRIPTION\": \"Porte en bois qui mène vers la salle test2\""
                                                    + "}"
                                                  +"},"
                                        +"\"ITEMS\": {"
                                                        + "\"item1\": {"             
                                                               +"\"type\": \"item\","
                                                               +"\"NAME\": \"item1\","
                                                               +"\"DESCRIPTION\": \"blablabla1\""
                                                        + "},"
                                                        + "\"doorkey\": {"
                                                               +"\"type\": \"door key\","
                                                               +"\"NAME\": \"doorkey\","
                                                               +"\"DESCRIPTION\": \"blablabla2\""
                                                        + "}"
                                                  +"}"
                                    + "},"
                                    + "{"
                                        +"\"NAME\": \"couloir\","
                                        +"\"DESCRIPTION\": \"deuxieme place\","
                                        +"\"CHARACTERS\": {"
                                                        + " \"testCharMap2\": {"
                                                               +"\"type\": \"hero\","
                                                               +"\"NAME\": \"testCharMap2\","
                                                               +"\"life\": 100"
                                                        + "},"
                                                        + " \"test2CharMap2\": {"
                                                               +"\"type\": \"hero\","
                                                               +"\"NAME\": \"test2CharMap2\","
                                                               +"\"life\": 100"
                                                        + "}"
                                                       +"},"
                                        +"\"EXITS\": {"
                                                    + "\"chambre\":{"
                                                           +"\"type\": \"exit\","
                                                           +"\"NAME\": \"exittest\","
                                                           +"\"DESCRIPTION\": \"testExit\""
                                                    + "},"
                                                    + "\"sortie\":{"
                                                           +"\"type\": \"closed door\","
                                                           +"\"NAME\": \"closeddoor\","
                                                           +"\"DESCRIPTION\": \"testExit\","
                                                           +"\"closed\": true"
                                                    + "}"
                                                  +"},"
                                        +"\"ITEMS\": {"
                                                        + "\"item3\": {"
                                                               +"\"type\": \"item\","
                                                               +"\"NAME\": \"item3\","
                                                               +"\"DESCRIPTION\": \"blabla3\""
                                                        + "},"
                                                        + "\"item4\": {"
                                                               +"\"type\": \"item\","
                                                               +"\"NAME\": \"item4\","
                                                               +"\"DESCRIPTION\": \"blabla4\""
                                                        + "}"
                                                       +"}"
                                    + "},"
                                    + "{"
                                        +"\"NAME\": \"sortie\","
                                        +"\"DESCRIPTION\": \"Congratulation, you finished the game ! You can quit now.\","
                                        +"\"CHARACTERS\": {"
                                                       +"},"
                                        +"\"EXITS\": {"
                                            
                                                   +"},"
                                        +"\"ITEMS\": {"
                                                    +"}"
                                    + "}"
                                  + "]", new TypeToken<List<Place>>(){}.getType());
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
