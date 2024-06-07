package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.TutorSalary;
@Repository
public interface TutorSalaryRepository extends JpaRepository<TutorSalary, Long> {

}
