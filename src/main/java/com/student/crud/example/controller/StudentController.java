package com.student.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.crud.example.entity.Student;
import com.student.crud.example.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);

	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return service.getStudents();

	}
	  @CrossOrigin(origins="http://localhost:4200")  
	  @GetMapping("/studentById/{id}") public Student findStudentById(@PathVariable int id) {
		  return service.getStudentById(id);
	  
	  }
	 
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/Student/{name}")	
	public Student findStudentByName(@PathVariable String name) {
		return service.getStudentByName(name);	

	}

	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);

	}
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);

	}
}
