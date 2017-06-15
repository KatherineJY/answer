package com.ghy.answer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {
	private ApplicationContext ctx = null;
	
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
		System.out.println("setup");
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown");
		ctx = null;
	}
	
	@Test
	public void testEntityManagerFactory(){
		
	}
}
