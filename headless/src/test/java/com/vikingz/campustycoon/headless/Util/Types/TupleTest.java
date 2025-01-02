package com.vikingz.campustycoon.headless.Util.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.Util.Types.Tuple;

public class TupleTest {
    

    @Test 
    public void testCreateTuple(){
        
        Tuple<String, Integer> a = new Tuple<String,Integer>("test", 5);

        assertEquals("test", a.x);
        assertEquals(5, a.y);

    }


    @Test
    public void testToString(){

        Tuple<String, Integer> a = new Tuple<String,Integer>("test", 5);

        String expectedStr = "[ test : 5 ]";
        assertEquals(expectedStr, a.toString());

    }

    @Test
    public void testEquals(){
        Tuple<String, Integer> a = new Tuple<String,Integer>("test", 5);
        Tuple<String, Integer> b = new Tuple<String,Integer>("test", 5);

        Tuple<String, Integer> c = new Tuple<String,Integer>("failTest", 999);
        Tuple<String, String> d = new Tuple<String,String>("failTest", "999");
        
        Tuple<String, Integer> e = new Tuple<String,Integer>("test", 999);
        Tuple<String, Integer> f = new Tuple<String,Integer>("999", 5);


        assertTrue(a.equals(a));
        assertTrue(a.equals(b));
        
        assertFalse(a.equals(new Object()));
        assertFalse(a.equals(c));
        assertFalse(a.equals(null));
        assertFalse(a.equals(d));

        assertFalse(a.equals(e));
        assertFalse(a.equals(f));

    }

}
