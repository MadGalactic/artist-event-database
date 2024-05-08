package com.myprojects.artisteventsdb;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class TestAbstractEntity extends AbstractTest{

    /*
     * Verifies that AbstractEntity has @MappedSuperclass
     * */
    @Test
    public void testAbstractEntityHasCorrectAnnotation () throws ClassNotFoundException {
        Class abstractEntityClass = getClassByName("models.AbstractEntity");
        Annotation annotation = abstractEntityClass.getAnnotation(MappedSuperclass.class);
        assertNotNull(annotation, "AbstractEntity must have @MappedSuperclass annotation");
    }

    /*
     * Verifies that AbstractEntity.id has correct annotations
     * */
    @Test
    public void testIdFieldHasCorrectAnnotations() throws ClassNotFoundException {
        Class abstractEntityClass = getClassByName("models.AbstractEntity");
        Field idField = null;
        try {
            idField = abstractEntityClass.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            fail("AbstractEntity does not have an id field");
        }

        Annotation idAnnotation = idField.getAnnotation(Id.class);
        assertNotNull(idAnnotation, "id field must have @Id annotation");

        Annotation generatedValueAnnotation = idField.getAnnotation(GeneratedValue.class);
        assertNotNull(generatedValueAnnotation, "id field must have @GeneratedValue annotation");
    }

}
