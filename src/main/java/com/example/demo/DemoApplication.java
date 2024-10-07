package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner clr(StudentDao studentdao) {
		return runner -> {
			createStudents(studentdao);
			readStudents(studentdao);
			getAllStudents(studentdao);
			//getByName(studentdao);
		};
		
	}
	
	/*private List<Student> getByName(StudentDao studentdao){
		List<Student> std = studentdao.getByName();
		System.out.println("By Name : " + std);
		return std;
	}*/

	private List<Student> getAllStudents(StudentDao studentdao){
		List<Student> st =  studentdao.getAllStudents();
		System.out.println("All students : " + st);
		return st;
	}
	
	
	private void createStudents(StudentDao studentdao) {
		/*Student st  = new Student("moad", "el otmani", "moad@gmail.com");
		Student st2 = new Student("mad", "el", "moad@gmail.com");
		Student st3 = new Student("mo", "otmani", "moad@gmail.com");
		studentdao.save(st);
		studentdao.save(st2);
		studentdao.save(st3);*/
		
		//System.out.println("student id : " + st.getId());
		
	}
	private void readStudents(StudentDao studentdao) {
		/*Student st  = new Student("moad", "el otmani", "moad@gmail.com");
		studentdao.save(st);
		
		Student std = studentdao.findById(st.getId());
		System.out.println("data : " + std);
	*/
	}
	

}
