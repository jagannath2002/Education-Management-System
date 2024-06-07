package com.school.education.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.education.DTO.TestRecordByStudentDTO;
import com.school.education.entity.Answer;
import com.school.education.entity.Question;
import com.school.education.entity.TestRecord;
import com.school.education.repository.AnswerRepository;
import com.school.education.repository.QuestionRepository;
import com.school.education.repository.StudentRepository;
import com.school.education.repository.TestRecordRepository;
@Service
public class TestRecordService {
	
	@Autowired
    private TestRecordRepository testRecordRepository;
	
	public TestRecord createTestRecord(TestRecord TestRecord) {
		testRecordRepository.save(TestRecord);
		return this.testRecordRepository.findById(TestRecord.getId()).orElseThrow();
	}
	
	public TestRecord retriveTestRecordByStudentIdAndCourseId(Long studentId, Long courseId) {
		try {
			return this.testRecordRepository.findByStudentIdAndCourseId(studentId,courseId).stream().findFirst().orElseThrow(()-> new BadRequestException("Not found"));
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	
	public String calculateTestRecordByMatchingAnswerAndQuestion() {
        List<Answer> answerTable = answerRepository.findAll();
        Map<Long, Question> questionMap = questionRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Question::getId, q -> q));
        
        final List<TestRecord> testRecordList = new LinkedList();
        for (Answer answer : answerTable) {
            Question correspondingQuestion = questionMap.get(answer.getQuestion().getId());
            if (correspondingQuestion != null && answer.getAnswer().equals(correspondingQuestion.getAnswer())) {
                TestRecord studentRecord = retriveTestRecordByStudentIdAndCourseId(answer.getStudent().getId(), answer.getCourse().getId());

                if (studentRecord != null) {
                    studentRecord.setMark(studentRecord.getMark() + 1);
                    testRecordList.add(studentRecord);
                } else {
                    TestRecord newStudentRecord = new TestRecord();
                    newStudentRecord.setMark(1);
                    newStudentRecord.setStudent(answer.getStudent());
                    newStudentRecord.setCourse(answer.getCourse());
                    testRecordList.add(studentRecord);
                }     
            }
            this.testRecordRepository.saveAll(testRecordList);
        }  
        return "Record Updated";
    }
	public List<TestRecordByStudentDTO> TestRecordByStudent(Long studentId){
		
		List<TestRecord>StudentByAllCourse=testRecordRepository.findAllByStudentId(studentId);
		List<TestRecordByStudentDTO>displayRecord=new LinkedList<>();
		
		for(int i=0;i<StudentByAllCourse.size();i++) {
			TestRecord studentSingleCourse=StudentByAllCourse.get(i);
			TestRecordByStudentDTO studentSingleCourseDTO=new TestRecordByStudentDTO();
			studentSingleCourseDTO.setId(studentSingleCourse.getId());
			studentSingleCourseDTO.setSchoolName(studentSingleCourse.getStudent().getSchool().getName());
			studentSingleCourseDTO.setStudentId(studentSingleCourse.getStudent().getId());
			studentSingleCourseDTO.setCourseName(studentSingleCourse.getCourse().getName());
			studentSingleCourseDTO.setStudentName(studentSingleCourse.getStudent().getName());
			studentSingleCourseDTO.setMark(studentSingleCourse.getMark());
			displayRecord.add(studentSingleCourseDTO);
		}
		return displayRecord;
	}
	
	
}
