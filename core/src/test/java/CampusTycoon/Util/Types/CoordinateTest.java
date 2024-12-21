package CampusTycoon.Util.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
    

    @Test
    public void test_createCoordinate_defaultConstructor(){

        Coordinate newCoord = new Coordinate();

        assertEquals(0, newCoord.x);
        assertEquals(0, newCoord.y);
    }

    @Test
    public void test_createCoordinate_argsConstructor(){

        Coordinate newCoord = new Coordinate(4,5);

        assertEquals(4, newCoord.x);
        assertEquals(5, newCoord.y);
    }


    @Test void test_coordDistance(){

        Coordinate x = new Coordinate(1,1);
        Coordinate y = new Coordinate(2,2);

        assertEquals(1.414, y.distance(x), 0.1);

    }

}
