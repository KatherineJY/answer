package com.ghy.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 使路径对应到相应的html上
 * */
@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/")
	public String viewHome() {
		return "index";
	}

	@RequestMapping("/index")
	public String viewHome2() {
		return "index";
	}

	@RequestMapping("/index-mobile")
	public String viewHomeMobile() {
		return "index-mobile";
	}

	@RequestMapping("/answer")
	public String viewAnswer() {
		return "answer";
	}

	@RequestMapping("/answer-mobile")
	public String viewAnswerMoblie() {
		return "answer-mobile";
	}

	@RequestMapping("/login")
	public String viewLogin() {
		return "login";
	}

	@RequestMapping("/login-mobile")
	public String viewLoginMobile() {
		return "login-mobile";
	}

	@RequestMapping("/register")
	public String viewRegister() {
		return "register";
	}

	@RequestMapping("/register-mobile")
	public String viewRegisterMobile() {
		return "register-mobile";
	}

	@RequestMapping("/findback")
	public String viewFind() {
		return "findback";
	}

	@RequestMapping("/findback-mobile")
	public String viewFindMobile() {
		return "findback-mobile";
	}

	@RequestMapping("/problem")
	public String viewProblem() {
		return "problem";
	}

	@RequestMapping("/problem-mobile")
	public String viewProblemMobile() {
		return "problem-mobile";
	}

	@RequestMapping("/result")
	public String viewResult() {
		return "result";
	}

	@RequestMapping("/result-mobile")
	public String viewResultMobile() {
		return "result-mobile";
	}

	@RequestMapping("/adminpage")
	public String viewAdminPage() {
		return "adminpage";
	}
}
