 package com.zazen.infrastructure.v1.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zazen.infrastructure.v1.pojos.Question;

@Component
public class QuestionRepository {//extends HibernateDaoSupport implements  CrudRepository<Question, Long> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private EntityManager em;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    @Transactional
	public Question save(Question entity) {
		sessionFactory.getCurrentSession().save(entity);
    	//em.persist(entity);
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
