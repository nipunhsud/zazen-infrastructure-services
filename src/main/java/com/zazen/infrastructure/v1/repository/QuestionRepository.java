 package com.zazen.infrastructure.v1.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zazen.infrastructure.v1.pojos.Question;

@Component
@Transactional
public class QuestionRepository {//extends HibernateDaoSupport implements  CrudRepository<Question, Long> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private EntityManager em;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    private Session getSession(){
    	return this.sessionFactory.getCurrentSession();
    }
    
    @Transactional
	public Question save(Question entity) {
		getSession().save(entity);
		return entity;
	}

	public <S extends Question> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Question findOne(String id) {

		Question question = getSession().get(Question.class, id);
		
		return question;
	}

	public boolean exists(Long id) {
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Question> findAll() {
		@SuppressWarnings("rawtypes")
		Query query = getSession().createQuery("FROM " + Question.class.getName());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Question> findAll(List<String> ids) {
		@SuppressWarnings("rawtypes")
		Query query = getSession().createQuery("FROM " + Question.class.getName()
				+ " where id IN (:ids)")
		.setParameterList("ids", ids);
		return query.list() ;
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
