 package com.zazen.infrastructure.v1.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.zazen.infrastructure.v1.pojos.Question;

@Component
public class QuestionRepository extends HibernateDaoSupport implements  CrudRepository<Question, Long> {
	
	private SessionFactory sessionFactory;
	
	public QuestionRepository(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}
	
	public <S extends Question> S save(S entity) {
		//sessionFactory.getCurrentSession().save(entity);
		super.getSessionFactory().openSession().save(entity);
		//getHibernateTemplate().save(entity);
		return entity;
	}

	public <S extends Question> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Question findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Question> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Question> findAll(Iterable<Long> ids) {
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

	public void delete(Question entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Question> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
