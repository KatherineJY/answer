package com.ghy.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghy.answer.domain.Result;
import com.ghy.answer.repository.ResultRepository;

/*
 * ResultServiceҵ����
 * Ϊ���ģ���ṩ����
 * ���@Serviceע������������ҵ����
 * */
@Service
public class ResultService {
	
	/*
	 * ���@Autowired 
	 * ע�����ݷ�����ResultRepository
	 */
	@Autowired
	private ResultRepository resultRepository;
	
	/*
	 * ��ȡĳλѧ����ȫ���������
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public List<Result> getStudentResult(Integer studentId){
		List<Result> results = resultRepository.findByStudentId(studentId);
		return results;
	}
	
	/*
	 * ����һ��ѧ�������¼
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public void save(Result result){	
		resultRepository.save(result);
	}
}
