package CampusTycoon.Util.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TupleTest {
    

    @Test 
    public void test_createTuple(){
        
        Tuple<String, Integer> a = new Tuple<String,Integer>("test", 5);

        assertEquals("test", a.x);
        assertEquals(5, a.y);

    }


    @Test
    public void test_toString(){

        Tuple<String, Integer> a = new Tuple<String,Integer>("test", 5);

        String expectedStr = "[ test : 5 ]";
        assertEquals(expectedStr, a.toString());

    }

    @Test
    public void test_equals(){
        Tuple<String, Integer> a = new Tuple<String,Integer>("test", 5);
        Tuple<String, Integer> b = new Tuple<String,Integer>("test", 5);

        assertTrue(a.equals(b));

    }

}
