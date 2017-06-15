package com.ghy.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghy.answer.domain.Result;
import com.ghy.answer.repository.ResultRepository;

/*
 * ResultService业务类
 * 为结果模块提供服务
 * 添加@Service注解表明这个类是业务类
 * */
@Service
public class ResultService {
	
	/*
	 * 添加@Autowired 
	 * 注入数据访问类ResultRepository
	 */
	@Autowired
	private ResultRepository resultRepository;
	
	/*
	 * 获取某位学生的全部答题情况
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public List<Result> getStudentResult(Integer studentId){
		List<Result> results = resultRepository.findByStudentId(studentId);
		return results;
	}
	
	/*
	 * 保存一条学生答题记录
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public void save(Result result){	
		resultRepository.save(result);
	}
}
