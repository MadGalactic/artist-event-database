package com.myprojects.artisteventsdb;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;
public class TestArtistClass extends AbstractTest{

    /*
    Verifies that Artist has a first name field
     */
    @Test
    public void TestArtistHasFirstNameField() throws ClassNotFoundException {
        Class artistClass = getClassByName("models.Artist");
        Field firstNameField = null;
        try {
            firstNameField = artistClass.getDeclaredField("firstName");
        } catch (NoSuchFieldException e) {
            fail("Artist class has no first name field");
        }
        Class firstNameClass = firstNameField.getType();
        assertEquals(String.class, firstNameClass);
    }

}
