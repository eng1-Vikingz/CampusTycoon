package com.vikingz.headless;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vikingz.Person;

public class PersonTest {
    
    @BeforeEach
    public void setup() {
        HeadlessLauncher.main(new String[0]);
    }
    
    @Test
    public void testPerson() {

        Person person = new Person("John", "Doe");
        System.out.println(person.getFullName());

        assertEquals("John Doe", person.getFullName());
    }

    @Test
    public void testFilesExist() {


        Person person = new Person("John", "Doe");
        assertEquals(false, person.filesExist());
    }

}
