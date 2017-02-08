package com.zazen.infrastructure.v1.repository;

import org.springframework.data.repository.CrudRepository;

import com.zazen.infrastructure.v1.pojos.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
