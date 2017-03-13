package com.zazen.infrastructure.v1.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zazen.infrastructure.v1.pojos.Answer;

@Repository
public class AnswerRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public AnswerRepository(){}

	public Answer save(Answer entity) {
		getSession().save(entity);
		
		return entity;
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
