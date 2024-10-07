package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class studentDAOImp implements StudentDao{
	
	private EntityManager entitymanager;
	private StudentDao stdDao;

	@Autowired
	public studentDAOImp(EntityManager em) {
		this.entitymanager=em;
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		entitymanager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entitymanager.find(Student.class, id);
	}
	
	@Override
	public List<Student>  getAllStudents(){
		TypedQuery<Student> query = entitymanager.createQuery("From Student",Student.class);
		List<Student> students = query.getResultList();
		return students;
	} 

	@Override
	public List<Student> getByName(String firstName) {
		//entitymanager.find(Student.class, firstName);
		TypedQuery<Student> query = entitymanager.createQuery("From Student where firstName = :firstName", Student.class);
		query.setParameter("firstName", firstName);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> getByLastName(String lastName) {
		TypedQuery query = entitymanager.createQuery("From Student where lastName = :lastName", Student.class);
		query.setParameter("lastName", lastName);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public void update(String firstName, int id) {
		/*Student std = entitymanager.find(Student.class, 1);
		std.setFirstName("saad");
		entitymanager.merge(std);*/
		Query query = entitymanager.createQuery("UPDATE Student set firstName = :firstName WHERE id= :id");
		query.setParameter("id", id);
		query.setParameter("firstName", firstName);
		int rowsUpdated = query.executeUpdate();
	}
	
	
	



}
