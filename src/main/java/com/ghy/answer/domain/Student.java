package com.ghy.answer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Student类
 * 添加@Entity注解，表由明Student类对应生成数据库中的student表
 * 每一个属性，对应 数据表中的一个字段
 * */
@Entity
public class Student {
	private String name; // 学生姓名
	private Integer id; // 学生学号
	private String phone; // 学生电话
	private String password;// 学生密码
	private double accuracy;// 学生最高正确率
	private int time; // 学生最高正确率下的答题用时

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//学生姓名长度不超过20个字符
	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//将学号设置为主键
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 11)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
