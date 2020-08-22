package com.ml.whatisreflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReflectClassNamesTests {

	@Test
	public void givenObject_whenGetsClassName_thenCorrect() {
		Object goat = new Goat("goat");
		Class<?> clazz = goat.getClass();

		assertEquals("Goat", clazz.getSimpleName());
		assertEquals("com.ml.whatisreflection.Goat", clazz.getName());
		assertEquals("com.ml.whatisreflection.Goat", clazz.getCanonicalName());
	}

	@Test
	public void givenClassName_whenCreatesObject_thenCorrect() {
		Class<?> clazz = null;
		try {
			clazz = Class.forName("Goat");    // Missing package information, will result in ClassNotFoundException
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			clazz = Class.forName("com.ml.whatisreflection.Goat");    // This would work
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (clazz != null) {
			assertEquals("Goat", clazz.getSimpleName());
			assertEquals("com.ml.whatisreflection.Goat", clazz.getName());
			assertEquals("com.ml.whatisreflection.Goat", clazz.getCanonicalName());
		}
	}
}
