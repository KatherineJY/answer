package com.ghy.answer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Question��
 * ���@Entityע�⣬������Question���Ӧ�������ݿ��е�question��
 * ÿһ�����ԣ���Ӧ ���ݱ��е�һ���ֶ�
 * */
@Entity
public class Question {

	private Integer id; // ��Ŀ���
	private String discription; // ��Ŀ����
	private String optionA; // �ĸ�ѡ��
	private String optionB;
	private String optionC;
	private String optionD;
	private String category; // ��Ŀ���
	private char answer; // ��Ŀ��

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	//��Ŀ�������Ϊ���� ����
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//��Ŀ�����ĳ��Ȳ�����120���ַ�
	@Column(length = 120)
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	//�ĸ�ѡ��ĳ��Ⱦ�������20���ַ�
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
