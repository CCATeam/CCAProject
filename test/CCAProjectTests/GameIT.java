/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCAProjectTests;

import game.application.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fabien
 */
public class GameIT {
    
    private Game game;
    
    @Before
    public void setUp() {
        this.game = new Game();
    }
    
     /**
     * Test of take method, of class Game.
     */
    @Test
    public void testTake() throws Exception {
        String ob = null;
        System.out.println("take test");
        Game gameInstance = new Game();
        gameInstance.initializeGame();
       
        assertEquals(null, gameInstance.getHeroPlace().getItemByName(ob));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
