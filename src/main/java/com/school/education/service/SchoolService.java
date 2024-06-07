package com.school.education.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.entity.School;
import com.school.education.repository.SchoolRepository;

@Service
public class SchoolService {
	@Autowired
	private SchoolRepository schoolRepository;
	
	public School createSchool(School school) {
		return this.schoolRepository.save(school);
		
	}
	public School retriveSchool(Long id) {
		return this.schoolRepository.findById(id).orElseThrow();
		
	}
	public List<School> retriveSchools() {
		return this.schoolRepository.findAll();
		
	}
	public Map<String,String> deleteSchool(Long id){
		schoolRepository.deleteById(id);
		Map<String,String> message=new HashMap<>();
		message.put("Message", "Successfully Deleted");
		return message;
	}
	public Map<String,String> updateSchool(Long id,School schoolRequest) {
		
		final Map<String,String> responseMap=new HashMap<>();
		final Optional<School>school=schoolRepository.findById(id);
		
		if(school.isEmpty()) responseMap.put("message", "Id not found");
		else {
			final School schoolResponse=school.get();
			if(schoolRequest.getName()!=null)
				schoolResponse.setName(schoolRequest.getName());
			if(schoolRequest.getAddress()!=null)
				schoolResponse.setAddress(schoolRequest.getAddress());
			this.schoolRepository.save(schoolResponse);
			responseMap.put("message", "Successfully updated");
		}

		return responseMap ;
	}
}
