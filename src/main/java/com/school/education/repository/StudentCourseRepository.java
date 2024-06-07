package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.education.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

	
}
