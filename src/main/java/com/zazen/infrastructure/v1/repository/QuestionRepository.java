package com.zazen.infrastructure.v1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zazen.infrastructure.v1.pojos.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findByLatitude(long latitude);
}
