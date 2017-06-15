package com.ghy.answer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ghy.answer.domain.Question;
import com.ghy.answer.model.ResponseWrapper;
import com.ghy.answer.service.QuestionService;

/*
 * QuestionController
 * 负责处理前端发来的关于题目的请求
 * @Controller 标明这是一个控制器类
 * @RequestMapping 标明这个类的所有方法的url前缀
 * */
@Controller
@RequestMapping("/ques")
public class QuestionController {

	// 获得日志记录
	private static Logger logger = LoggerFactory.getLogger(QuestionController.class);

	/*
	 * 添加@Autowired 
	 * 注入业务类QuestionService
	 */
	@Autowired
	private QuestionService questionService;

	/*
	 * 匹配路径"/ques/getQues" 
	 * 响应前端获取题目的需求
	 */
	@RequestMapping("/getQues")
	public @ResponseBody ResponseWrapper getQues() {
		// 添加访问记录
		logger.info("get questions");
		// 调用业务类获取题目
		List<Question> questions = questionService.getQuestions();
		// 将数据封装到responseWrapper的body中
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setBody(questions);
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}

	/*
	 * 匹配路径"/ques/getAllQues" 
	 * 响应前端获取所有题目的需求
	 */
	@RequestMapping("/getAllQues")
	public @ResponseBody ResponseWrapper getAllQues() {
		// 添加访问记录
		logger.info("get all questions");
		// 调用业务类获取题目
		List<Question> questions = questionService.getAllQuestions();
		// 将数据封装到responseWrapper的body中
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setBody(questions);
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}

	/*
	 * 匹配路径"/ques/addQues" 
	 * 响应前端添加题目的需求
	 * 以json格式传入试题实例
	 * 实例符合Question对象的规范
	 */
	@RequestMapping("/addQues")
	public @ResponseBody ResponseWrapper addQuestion(@RequestBody Question question) {
		// 添加访问记录
		logger.info("get all questions");
		// 调用业务类添加题目
		questionService.addQuestion(question);
		//返回成功添加的信息
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}

	/*
	 * 匹配路径"/ques/deleteQues" 
	 * 响应前端删除题目的需求
	 * 以json格式传入试题实例
	 * 实例符合Question对象的规范
	 */
	@RequestMapping("/deleteQues")
	public @ResponseBody ResponseWrapper deleteQuestion(@RequestBody Question question) {
		// 添加访问记录
		logger.info("get all questions");
		// 调用业务类删除题目
		questionService.deleteQuestion(question.getDiscription());
		//返回成功删除的信息
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}
}
