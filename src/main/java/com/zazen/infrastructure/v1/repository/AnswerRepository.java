package com.zazen.infrastructure.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zazen.infrastructure.v1.pojos.Answer;

@Repository
public class AnswerRepository implements CrudRepository<Answer, Long>{
	
	public AnswerRepository(){}

	public <S extends Answer> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Answer> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Answer findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Answer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Answer> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Answer entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Answer> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
