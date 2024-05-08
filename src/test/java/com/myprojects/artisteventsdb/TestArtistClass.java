package com.myprojects.artisteventsdb;

import com.myprojects.artisteventsdb.models.AbstractEntity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
public class TestArtistClass extends AbstractTest{

    /*
    Verifies that Artist extends Abstract Entity
     */
    @Test
    public void TestArtistExtendsAbstractEntity() throws ClassNotFoundException {
        Class artistClass = getClassByName("models.Artist");
        assertEquals(AbstractEntity.class, artistClass.getSuperclass());
    }

    /*
     * Verifies that Artist has a first name field
     * */
    @Test
    public void TestArtistHasFirstNameField() throws ClassNotFoundException{
        Class abstractEntityClass = getClassByName("models.Artist");
        Field firstNameField = null;
        try {
            firstNameField = abstractEntityClass.getDeclaredField("firstName");
        } catch (NoSuchFieldException e) {
            fail("Artist class does not have a first name field");
        }

        Annotation sizeAnnotation = firstNameField.getAnnotation(Size.class);
        assertNotNull(sizeAnnotation, "first name field must use @Size to validate input");

        // we allow for either @NotBlank or @NotNull to ensure the field is not empty
        Annotation notEmptyAnnotation = firstNameField.getAnnotation(NotNull.class);
        if (notEmptyAnnotation == null) {
            notEmptyAnnotation = firstNameField.getAnnotation(NotBlank.class);
        }

        assertNotNull(notEmptyAnnotation, "first name must have an annotation to ensure the field is not empty");
    }

    /*
     * Verifies that Artist has a last name field
     * */
    @Test
    public void TestArtistHasLastNameField() throws ClassNotFoundException{
        Class abstractEntityClass = getClassByName("models.Artist");
        Field lastNameField = null;
        try {
            lastNameField = abstractEntityClass.getDeclaredField("lastName");
        } catch (NoSuchFieldException e) {
            fail("Artist class does not have a last name field");
        }

        Annotation sizeAnnotation = lastNameField.getAnnotation(Size.class);
        assertNotNull(sizeAnnotation, "last name field must use @Size to validate input");

        // we allow for either @NotBlank or @NotNull to ensure the field is not empty
        Annotation notEmptyAnnotation = lastNameField.getAnnotation(NotNull.class);
        if (notEmptyAnnotation == null) {
            notEmptyAnnotation = lastNameField.getAnnotation(NotBlank.class);
        }

        assertNotNull(notEmptyAnnotation, "last name must have an annotation to ensure the field is not empty");
    }

    /*
     * Verifies that Artist.county has been refactored correctly to be of type County
     * and use @ManyToOne
     * */

//    @Test
//    public void TestCountyField() throws ClassNotFoundException, NoSuchFieldException, NoSuchFieldException {
//        Class artistClass = getClassByName("models.Artist");
//        Field countyField = artistClass.getDeclaredField("county");
//
//        // verify that county is of type County
//        assertEquals(County.class, countyField.getType());
//
//        // verify that getCounty and setCounty have been refatored correctly
//        Method getCountyMethod = artistClass.getMethod("getCounty");
//        assertEquals(County.class, getCountyMethod.getReturnType());
//
//        try {
//            Method setCountyMethod = artistClass.getMethod("setCounty", County.class);
//        } catch (NoSuchMethodException e) {
//            fail("County should have a setCounty method that returns an instance of County");
//        }
//
//        // verify that county has @ManytoOne
//        assertNotNull(countyField.getAnnotation(ManyToOne.class));
//
//    }

}
