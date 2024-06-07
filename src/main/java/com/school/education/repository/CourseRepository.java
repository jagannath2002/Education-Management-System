package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.education.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
