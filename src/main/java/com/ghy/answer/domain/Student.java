package com.ghy.answer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Student��
 * ���@Entityע�⣬������Student���Ӧ�������ݿ��е�student��
 * ÿһ�����ԣ���Ӧ ���ݱ��е�һ���ֶ�
 * */
@Entity
public class Student {
	private String name; // ѧ������
	private Integer id; // ѧ��ѧ��
	private String phone; // ѧ���绰
	private String password;// ѧ������
	private double accuracy;// ѧ�������ȷ��
	private int time; // ѧ�������ȷ���µĴ�����ʱ

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

	//ѧ���������Ȳ�����20���ַ�
	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//��ѧ������Ϊ����
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
