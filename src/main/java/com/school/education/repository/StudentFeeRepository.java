package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.StudentFee;

@Repository
public interface StudentFeeRepository extends JpaRepository<StudentFee, Long> {

}
