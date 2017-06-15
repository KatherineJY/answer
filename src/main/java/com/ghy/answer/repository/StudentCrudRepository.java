package com.ghy.answer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ghy.answer.domain.Student;

/*
 * StudentCrudRepository
 * ��Student�������ɾ��Ĳ�������ҳ������ҵ����ݷ�����
 * ����ӿڼ̳�CrudRepository��PagingAndSortingRepository
 * */
public interface StudentCrudRepository extends CrudRepository<Student, Integer>,PagingAndSortingRepository<Student, Integer>{
	
}
