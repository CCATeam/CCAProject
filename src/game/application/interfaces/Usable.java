/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.interfaces;

public interface Usable {
    
    public static boolean isUsable(Object o) {
        return o instanceof Usable;
    }
}
