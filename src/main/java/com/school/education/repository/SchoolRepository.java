package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
