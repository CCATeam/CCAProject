package game.stockage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import com.google.gson.reflect.TypeToken;
import game.application.places.Place;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Stockage {
    
    /**
     * Get the data to generate the game from a json file
     * @return List of Place that conatains all the data
     */
    public List<Place> getDataGame() {
        
        BufferedReader br = null;
        final String NAMEFILE = "./src/datas/datasJson.js";
        StockageTypeAdapterFactory staf = new StockageTypeAdapterFactory();
        StockageTypeAdapter sta = new StockageTypeAdapter();
        
        try{
            InputStream ips = new FileInputStream(NAMEFILE); 
            InputStreamReader ipsr = new InputStreamReader(ips);
            br = new BufferedReader(ipsr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stockage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        GsonBuilder gb = new GsonBuilder();
        
        //To manage polymorphism
        staf.setAdapterFactoriesToGsonBuilder(gb);
        
        //Force gson to use specifics constructor of chosen class
        sta.setAdapterToGsonBuilder(gb);
        
        //To manage bidirectionnality between Place and other objects
        new GraphAdapterBuilder()
            .addType(Place.class)
            .registerOn(gb);
        
        Gson g = gb.create();
        List<Place> lp = g.fromJson(br , new TypeToken<List<Place>>(){}.getType());
       
        return lp;
    }
    
    public List<Place> getDataGame(StockageTypeAdapterFactory staf, StockageTypeAdapter sta) {
        BufferedReader br = null;
        final String NAMEFILE = "./src/datas/datasJson.js";
        
        try{
            InputStream ips = new FileInputStream(NAMEFILE); 
            InputStreamReader ipsr = new InputStreamReader(ips);
            br = new BufferedReader(ipsr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stockage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        GsonBuilder gb = new GsonBuilder();
        
        //To manage polymorphism
        staf.setAdapterFactoriesToGsonBuilder(gb);
        
        //Force gson to use specifics constructor of chosen class
        sta.setAdapterToGsonBuilder(gb);
        
        //To manage bidirectionnality between Place and other objects
        new GraphAdapterBuilder()
            .addType(Place.class)
            .registerOn(gb);
        
        Gson g = gb.create();
        List<Place> lp = g.fromJson(br , new TypeToken<List<Place>>(){}.getType());
       
        return lp;
    }
}
