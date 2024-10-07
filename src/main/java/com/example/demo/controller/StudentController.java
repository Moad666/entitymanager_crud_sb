package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.studentDAOImp;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	studentDAOImp sdi;
	
	@PostMapping("/save")
	public void save(@RequestBody Student student) {
		sdi.save(student);
	}
	
	@GetMapping("/findById/{id}")
	public Student findById(@PathVariable int id) {
		return sdi.findById(id);
		//System.out.println("data : " + sdi.findById(id));
	}
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents(){
		return sdi.getAllStudents();
	}
	
	@GetMapping("/ByFirstName/{firstName}")
	public List<Student> getByName(@PathVariable String firstName){
		return sdi.getByName(firstName);
	}
	
	@GetMapping("/ByLastName/{lastName}")
	public List<Student> getByLastName(@PathVariable String lastName){
		return sdi.getByLastName(lastName);
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody Student student) {
		String firstName =  student.getFirstName();
		sdi.update(firstName, id);
	}
}
