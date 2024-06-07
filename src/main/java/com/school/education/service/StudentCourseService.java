package com.school.education.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.entity.StudentCourse;
import com.school.education.repository.StudentCourseRepository;

@Service
public class StudentCourseService {
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;
	
	public StudentCourse createStudentCourse(StudentCourse studentCourse) {
		studentCourseRepository.save(studentCourse);
		return this.studentCourseRepository.findById(studentCourse.getId()).orElseThrow();
	}
	public StudentCourse retriveStudentCourse(Long id) {
		return this.studentCourseRepository.findById(id).orElseThrow();
	}
	public List<StudentCourse> retriveStudentCourseAll(){
		return this.studentCourseRepository.findAll();
	}
	public Map<String,String> deleteStudentCourse(Long id){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<StudentCourse>requestMessage=studentCourseRepository.findById(id);
		if(requestMessage.isPresent()) {
			studentCourseRepository.deleteById(id);
			responceMessage.put("message", "Deleted Successfully");
		}
		else {
			responceMessage.put("message", " ID not Found");
			
		}
		return responceMessage;
	}
	public Map<String, String> updateStudentCourse(Long id,StudentCourse studentCourseRequest){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<StudentCourse>requestMessage=studentCourseRepository.findById(id);
		if(requestMessage.isEmpty()) {
			responceMessage.put("message", "ID not Found");
		}
		else {
			final StudentCourse studentCouresResponse=requestMessage.get();
			if(studentCourseRequest.getStudent()!=null) {
				studentCouresResponse.setStudent(studentCourseRequest.getStudent());
			}
			if(studentCourseRequest.getCourse()!=null) {
				studentCouresResponse.setCourse(studentCourseRequest.getCourse());
			}
			studentCourseRepository.save(studentCouresResponse);
			responceMessage.put("message", "Updated Successfully");
		}
		return responceMessage;
				
	}
	
}
