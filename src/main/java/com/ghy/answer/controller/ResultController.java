package com.ghy.answer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ghy.answer.domain.Result;
import com.ghy.answer.model.ResponseWrapper;
import com.ghy.answer.service.ResultService;
import com.ghy.answer.service.StudentService;

/*
 * ResultController
 * ������ǰ�˷����Ĺ��ڴ������������
 * @Controller ��������һ����������
 * @RequestMapping �������������з�����urlǰ׺
 * */
@Controller
@RequestMapping("/result")
public class ResultController {
	
	// �����־��¼
	private static Logger logger = LoggerFactory.getLogger(ResultController.class);

	/*
	 * ���@Autowired 
	 * ע��ҵ����ResultService
	 */
	@Autowired
	private ResultService resultService;
	
	/*
	 * ���@Autowired 
	 * ע��ҵ����StudentService
	 */
	@Autowired
	private StudentService studentService;

	/*
	 * ƥ��·��"/result/submit" 
	 * ��Ӧǰ���ύĳ�δ������������
	 */
	@RequestMapping("/submit")
	public @ResponseBody ResponseWrapper submitResult(@RequestBody Result result) {
		// ��ӷ��ʼ�¼
		logger.info("someone submit");
		// ����ҵ����ResultService��result�����������
		// ����ҵ����StudentService����student��������
		resultService.save(result);
		studentService.updateBestGrade(result.getStudentId(), result.getAccuracy(), result.getUseTime());
		//���سɹ��������Ϣ
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}
}
