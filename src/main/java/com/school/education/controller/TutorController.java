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

import com.school.education.entity.Tutor;
import com.school.education.service.TutorService;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {
	@Autowired
	private TutorService tutorService;
	@PostMapping("/create")
	public Tutor createStudent(@RequestBody Tutor tutor) {
		return this.tutorService.createTutor(tutor);
	}
	@GetMapping("/read/{id}")
	public Tutor retriveStudent(@PathVariable Long id) {
		return this.tutorService.retriveTutor(id);
	}
	@GetMapping("/all")
	public List<Tutor> retriveStudent() {
		return this.tutorService.retriveTutorAll();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteTutor(@PathVariable Long id){
		return this.tutorService.deleteTutor(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateStudent(@PathVariable Long id,@RequestBody Tutor tutor) {
		return this.tutorService.updateTutor(id, tutor);
	}
	

}
