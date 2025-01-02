package CampusTycoon.Util.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
    

    @Test
    public void testCreateCoordinate_defaultConstructor(){

        Coordinate newCoord = new Coordinate();

        assertEquals(0, newCoord.x);
        assertEquals(0, newCoord.y);
    }

    @Test
    public void testCreateCoordinate_argsConstructor(){

        Coordinate newCoord = new Coordinate(4,5);

        assertEquals(4, newCoord.x);
        assertEquals(5, newCoord.y);
    }


    @Test 
    void testCoordDistance(){

        Coordinate x = new Coordinate(1,1);
        Coordinate y = new Coordinate(2,2);

        assertEquals(1.414, y.distance(x), 0.1);

    }

    @Test
    void testEquals(){

        Coordinate a = new Coordinate(1,2);
        Coordinate b = new Coordinate(1,2);
        Coordinate c = new Coordinate(999,999);

        assertTrue(a.equals(a));
        assertTrue(a.equals(b));
        
        assertFalse(a.equals(c));
        assertFalse(a.equals(null));
        assertFalse(a.equals(new Object()));

    }    

}
