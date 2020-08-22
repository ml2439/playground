package com.ml.whatisreflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReflectConstructorsMethodsFieldsTests {
    @Test
    public void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("com.ml.whatisreflection.Goat");

        Constructor<?>[] constructors = goatClass.getConstructors();

        assertEquals(1, constructors.length);
        assertEquals("com.ml.whatisreflection.Goat", constructors[0].getName());
    }
}