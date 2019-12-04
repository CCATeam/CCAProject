import game.application.character.Hero;
import game.application.character.Character;
import game.application.exceptions.LockedExitException;
import game.application.places.Exit;
import game.application.places.LockedExit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ExitIT {
    
    Exit e;
    Character c;
    
    @Before
    public void setUp() {
        this.e = new LockedExit("a locked exit", "exit", true);
        this.c = new Hero("player", 15, null);
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
