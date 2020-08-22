package com.ml.whatisreflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReflectClassModifiersTests {

	@Test
	public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
		Class<?> goatClass = Class.forName("com.ml.whatisreflection.Goat");
		Class<?> animalClass = Class.forName("com.ml.whatisreflection.Animal");

		int goatMods = goatClass.getModifiers();
		int animalMods = animalClass.getModifiers();

		assertTrue(Modifier.isPublic(goatMods));
		assertTrue(Modifier.isAbstract(animalMods));
		assertTrue(Modifier.isPublic(animalMods));
	}
}
