package com.school.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.TestRecord;

@Repository
public interface TestRecordRepository extends JpaRepository<TestRecord, Long> {

//	List<TestRecord> findByStudentIdAndCourseId(Long studentId, Long courseId);
//	List<Integer> findMarkByStudentIdAndCourseId(Long studentId, Long courseId);

	List<TestRecord> findByStudentIdAndCourseId(Long studentId, Long courseId);

	List<TestRecord> findAllByStudentId(Long studentId);
	
	
}
