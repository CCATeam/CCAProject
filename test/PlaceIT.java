
import game.application.character.Hero;
import game.application.character.ennemy.Orc;
import game.application.interfaces.Actionnable;
import game.application.interfaces.Lookable;
import game.application.items.Chest;
import game.application.items.ChestKey;
import game.application.items.Item;
import game.application.items.weapon.Sword;
import game.application.character.Character;
import game.application.places.Exit;
import game.application.places.LockedExit;
import game.application.places.Place;
import game.application.places.WoodenDoorExit;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlaceIT {
    
    private Map<String, Character> characters;
    private Map<String, Exit> exits1;
    private Map<String, Exit> exits2;
    private Map<String, Item> items;
    private Item i;
    private Hero hero;
    private Place p1;
    private Place p2;
    
    @Before
    public void setUp() {
        
        hero = new Hero("player", 100, null);
        Orc orc = new Orc("orc1", null);
        this.characters = new HashMap<>();
        this.characters.put(hero.getNAME(), hero);
        this.characters.put(orc.getNAME(), orc);
    
        this.exits1 = new HashMap<>();
        Exit ex = new WoodenDoorExit("Wooden door", "woodendoor"); 
        this.exits1.put("couloir", ex);
              
        this.items = new HashMap<>();
        i = new ChestKey("key", "key");
        this.items.put(i.getNAME(), i);
        this.p1 = new Place("chambre", "La chambre", characters, exits1, items);
        
        this.exits2 = new HashMap<>();
        Exit lockedEx = new LockedExit("Locked exit", "lockedexit", true);
        this.exits2.put("chambre", lockedEx);
        
        this.p2 = new Place("chambre", "La chambre", characters, exits2, null);
        
    }
   
   
    @Test
    public void testInitialize() {
        this.p1.initialize();
        this.p2.initialize();
        assertSame(this.p1.getLookables().size(), 2);
        assertSame(this.p2.getLookables().size(), 1);
    }
    
    @Test
    public void testGetLookable() {
        this.p1.initialize();
        this.p2.initialize();
        Lookable l = this.p1.getLookable(null);
        assertNull(l);
    }

    @Test
    public void testGetLookable2() {
        this.p1.initialize();
        this.p2.initialize();
        Lookable l = this.p1.getLookable("key");
        assertSame(l.getNAME(), this.i.getNAME());
    }
    
    @Test
    public void testGetActionnable() {
        this.p1.initialize();
        this.p2.initialize();
        Actionnable a = this.p1.getActionnable(null);
        assertNull(a);
    }
    
    @Test
    public void testGetActionnable2() {
        this.p1.initialize();
        this.p2.initialize();
        Actionnable a = this.p2.getActionnable("lockedexit");
        assertTrue(a instanceof LockedExit);
    }
    
    @Test
    public void testAddCharacter() {
        //If something fail an error appeared
        this.p1.initialize();
        this.p2.initialize();
        Character c = null;
        this.p1.addCharacter(c);      
    }
    
    @Test
    public void testAddCharacter2() {
        this.p1.initialize();
        this.p2.initialize();
        Character c = new Hero("hero2", 55, p1);
        this.p1.addCharacter(c);      
        assertSame(this.p1.getCharacterByName(c.getNAME()), c);
    }
    
    @Test
    public void testRemoveItem() {
        this.p1.initialize();
        this.p1.removeItem(null);
    }

    @Test
    public void testRemoveItem2() {
        this.p1.initialize();
        this.p1.removeItem(this.i);
        assertNull(this.p1.getItemByName(this.i.getNAME()));
    }
    
    @Test
    public void testRemoveCharacter() {
        this.p1.initialize();
        this.p1.removeCharacter(null);
    }

    @Test
    public void testRemoveCharacter2() {
        this.p1.initialize();
        this.p1.removeCharacter(this.hero);
        assertNull(this.p1.getCharacterByName(this.hero.getNAME()));
    }
}
