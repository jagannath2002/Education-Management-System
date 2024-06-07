package com.school.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.education.DTO.TestRecordByStudentDTO;
import com.school.education.entity.TestRecord;
import com.school.education.service.TestRecordService;
@RestController
@RequestMapping("api/TestRecord")
public class TestRecordController {

	@Autowired
	private TestRecordService testRecordService;
	
	@PostMapping("/create")
	public TestRecord createAnswer(@RequestBody TestRecord testRecord) {
		return this.testRecordService.createTestRecord(testRecord);
	}
	@GetMapping("/")
	public TestRecord retriveAnswer(@RequestParam Long studentId,@RequestParam Long courseId) {
		//System.out.print("==========================="+studentId+"  "+courseId+"=======================");
		
		return this.testRecordService.retriveTestRecordByStudentIdAndCourseId(studentId,courseId);
	}
	@PutMapping("/update")
	public String CalculateTestRecordByMatchingAnswerAndQuestion() {
		return this.testRecordService.calculateTestRecordByMatchingAnswerAndQuestion();
	}
	@GetMapping("/{studentId}")
	public List<TestRecordByStudentDTO> TestRecordByStudentId(@PathVariable Long studentId) {
		return this.testRecordService.TestRecordByStudent(studentId);
	}
	
}
