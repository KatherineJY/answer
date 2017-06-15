package com.ghy.answer.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Result类
 * 添加@Entity注解，表由明Result类对应生成数据库中的result表
 * 每一个属性，对应 数据表中的一个字段
 * */
@Entity
public class Result {
	private Integer id; // 答题情况编号
	private Integer studentId; // 本次答题的学生学号
	private Date date; // 本次答题日期
	private double accuracy; // 本次答题正确率
	private int useTime; // 本次答题所用时间

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	// 编号作为主键 自增
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public int getUseTime() {
		return useTime;
	}

	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}

}
