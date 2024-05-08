package com.myprojects.artisteventsdb;

import com.myprojects.artisteventsdb.models.AbstractEntity;
import com.myprojects.artisteventsdb.models.Artist;
import com.myprojects.artisteventsdb.models.County;
import jakarta.persistence.ManyToMany;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;
public class TestCountyClass extends AbstractTest {

     /*
    Verifies that County extends Abstract Entity
     */

    @Test
    public void TestCountyExtendsAbstractEntity() throws ClassNotFoundException {
        Class countyClass = getClassByName("models.County");
        assertEquals(AbstractEntity.class, countyClass.getSuperclass());
    }

    /*
        Verifies that County.artists exists
     */

    @Test
    public void testCountyClassHasArtistsField() throws ClassNotFoundException {
        Class countyClass = getClassByName("models.County");
        Field artistsField = null;

        try {
            artistsField = countyClass.getDeclaredField("artists");
        } catch (NoSuchFieldException e) {
            fail("County class does not have a artists field");
        }
    }

    /*
        Verifies that County.artists is of type List (or a subclass of List)
     */

    @Test
    public void testCountyArtistsFieldHasCorrectType () throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class countyClass = getClassByName("models.County");
        Method getArtistsMethod = countyClass.getMethod("getArtists");
        County county = new County();
        Object artistsObj = getArtistsMethod.invoke(county);
        assertTrue(artistsObj instanceof List);
    }

    /*
        Verifies that County.artist has been refactored correctly to be of type Artist and use @ManytoMany
     */
//    @Test
//    public void TestArtistField() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
//        Class countyClass = getClassByName("models.County");
//        Field artistField = countyClass.getDeclaredField("artist");
//
//        // verify that artist is of type Artist
//        assertEquals(Artist.class, artistField.getType());
//
//        // verify that getArtist and setArtist have been refactored properly
//        Method getArtistMethod = countyClass.getMethod("getArtist");
//        assertEquals(Artist.class, getArtistMethod.getReturnType());
//
//        try {
//            Method setArtistMethod = countyClass.getMethod("setArtist", Artist.class);
//        } catch (NoSuchMethodException e) {
//            fail("Artist should have a setArtist method that returns an instance of Artist");
//        }
//
//        //verify that artist has @ManytoMany
//        assertNotNull(artistField.getAnnotation(ManyToMany.class));
//
//    }


}
