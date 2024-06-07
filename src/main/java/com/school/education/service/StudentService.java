package com.school.education.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.entity.Student;
import com.school.education.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		studentRepository.save(student);
		return this.studentRepository.findById(student.getId()).orElseThrow();
	}
	public Student retriveStudent(Long id) {
		return this.studentRepository.findById(id).orElseThrow();
	}
	public List<Student> retriveStudentAll(){
		return this.studentRepository.findAll();
	}
	public Map<String,String> deleteStudent(Long id){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<Student>requestMessage=studentRepository.findById(id);
		if(requestMessage.isPresent()) {
			studentRepository.deleteById(id);
			responceMessage.put("message", "Deleted Successfully");
		}
		else {
			responceMessage.put("message", " ID not Found");
			
		}
		return responceMessage;
	}
	public Map<String, String> updateStudent(Long id,Student studentRequest){
		Map<String,String>responceMessage=new HashMap<>();
		Optional<Student>requestMessage=studentRepository.findById(id);
		if(requestMessage.isEmpty()) {
			responceMessage.put("message", "ID not Found");
		}
		else {
			final Student studentResponse=requestMessage.get();
			if(studentRequest.getName()!=null) {
				studentResponse.setName(studentRequest.getName());
			}
			if(studentRequest.getAge()!= 0) {
				studentResponse.setAge(studentRequest.getAge());
			}
			if(studentRequest.getAddress()!=null) {
				studentResponse.setAddress(studentRequest.getAddress());
			}
			if(studentRequest.getSchool()!=null) {
				studentResponse.setSchool(studentRequest.getSchool());
			}
			studentRepository.save(studentResponse);
			responceMessage.put("message", "Updated Successfully");
		}
		return responceMessage;		
	}
	public List<Student> RetriveStudentBySchoolId(Long id){
		List<Student> studentBySchoolId=new LinkedList<Student>();
		studentBySchoolId.addAll(studentRepository.findAllBySchoolId(id));
		return studentBySchoolId;
	}
	
}
