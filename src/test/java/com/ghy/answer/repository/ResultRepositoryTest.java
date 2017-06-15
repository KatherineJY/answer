package com.ghy.answer.repository;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ghy.answer.domain.Result;

public class ResultRepositoryTest {
	private ApplicationContext ctx = null;
	private ResultRepository resultRepository = null;
	
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
		resultRepository = ctx.getBean(ResultRepository.class);
		System.out.println("setup");
	}
	
	@After
	public void tearDwon(){
		ctx = null;
		System.out.println("tearDown");
	}
	
	@Test
	public void testFindByStudentId(){
		List<Result> results = resultRepository.findByStudentId(41510060);
		for(Result result:results){
			System.out.println(result.getAccuracy());
		}
	}
}
