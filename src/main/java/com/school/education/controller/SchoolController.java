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

import com.school.education.entity.School;
import com.school.education.service.SchoolService;

@RestController
@RequestMapping("api/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/create")
	public School createSchool(@RequestBody School school) {
		return this.schoolService.createSchool(school);
	}
	@GetMapping("/read/{id}")
	public School retriveSchool(@PathVariable Long id) {
		return this.schoolService.retriveSchool(id);
	}
	@GetMapping("/all")
	public List<School> retriveSchools() {
		return this.schoolService.retriveSchools();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteSchool(@PathVariable Long id){
		return this.schoolService.deleteSchool(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateSchool(@PathVariable Long id,@RequestBody School school) {
		return this.schoolService.updateSchool(id, school);
	}
	
}
