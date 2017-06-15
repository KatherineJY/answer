package com.ghy.answer.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Result��
 * ���@Entityע�⣬������Result���Ӧ�������ݿ��е�result��
 * ÿһ�����ԣ���Ӧ ���ݱ��е�һ���ֶ�
 * */
@Entity
public class Result {
	private Integer id; // ����������
	private Integer studentId; // ���δ����ѧ��ѧ��
	private Date date; // ���δ�������
	private double accuracy; // ���δ�����ȷ��
	private int useTime; // ���δ�������ʱ��

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	// �����Ϊ���� ����
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
