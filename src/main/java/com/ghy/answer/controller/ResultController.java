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
 * 负责处理前端发来的关于答题情况的请求
 * @Controller 标明这是一个控制器类
 * @RequestMapping 标明这个类的所有方法的url前缀
 * */
@Controller
@RequestMapping("/result")
public class ResultController {
	
	// 获得日志记录
	private static Logger logger = LoggerFactory.getLogger(ResultController.class);

	/*
	 * 添加@Autowired 
	 * 注入业务类ResultService
	 */
	@Autowired
	private ResultService resultService;
	
	/*
	 * 添加@Autowired 
	 * 注入业务类StudentService
	 */
	@Autowired
	private StudentService studentService;

	/*
	 * 匹配路径"/result/submit" 
	 * 响应前端提交某次答题情况的请求
	 */
	@RequestMapping("/submit")
	public @ResponseBody ResponseWrapper submitResult(@RequestBody Result result) {
		// 添加访问记录
		logger.info("someone submit");
		// 调用业务类ResultService向result表中添加数据
		// 调用业务类StudentService更新student表中数据
		resultService.save(result);
		studentService.updateBestGrade(result.getStudentId(), result.getAccuracy(), result.getUseTime());
		//返回成功处理的信息
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}
}
