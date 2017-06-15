package com.ghy.answer.repository;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ghy.answer.domain.Question;

public class QuestionRepositoryTest {
	private ApplicationContext ctx = null;
	private QuestionRepository questionRepository = null;
	
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
		questionRepository = ctx.getBean(QuestionRepository.class);
		System.out.println("setup");
	}
	
	@After
	public void tearDwon(){
		ctx = null;
		System.out.println("tearDown");
	}
	
	@Test
	public void testSelectQuestions(){
		List<Question> questions = questionRepository.selectQuestions();
	}
	
	@Test
	public void testFindByDiscription(){
		List<Question> questions =  questionRepository.findByDiscription("vvvvv");
		System.out.println(questions);
	}
}
