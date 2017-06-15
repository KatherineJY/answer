package com.ghy.answer.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ghy.answer.domain.Question;
import com.ghy.answer.repository.QuestionRepository;

public class TestQuestionService {
	private ApplicationContext ctx = null;
	private QuestionService questionService = null;
	
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
		questionService = ctx.getBean(QuestionService.class);
		System.out.println("setup");
	}
	
	@After
	public void tearDwon(){
		ctx = null;
		System.out.println("tearDown");
	}
	
	@Test
	public void testAddQuestion(){
		Question question = new Question();
		question.setCategory("体育");
		question.setDiscription("奥运会游泳比赛池中设有多少泳道?");
		question.setOptionA("6");
		question.setOptionB("7");
		question.setOptionC("8");
		question.setOptionD("9");
		question.setAnswer('C');
		
		questionService.addQuestion(question);
	}
	
	
	@Test
	public void TestDeleteByDiscription(){
		questionService.deleteQuestion("vvvvv");
	}
	
}
