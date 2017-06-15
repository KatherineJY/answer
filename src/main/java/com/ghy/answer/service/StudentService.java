package com.ghy.answer.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghy.answer.domain.Student;
import com.ghy.answer.repository.StudentCrudRepository;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/*
 * StudentServiceҵ����
 * Ϊ�û�ģ���ṩ����
 * ���@Serviceע������������ҵ����
 * */
@Service
public class StudentService {

	/*
	 * ���@Autowired 
	 * ע�����ݷ�����StudentCrudRepository
	 */
	@Autowired
	private StudentCrudRepository studentCrudRepository;

	/*
	 * ѧ��ע�� ����������ѧ�š��绰���롢���� 
	 * �Ѿ�ע�����ѧ�Ų��ܱ��ٴ�ʹ�� 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public boolean register(Integer id, String name, String password, String phone) {
		if (studentCrudRepository.exists(id))
			return false;

		int year = 18;
		// ��֤ѧ���Ƿ���Ϲ淶
		if ((4 * 100 + year - 4) * 10000 > id
				|| (id > (4 * 100 + year) * 10000 && (4 * 100 + year - 2) * 1000000000 > id)
				|| id > (4 * 100 + year) * 1000000000) {
			System.out.println("id valid");
			return false;
		}
		// ��֤�ַ���Ϣ�Ƿ�Ϊ��
		if (name == null || phone == null || password == null) {
			System.out.println("information missing");
			return false;
		}

		// �����û�������Ϣ����һ����Ӧ��ʵ��
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPhone(phone);
		student.setPassword(encoderPwd(password)); // ��������м���
		student.setAccuracy(0.0);
		student.setTime(301);
		// �������ݷ����࣬�����ݿ�������µ�ѧ����Ϣ
		studentCrudRepository.save(student);
		return true;
	}

	/*
	 * ��¼ ����ѧ������ ���ص�¼�Ƿ�ɹ� 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public boolean login(Integer id, String password) throws IOException {
		// �ҵ���id��ѧ����Ϣ
		Student student = studentCrudRepository.findOne(id);
		// ��֤�����Ƿ�һ��
		if (!decoderPwd(student.getPassword()).equals(password)) // ��֤ǰ��������н���
			return false;
		return true;
	}

	/*
	 * �����һ� ����ѧ�š��������绰���� 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public boolean findPassword(Integer id, String name, String phone) {
		// �ҵ���id��ѧ����Ϣ
		Student student = studentCrudRepository.findOne(id);
		// ��֤�������������������Ϣ
		if (!student.getName().equals(name) || !student.getPhone().equals(phone))
			return false;
		// �����ݿ���ɾȥ��������Ϣ
		studentCrudRepository.delete(id);
		return true;
	}

	/*
	 * ����ѧ������Ѵ���ɼ� ����ѧ����ѧ�š�������ȷ�ʡ�������ʱ 
	 * ���@Transcational��������һ������
	 */
	@Transactional
	public void updateBestGrade(Integer id, double accuracy, int useTime) {
		// �ҵ���id��ѧ����Ϣ
		Student student = studentCrudRepository.findOne(id);
		// �ж��Ƿ���Ҫ���³ɼ�
		if (student.getAccuracy() < accuracy || (student.getAccuracy() == accuracy && student.getTime() > useTime)) {
			Student studentNew = new Student();
			studentNew.setId(id);
			studentNew.setPassword(student.getPassword());
			studentNew.setPhone(student.getPhone());
			studentNew.setAccuracy(accuracy);
			studentNew.setTime(useTime);
			// ɾ��������
			studentCrudRepository.delete(id);
			// �����µ�����
			studentCrudRepository.save(studentNew);
		}
	}

	/*
	 * ��ȡ����ǰ10��ѧ����Ϣ ���@Transcational��������һ������
	 */
	@Transactional
	public List<Student> getTop10() {
		// ������ȷ�ʽ�������
		Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "accuracy");
		// ����ȷ�ʽ������е�����£�����ʱ����������
		Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "time");
		Sort sort = new Sort(order1, order2);
		//��ҳ ȡ��һҳ������Ϊ10��
		Pageable pageable = new PageRequest(0, 10, sort);
		Page<Student> page = studentCrudRepository.findAll(pageable);
		List<Student> students = page.getContent();
		return students;
	}

	//����
	private String encoderPwd(String pwd) {
		return new BASE64Encoder().encode(pwd.getBytes());
	}

	//����
	private String decoderPwd(String pwd) throws IOException {
		return new String(new BASE64Decoder().decodeBuffer(pwd));
	}

}
