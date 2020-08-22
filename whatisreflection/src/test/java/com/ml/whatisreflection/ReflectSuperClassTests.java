package com.ml.whatisreflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReflectSuperClassTests {
    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Goat goat = new Goat("goat");
        Class<?> goatClass = goat.getClass();
        Class<?> goatSuperClass = goatClass.getSuperclass();

        String str = "any string";
        Class<?> strClass = str.getClass();
        Class<?> strSuperClass = strClass.getSuperclass();

        assertEquals("Animal", goatSuperClass.getSimpleName());
        assertEquals("String", strClass.getSimpleName());
        assertEquals("Object", strSuperClass.getSimpleName());
    }
}