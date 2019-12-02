/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.interfaces;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface Lookable {
    
    public default String looked() {
        return this.toString();
    }
    
    public abstract String getNAME();
    
    /**
     * Static method that says if an object is of type Lookable
     * @param o
     * @return 
     */
    public static boolean isLookable(Object o) {
        return o instanceof Lookable;
    }
    
    /**
     * Recup all the Lookables from a Collection and
     * construct a Map<String, Lookable> from that object.
     * @param l
     * @return 
     */
    public static Map<String, Lookable> GetLookables(Collection<? extends Object> l) {
        Map lookables = new HashMap<>();
        
        if(l != null) {        
            Stream s = l.stream();
            s = s.filter(e -> Lookable.isLookable(e));
            s.forEach(e -> lookables.put(((Lookable) e).getNAME(), e));
        }
        return lookables;
    }
}
