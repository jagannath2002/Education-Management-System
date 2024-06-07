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

import com.school.education.DTO.QuestionDTO;
import com.school.education.entity.Question;
import com.school.education.service.QuestionService;

@RestController
@RequestMapping("api/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/create")
	public Question createSchool(@RequestBody Question question) {
		return this.questionService.CreateQuestion(question);
	}
	@GetMapping("/read/{id}")
	public Question retriveSchool(@PathVariable Long id) {
		return this.questionService.RetriveQuestion(id);
	}
	@GetMapping("/all")
	public List<Question> retriveSchools() {
		return this.questionService.RetriveQuestionAll();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> deleteSchool(@PathVariable Long id){
		return this.questionService.DeleteQuestion(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,String> updateSchool(@PathVariable Long id,@RequestBody Question question) {
		return this.questionService.updateQuestion(id, question);
	}
	@PutMapping("/testquestion/{id}")
	public List<QuestionDTO> testQuestion(@PathVariable Long id){
		return this.questionService.testQuestion(id);
	}
	

}
