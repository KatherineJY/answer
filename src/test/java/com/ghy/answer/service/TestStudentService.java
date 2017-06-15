package com.ghy.answer.service;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentService {
	private ApplicationContext ctx = null;
	private StudentService studentService = null;
	
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
		studentService = ctx.getBean(StudentService.class);
		System.out.println("setup");
	}
	
	@After
	public void tearDwon(){
		ctx = null;
		System.out.println("tearDown");
	}
	
	@Test
	public void testRegister(){
		System.out.println(studentService.register(41510068, "JY", "111", "123"));
	}
	
	@Test
	public void testLogin() throws IOException{
		System.out.println(studentService.login(41510060, "111"));
	}
	
	@Test
	public void testFindPwd(){
		System.out.println(studentService.findPassword(41510060, "JY", "123"));
	}
	
	@Test
	public void testUpdateBestGrade(){
		studentService.updateBestGrade(41510059,0.08666666666666666, 60);
	}
}
