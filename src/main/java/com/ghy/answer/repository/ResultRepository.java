package com.ghy.answer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import com.ghy.answer.domain.Result;

/*
 * ResultRepository
 * ����question������ݷ�����
 * */
public interface ResultRepository extends Repository<Result, Integer>{

	/*
	 * ����Repository�����淶���巽��
	 * ʵ�ָ���studentId�ֶλ�ȡ��Ӧ������
	 * */
	public List<Result> findByStudentId(Integer studentId);
	
	/*
	 * �޸Ĳ������@Modifyingע��
	 * �����ݱ������һ������
	 * */
	@Modifying
	public void save(Result result);
}
