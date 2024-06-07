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

import com.school.education.entity.StudentCourse;
import com.school.education.service.StudentCourseService;

@RestController
@RequestMapping("/api/studentcourse")
public class StudentCourseController {
	@Autowired
	private StudentCourseService studentCourseService;
	
	@PostMapping("/create")
	public StudentCourse createStudentCourse(@RequestBody StudentCourse studentCourse) {
		return this.studentCourseService.createStudentCourse(studentCourse);
	}
	@GetMapping("/read/{id}")
	public StudentCourse retriveStudentCourse(@PathVariable Long id) {
		return this.studentCourseService.retriveStudentCourse(id);
	}
	@GetMapping("/all")
	public List<StudentCourse> retriveStudentCourseAll() {
		return this.studentCourseService.retriveStudentCourseAll();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteStudentCourse(@PathVariable Long id){
		return this.studentCourseService.deleteStudentCourse(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateStudentCourse(@PathVariable Long id,@RequestBody StudentCourse studentCourse) {
		return this.studentCourseService.updateStudentCourse(id, studentCourse);
	}
}
