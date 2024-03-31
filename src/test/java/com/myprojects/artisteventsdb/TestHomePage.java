package com.myprojects.artisteventsdb;

import com.myprojects.artisteventsdb.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;


public class TestHomePage extends AbstractTest {

    /*
     * Verifies that HomeController.index is properly defined
     * */
    @Test
    public void testHomeControllerIndexMethodDefinition () throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class homeControllerClass = getClassByName("controllers.HomeController");
        Method indexMethod = null;

        // Verify that the index method exists
        try {
            indexMethod = homeControllerClass.getMethod("index", Model.class);
        } catch (NoSuchMethodException e) {
            fail("HomeController must have an index method that takes a parameter of type Model");
        }

        Annotation annotation = indexMethod.getDeclaredAnnotation(RequestMapping.class);
        // Verify that index has a routing annotation. We need to accommodate
        // both @RequestMapping and @GetMapping.
        if (annotation == null) {
            annotation = indexMethod.getDeclaredAnnotation(GetMapping.class);
        }
        assertNotNull(annotation, "index method must have a routing annotation");
        Method annotationValueMethod = annotation.getClass().getMethod("value");
        String[] values = ((String[]) annotationValueMethod.invoke(annotation));
        assertEquals(1, values.length, "The routing annotation for index must have a value");
        assertEquals("/", values[0], "The value parameter for the routing annotation must be the empty string");

        Model model = new ExtendedModelMap();
        HomeController homeController = new HomeController();
        indexMethod.invoke(homeController, model);
    }



}
