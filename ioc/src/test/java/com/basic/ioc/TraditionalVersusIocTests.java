package com.basic.ioc;

import com.basic.ioc.fromTraditionalToIoc.Address;
import com.basic.ioc.fromTraditionalToIoc.Company;
import com.basic.ioc.fromTraditionalToIoc.Config;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TraditionalVersusIocTests {

	@Test
	void traditional() {
		Address address = new Address("High Street", 1000);
		Company company = new Company(address);
		assertEquals("High Street", company.getAddress().getStreet());
		assertEquals(1000, company.getAddress().getNumber());
	}

	@Test
	void ioc() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		Company company = applicationContext.getBean(Company.class);
		assertEquals("High Street", company.getAddress().getStreet());
		assertEquals(1000, company.getAddress().getNumber());
	}
}
