package com.school.education.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.education.entity.Student;
import com.school.education.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return this.studentService.createStudent(student);
	}
	@GetMapping("/read/{id}")
	public Student retriveStudent(@PathVariable Long id) {
		return this.studentService.retriveStudent(id);
	}
	@GetMapping("/all")
	public List<Student> retriveStudent() {
		return this.studentService.retriveStudentAll();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteStudent(@PathVariable Long id){
		return this.studentService.deleteStudent(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateStudent(@PathVariable Long id,@RequestBody Student student) {
		return this.studentService.updateStudent(id, student);
	}
	
	
}
