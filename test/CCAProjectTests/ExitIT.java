package CCAProjectTests;

import underthebeam.application.characters.Hero;
import game.application.characters.Character;
import game.application.exceptions.LockedExitException;
import game.application.places.Exit;
import game.application.places.LockedExit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import underthebeam.application.places.LockedDoorExit;

public class ExitIT {
    
    Exit e;
    Character c;
    
    @Before
    public void setUp() {
        this.e = new LockedDoorExit("a locked exit", "exit", true);
        this.c = new Hero("player", 15, null, null);
    }
   
    @Test
    public void testCanPass() {
        try {
            this.e.canPass(c);
            assertTrue(false);
        } catch (LockedExitException ex) {
            assertTrue(true);
        }  
    }
    
    @Test
    public void testCanPass2() {
        try {
            ((LockedExit)this.e).unlock();
            this.e.canPass(c);
            assertTrue(true);
        } catch (LockedExitException ex) {
            assertTrue(false);
        }  
    }
}
