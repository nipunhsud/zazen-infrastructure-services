 package com.zazen.infrastructure.v1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.zazen.infrastructure.v1.pojos.Question;

@Component
public abstract class QuestionRepository implements CrudRepository<Question, Long> {
	
}
