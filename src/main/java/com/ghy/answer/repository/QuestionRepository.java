package com.ghy.answer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ghy.answer.domain.Question;

/*
 * QuestionRepository
 * ��Question�������ɾ��Ĳ��������ݷ�����
 * ����ӿڼ̳�CrudRepository
 * */
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	
	/*
	 * ��@Queryע����ʹ��Ԯ��sql���
	 * ʵ�ִ����ݿ������ѡȡ30������
	 * */
	@Query(nativeQuery = true, value="SELECT * FROM question ORDER BY RAND() LIMIT 30" )
	public List<Question> selectQuestions();

	/*
	 * �޸Ĳ������@Modifyingע��
	 * �����ݱ������һ������
	 * */
	@Modifying
	public Question save(Question question);
	
	/*
	 * ����Repository�����淶���巽��
	 * ʵ�ָ���discription�ֶλ�ȡ��Ӧ������
	 * */
	public List<Question> findByDiscription(String discription);
}
