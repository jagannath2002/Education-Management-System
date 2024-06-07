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

import com.school.education.entity.TutorCourse;
import com.school.education.service.TutorCourseService;

@RestController
@RequestMapping("/api/tutorcourse")
public class TutorCourseController {
	
	@Autowired
	private TutorCourseService tutorCourseService;
	
	@PostMapping("/create")
	public TutorCourse createStudentCourse(@RequestBody TutorCourse tutorCourse) {
		return this.tutorCourseService.createTutorCourse(tutorCourse);
	}
	@GetMapping("/read/{id}")
	public TutorCourse retriveStudentCourse(@PathVariable Long id) {
		return this.tutorCourseService.retriveTutorCourse(id);
	}
	@GetMapping("/all")
	public List<TutorCourse> retriveStudentCourseAll() {
		return this.tutorCourseService.retriveTutorCourseAll();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteStudentCourse(@PathVariable Long id){
		return this.tutorCourseService.deleteTutorCourse(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateStudentCourse(@PathVariable Long id,@RequestBody TutorCourse tutorCourse) {
		return this.tutorCourseService.updateTutorCourse(id, tutorCourse);
	}

}
