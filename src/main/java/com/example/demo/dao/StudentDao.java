package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDao {
	
	public void save(Student student);
	public Student findById(int id);
	public List<Student> getAllStudents();
	public List<Student> getByName(String firstName);
	public List<Student> getByLastName(String lastName);
	public void update(String firstName, int id);
	public void delete(int id);
	
}
