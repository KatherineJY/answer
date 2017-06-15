package com.ghy.answer.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghy.answer.domain.Question;
import com.ghy.answer.repository.QuestionRepository;
import com.mysql.fabric.xmlrpc.base.Array;

/*
 * QuestionService业务类
 * 为题目模块提供服务
 * 添加@Service注解表明这个类是业务类
 * */
@Service
public class QuestionService {

	/*
	 * 添加@Autowired 
	 * 注入数据访问类QuestionRepository
	 */
	@Autowired
	private QuestionRepository questionRepository;

	/*
	 * 随机获取试题 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public List<Question> getQuestions() {
		List<Question> questions = questionRepository.selectQuestions();
		return questions;
	}

	/*
	 * 添加題目 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}

	/*
	 * 获取全部题目 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public List<Question> getAllQuestions() {
		List<Question> questions = (List<Question>) questionRepository.findAll();
		return questions;
	}

	/*
	 * 删除试题
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public void deleteQuestion(String discription) {
		List<Question> questions = questionRepository.findByDiscription(discription);
		//根据题目描述找到相关的试题
		List<Integer> ids = new ArrayList<Integer>();
		//找到相关试题对应的id号
		for (Question ques : questions) {
			ids.add(ques.getId());
		}
		//逐一删除相关试题
		for (Integer id : ids)
			questionRepository.delete(id);
	}
}
