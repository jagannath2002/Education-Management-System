package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	List<Student> findAllBySchoolId(final long schoolId);
}
