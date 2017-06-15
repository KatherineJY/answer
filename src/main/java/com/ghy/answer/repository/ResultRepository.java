package com.ghy.answer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import com.ghy.answer.domain.Result;

/*
 * ResultRepository
 * 操作question表的数据访问类
 * */
public interface ResultRepository extends Repository<Result, Integer>{

	/*
	 * 遵照Repository命名规范定义方法
	 * 实现根据studentId字段获取相应的数据
	 * */
	public List<Result> findByStudentId(Integer studentId);
	
	/*
	 * 修改操作添加@Modifying注解
	 * 向数据表中添加一行数据
	 * */
	@Modifying
	public void save(Result result);
}
