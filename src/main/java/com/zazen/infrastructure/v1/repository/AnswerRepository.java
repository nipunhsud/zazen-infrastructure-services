package com.zazen.infrastructure.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.zazen.infrastructure.v1.pojos.Answer;

@Component
public abstract class AnswerRepository implements CrudRepository<Answer, Long>{

}
