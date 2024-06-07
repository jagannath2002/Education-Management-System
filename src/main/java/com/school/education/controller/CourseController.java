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

import com.school.education.entity.Course;
import com.school.education.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/create")
	public Course createStudent(@RequestBody Course course) {
		return this.courseService.createCourse(course);
	}
	@GetMapping("/read/{id}")
	public Course retriveStudent(@PathVariable Long id) {
		return this.courseService.retriveCourse(id);
	}
	@GetMapping("/all")
	public List<Course> retriveStudent() {
		return this.courseService.retriveCourseAll();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteCourse(@PathVariable Long id){
		return this.courseService.deleteCourse(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateCourse(@PathVariable Long id,@RequestBody Course course) {
		return this.courseService.updateCourse(id, course);
	}
	

}
