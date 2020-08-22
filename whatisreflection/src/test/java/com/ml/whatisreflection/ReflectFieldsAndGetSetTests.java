package com.ml.whatisreflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReflectFieldsAndGetSetTests {
    @Test
    public void givenClass_whenGetsPublicFields_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("com.ml.whatisreflection.Bird");
        Field[] fields = birdClass.getFields();

        assertEquals(1, fields.length);
        assertEquals("CATEGORY", fields[0].getName());
    }

    @Test
    public void givenClass_whenGetsPublicFieldByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.ml.whatisreflection.Bird");
        Field field = birdClass.getField("CATEGORY");   // public fields only

        assertEquals("CATEGORY", field.getName());
    }

    @Test
    public void givenClass_whenGetsDeclaredFields_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("com.ml.whatisreflection.Bird");
        Field[] fields = birdClass.getDeclaredFields(); // Can see private fields

        assertEquals(1, fields.length);
        assertEquals("walks", fields[0].getName());
    }

    @Test
    public void givenClass_whenGetsFieldsByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.ml.whatisreflection.Bird");
        Field field = birdClass.getDeclaredField("walks");

        assertEquals("walks", field.getName());
    }

    @Test
    public void givenClassField_whenGetsType_thenCorrect() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName("com.ml.whatisreflection.Bird")
                .getDeclaredField("walks");
        Class<?> fieldClass = field.getType();

        assertEquals("boolean", fieldClass.getSimpleName());
    }

    @Test
    public void givenClassField_whenSetsAndGetsValue_thenCorrect()
            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.ml.whatisreflection.Bird");
        Bird bird = (Bird) birdClass.getConstructor().newInstance();
        Field fieldWalks = birdClass.getDeclaredField("walks");

        fieldWalks.setAccessible(true);

        assertFalse(fieldWalks.getBoolean(bird));
        assertFalse(bird.walks());

        fieldWalks.set(bird, true);

        assertTrue(fieldWalks.getBoolean(bird));
        assertTrue(bird.walks());
    }

    @Test
    public void givenClassField_whenGetsAndSetsWithNull_thenCorrect()
            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        // No need to create an instance to get value of public static field on a class
        Class<?> birdClass = Class.forName("com.ml.whatisreflection.Bird");
        Field field = birdClass.getField("CATEGORY");

        field.setAccessible(true);

        assertEquals("domestic", field.get(null));
    }
}