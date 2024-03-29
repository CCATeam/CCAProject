/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.application.interfaces;

import game.application.exceptions.NonAvailableActionException;

public interface Actionnable {
    
    public void action(Usable u) throws NonAvailableActionException;

    public static boolean isActionnable(Object o) {
        return o instanceof Actionnable;
    }
}
