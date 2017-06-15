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
 * StudentService业务类
 * 为用户模块提供服务
 * 添加@Service注解表明这个类是业务类
 * */
@Service
public class StudentService {

	/*
	 * 添加@Autowired 
	 * 注入数据访问类StudentCrudRepository
	 */
	@Autowired
	private StudentCrudRepository studentCrudRepository;

	/*
	 * 学生注册 传入姓名、学号、电话号码、密码 
	 * 已经注册过的学号不能被再次使用 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public boolean register(Integer id, String name, String password, String phone) {
		if (studentCrudRepository.exists(id))
			return false;

		int year = 18;
		// 验证学号是否符合规范
		if ((4 * 100 + year - 4) * 10000 > id
				|| (id > (4 * 100 + year) * 10000 && (4 * 100 + year - 2) * 1000000000 > id)
				|| id > (4 * 100 + year) * 1000000000) {
			System.out.println("id valid");
			return false;
		}
		// 验证字符信息是否为空
		if (name == null || phone == null || password == null) {
			System.out.println("information missing");
			return false;
		}

		// 根据用户输入信息创建一个相应的实体
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPhone(phone);
		student.setPassword(encoderPwd(password)); // 对密码进行加密
		student.setAccuracy(0.0);
		student.setTime(301);
		// 调用数据访问类，向数据库中添加新的学生信息
		studentCrudRepository.save(student);
		return true;
	}

	/*
	 * 登录 传入学号密码 返回登录是否成功 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public boolean login(Integer id, String password) throws IOException {
		// 找到该id的学生信息
		Student student = studentCrudRepository.findOne(id);
		// 验证密码是否一致
		if (!decoderPwd(student.getPassword()).equals(password)) // 验证前对密码进行解密
			return false;
		return true;
	}

	/*
	 * 密码找回 输入学号、姓名、电话号码 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public boolean findPassword(Integer id, String name, String phone) {
		// 找到该id的学生信息
		Student student = studentCrudRepository.findOne(id);
		// 验证该生除密码外的其他信息
		if (!student.getName().equals(name) || !student.getPhone().equals(phone))
			return false;
		// 在数据库中删去该生的信息
		studentCrudRepository.delete(id);
		return true;
	}

	/*
	 * 更新学生的最佳答题成绩 传入学生的学号、答题正确率、答题用时 
	 * 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public void updateBestGrade(Integer id, double accuracy, int useTime) {
		// 找到该id的学生信息
		Student student = studentCrudRepository.findOne(id);
		// 判断是否需要更新成绩
		if (student.getAccuracy() < accuracy || (student.getAccuracy() == accuracy && student.getTime() > useTime)) {
			Student studentNew = new Student();
			studentNew.setId(id);
			studentNew.setPassword(student.getPassword());
			studentNew.setPhone(student.getPhone());
			studentNew.setAccuracy(accuracy);
			studentNew.setTime(useTime);
			// 删除旧数据
			studentCrudRepository.delete(id);
			// 插入新的数据
			studentCrudRepository.save(studentNew);
		}
	}

	/*
	 * 获取排名前10的学生信息 添加@Transcational表明这是一个事务
	 */
	@Transactional
	public List<Student> getTop10() {
		// 按照正确率降序排列
		Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "accuracy");
		// 在正确率降序排列的情况下，答题时间升序排列
		Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "time");
		Sort sort = new Sort(order1, order2);
		//分页 取第一页，数据为10条
		Pageable pageable = new PageRequest(0, 10, sort);
		Page<Student> page = studentCrudRepository.findAll(pageable);
		List<Student> students = page.getContent();
		return students;
	}

	//加密
	private String encoderPwd(String pwd) {
		return new BASE64Encoder().encode(pwd.getBytes());
	}

	//解密
	private String decoderPwd(String pwd) throws IOException {
		return new String(new BASE64Decoder().decodeBuffer(pwd));
	}

}
