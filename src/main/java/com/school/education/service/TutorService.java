package com.school.education.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.entity.Tutor;
import com.school.education.repository.TutorRepository;

@Service
public class TutorService {
	
	@Autowired
	private TutorRepository tutorRepository;
	
	public Tutor createTutor(Tutor tutor) {
		tutorRepository.save(tutor);
		return this.tutorRepository.findById(tutor.getId()).orElseThrow();
	}
	public Tutor retriveTutor(Long id) {
		return this.tutorRepository.findById(id).orElseThrow();
	}
	public List<Tutor> retriveTutorAll(){
		return this.tutorRepository.findAll();
	}
	public Map<String,String> deleteTutor(Long id){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<Tutor>requestMessage=tutorRepository.findById(id);
		if(requestMessage.isPresent()) {
			tutorRepository.deleteById(id);
			responceMessage.put("message", "Deleted Successfully");
		}
		else {
			responceMessage.put("message", " ID not Found");
			
		}
		return responceMessage;
	}
	public Map<String, String> updateTutor(Long id,Tutor TutorRequest){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<Tutor>requestMessage=tutorRepository.findById(id);
		if(requestMessage.isEmpty()) {
			responceMessage.put("message", "ID not Found");
		}
		else {
			final Tutor TutorResponse=requestMessage.get();
			if(TutorRequest.getName()!=null) {
				TutorResponse.setName(TutorRequest.getName());
			}
			if(TutorRequest.getAddress()!=null) {
				TutorResponse.setAddress(TutorRequest.getAddress());
			}
			if(TutorRequest.getSchool()!=null) {
				TutorResponse.setSchool(TutorRequest.getSchool());
			}
			tutorRepository.save(TutorResponse);
			responceMessage.put("message", "Updated Successfully");
		}
		return responceMessage;
				
	}

}
