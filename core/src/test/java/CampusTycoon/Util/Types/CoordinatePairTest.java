package CampusTycoon.Util.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordinatePairTest {
    

    @Test
    public void test_createCoordinatePair_defaultConstructor(){

        CoordinatePair coorPair = new CoordinatePair();

        assertEquals(new Coordinate(), coorPair.start);
        assertEquals(new Coordinate(), coorPair.end);

    }

    @Test
    public void test_createCoordinatePair_argsConstructor(){


        Coordinate a = new Coordinate(1,2);
        Coordinate b = new Coordinate(3,4);

        CoordinatePair coorPair = new CoordinatePair(a,b);

        assertEquals(new Coordinate(1,2), coorPair.start);
        assertEquals(new Coordinate(3,4), coorPair.end);

    }

}
