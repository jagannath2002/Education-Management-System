package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
