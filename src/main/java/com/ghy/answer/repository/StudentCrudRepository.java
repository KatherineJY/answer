package com.ghy.answer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ghy.answer.domain.Student;

/*
 * StudentCrudRepository
 * 对Student类进行增删查改操作、分页排序查找的数据访问类
 * 定义接口继承CrudRepository、PagingAndSortingRepository
 * */
public interface StudentCrudRepository extends CrudRepository<Student, Integer>,PagingAndSortingRepository<Student, Integer>{
	
}
