package com.school.education.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.DTO.QuestionDTO;
import com.school.education.entity.Question;
import com.school.education.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question CreateQuestion(Question question) {
		return this.questionRepository.save(question);
	}
	public Question RetriveQuestion(Long id) {
		return this.questionRepository.findById(id).orElseThrow();
	}
	public List<Question> RetriveQuestionAll() {
		return this.questionRepository.findAll();
	}
	public Map<String,String> DeleteQuestion(Long id){
		questionRepository.deleteById(id);
		Map<String,String> message=new HashMap<>();
		message.put("Message", "Successfully Deleted");
		return message; 
	}
	public Map<String, String> updateQuestion(Long id,Question questionRequest){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<Question>requestMessage=questionRepository.findById(id);
		if(requestMessage.isEmpty()) {
			responceMessage.put("message", "ID not Found");
		}
		else {
			final Question questionResponse=requestMessage.get();
			if(questionRequest.getQuestion()!=null) {
				questionResponse.setQuestion(questionRequest.getQuestion());
			}
			if(questionRequest.getOptionOne()!= null) {
				questionResponse.setOptionOne(questionRequest.getOptionOne());
			}
			if(questionRequest.getOptionTwo()!=null) {
				questionResponse.setOptionTwo(questionRequest.getOptionTwo());
			}
			if(questionRequest.getOptionThree()!=null) {
				questionResponse.setOptionThree(questionRequest.getOptionThree());
			}
			if(questionRequest.getCourse()!=null) {
				questionResponse.setCourse(questionRequest.getCourse());
			}
			if(questionRequest.getAnswer()!=null) {
				questionResponse.setAnswer(questionRequest.getAnswer());
			}
			questionRepository.save(questionResponse);
			responceMessage.put("message", "Updated Successfully");
		}
		return responceMessage;		
	}
	
	public List <QuestionDTO> testQuestion(Long CourseId){
		 List <QuestionDTO> displayQuestion=new LinkedList<>();
		List<Question> listofQuestion=questionRepository.findAllByCourseId(CourseId);
		Iterator<Question> singleQuestion=listofQuestion.iterator();
		while(singleQuestion.hasNext()) {
			Question questionObject=singleQuestion.next();
			QuestionDTO questionDTO=new QuestionDTO();
			questionDTO.setQuestion(questionObject.getQuestion());
			questionDTO.setOptionOne(questionObject.getOptionOne());
			questionDTO.setOptionTwo(questionObject.getOptionTwo());
			questionDTO.setOptionThree(questionObject.getOptionThree());
			displayQuestion.add(questionDTO);		
			}
		return displayQuestion;
	}
	
}
