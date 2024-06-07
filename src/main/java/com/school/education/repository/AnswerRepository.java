package com.school.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.education.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>  {

}
