package com.ghy.answer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ghy.answer.domain.Question;

/*
 * QuestionRepository
 * 对Question类进行增删查改操作的数据访问类
 * 定义接口继承CrudRepository
 * */
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	
	/*
	 * 在@Query注解中使用援用sql语句
	 * 实现从数据库中随机选取30条数据
	 * */
	@Query(nativeQuery = true, value="SELECT * FROM question ORDER BY RAND() LIMIT 30" )
	public List<Question> selectQuestions();

	/*
	 * 修改操作添加@Modifying注解
	 * 向数据表中添加一行数据
	 * */
	@Modifying
	public Question save(Question question);
	
	/*
	 * 遵照Repository命名规范定义方法
	 * 实现根据discription字段获取相应的数据
	 * */
	public List<Question> findByDiscription(String discription);
}
