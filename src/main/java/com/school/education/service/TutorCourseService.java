package com.school.education.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.entity.TutorCourse;
import com.school.education.repository.TutorCourseRepository;
@Service
public class TutorCourseService {
	
	@Autowired
	private TutorCourseRepository tutorCourseRepository;
	
	public TutorCourse createTutorCourse(TutorCourse tutorCourse) {
		tutorCourseRepository.save(tutorCourse);
		return this.tutorCourseRepository.findById(tutorCourse.getId()).orElseThrow();
	}
	public TutorCourse retriveTutorCourse(Long id) {
		return this.tutorCourseRepository.findById(id).orElseThrow();
	}
	public List<TutorCourse> retriveTutorCourseAll(){
		return this.tutorCourseRepository.findAll();
	}
	public Map<String,String> deleteTutorCourse(Long id){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<TutorCourse>requestMessage=tutorCourseRepository.findById(id);
		if(requestMessage.isPresent()) {
			tutorCourseRepository.deleteById(id);
			responceMessage.put("message", "Deleted Successfully");
		}
		else {
			responceMessage.put("message", " ID not Found");
			
		}
		return responceMessage;
	}
	public Map<String, String> updateTutorCourse(Long id,TutorCourse tutorCourseRequest){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<TutorCourse>requestMessage=tutorCourseRepository.findById(id);
		if(requestMessage.isEmpty()) {
			responceMessage.put("message", "ID not Found");
		}
		else {
			final TutorCourse tutorCourseResponse=requestMessage.get();
			if(tutorCourseRequest.getTutor()!=null) {
				tutorCourseResponse.setTutor(tutorCourseRequest.getTutor());
			}
			if(tutorCourseRequest.getCourse()!=null) {
				tutorCourseResponse.setCourse(tutorCourseRequest.getCourse());
			}
			tutorCourseRepository.save(tutorCourseResponse);
			responceMessage.put("message", "Updated Successfully");
		}
		return responceMessage;
				
	}
}
