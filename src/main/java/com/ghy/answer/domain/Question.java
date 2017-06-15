package com.ghy.answer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Question类
 * 添加@Entity注解，表由明Question类对应生成数据库中的question表
 * 每一个属性，对应 数据表中的一个字段
 * */
@Entity
public class Question {

	private Integer id; // 题目编号
	private String discription; // 题目描述
	private String optionA; // 四个选项
	private String optionB;
	private String optionC;
	private String optionD;
	private String category; // 题目类别
	private char answer; // 题目答案

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	//题目编号设置为主键 自增
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//题目描述的长度不超过120个字符
	@Column(length = 120)
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	//四个选项的长度均不超过20个字符
	@Column(length = 20)
	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	@Column(length = 20)
	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	@Column(length = 20)
	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	@Column(length = 20)
	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public char getAnswer() {
		return answer;
	}

	public void setAnswer(char answer) {
		this.answer = answer;
	}

}
