package com.zazen.infrastructure.v1.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zazen.infrastructure.v1.pojos.Answer;
import com.zazen.infrastructure.v1.pojos.Question;


@Component
@Transactional
public class AnswerRepository extends BaseRepository {
	
	public AnswerRepository(){}
	
	@Transactional
	public Answer save(Answer entity) {
		Answer createdAnswer = (Answer) super.save(entity);
		return createdAnswer;
	}

	public <S extends Answer> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Answer findOne(String id) {
		return getSession().get(Answer.class, id);
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Answer> findAll() {
		Query query = getSession().createQuery(" FROM "+ Answer.class.getName());
		
		return query.list();
	}

	public List<Answer> findAll(List<String> ids) {
		Query query = getSession().createQuery(" FROM "+ Answer.class.getName() +" where id IN (:ids)")
				.setParameterList("ids", ids);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Answer> findAllByQuestion(String questionId) {
		@SuppressWarnings("rawtypes")
		Query query = getSession().createQuery("FROM " + Answer.class.getName()
				+ " where question_id IN (:questionId)")
		.setParameter("questionId", questionId);
		return query.list() ;
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
