package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.education.entity.TutorCourse;

public interface TutorCourseRepository extends JpaRepository<TutorCourse, Long> {
	
}
