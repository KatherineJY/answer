package com.ghy.answer.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ghy.answer.domain.Student;
import com.ghy.answer.model.ResponseWrapper;
import com.ghy.answer.service.StudentService;

/*
 * UserController
 * 负责处理前端发来的关于用户的请求
 * @Controller 标明这是一个控制器类
 * @RequestMapping 标明这个类的所有方法的url前缀
 * */
@Controller
@RequestMapping("/user")
public class UserController {

	// 获得日志记录
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/*
	 * 添加@Autowired 
	 * 注入业务类StudentService
	 */
	@Autowired
	private StudentService studentService;

	/*
	 * 登录
	 * 匹配路径"/user/login/{id}/{pwd}" 
	 * 以post方式提交数据
	 * 登录传入的信息为学号和密码
	 * 以json格式返回数据
	 */
	@RequestMapping(value = "/login/{id}/{pwd}", method = RequestMethod.POST)
	public @ResponseBody ResponseWrapper login(@PathVariable("id") Integer id, @PathVariable("pwd") String pwd) throws IOException {
		// 调用业务类StudentService 返回是否成功登录
		boolean isSuccess = studentService.login(id, pwd);
		// 将结果封装在ResponseWrapper中的succeful属性中
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(isSuccess);
		//添加访问信息
		logger.info("login " + isSuccess);
		return responseWrapper;
	}

	/*
	 * 注册
	 * 匹配路径"/user/register" 
	 * 以post方式提交数据
	 * 以json格式传入一个Student实例
	 * 以json格式返回数据
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseWrapper register(@RequestBody Student student) {
		// 调用业务类StudentService进行注册
		boolean isSuccess = studentService.register(student.getId(), student.getName(), student.getPassword(),
				student.getPhone());
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(isSuccess);
		//添加访问信息
		logger.info("register " + isSuccess);
		return new ResponseWrapper();
	}

	/*
	 * 找回密码
	 * 匹配路径"/user/findPwd" 
	 * 以post方式提交数据
	 * 以json格式传入一个Student实例
	 * 以json格式返回数据
	 */
	@RequestMapping(value = "/findPwd", method = RequestMethod.POST)
	public @ResponseBody ResponseWrapper findPwd(@RequestBody Student student) {
		// 调用业务类StudentService 返回是否成功
		boolean isSuccess = studentService.findPassword(student.getId(), student.getName(), student.getPhone());
		// 将结果封装在ResponseWrapper中的succeful属性中
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setSuccessful(isSuccess);
		//添加访问信息
		logger.info("find back password " + isSuccess);
		return responseWrapper;
	}
	
	/*
	 * 获取前10名信息
	 * 匹配路径"/user/top10" 
	 * 以post方式提交数据
	 * 以json格式返回
	 */
	@RequestMapping(value = "/top10")
	public @ResponseBody ResponseWrapper getTop10() {
		// 调用业务类StudentService 返回是否成功
		List<Student> students = studentService.getTop10();
		// 将结果封装在ResponseWrapper的body中
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setBody(students);
		responseWrapper.setSuccessful(true);
		return responseWrapper;
	}

}
