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
 * QuestionServiceҵ����
 * Ϊ��Ŀģ���ṩ����
 * ���@Serviceע������������ҵ����
 * */
@Service
public class QuestionService {

	/*
	 * ���@Autowired 
	 * ע�����ݷ�����QuestionRepository
	 */
	@Autowired
	private QuestionRepository questionRepository;

	/*
	 * �����ȡ���� 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public List<Question> getQuestions() {
		List<Question> questions = questionRepository.selectQuestions();
		return questions;
	}

	/*
	 * ����}Ŀ 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}

	/*
	 * ��ȡȫ����Ŀ 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public List<Question> getAllQuestions() {
		List<Question> questions = (List<Question>) questionRepository.findAll();
		return questions;
	}

	/*
	 * ɾ������
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public void deleteQuestion(String discription) {
		List<Question> questions = questionRepository.findByDiscription(discription);
		//������Ŀ�����ҵ���ص�����
		List<Integer> ids = new ArrayList<Integer>();
		//�ҵ���������Ӧ��id��
		for (Question ques : questions) {
			ids.add(ques.getId());
		}
		//��һɾ���������
		for (Integer id : ids)
			questionRepository.delete(id);
	}
}
