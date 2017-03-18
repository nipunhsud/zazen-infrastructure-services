package com.zazen.infrastructure.v1.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zazen.infrastructure.v1.pojos.Answer;
import com.zazen.infrastructure.v1.pojos.Location;
import com.zazen.infrastructure.v1.pojos.Question;

@Repository
@Transactional
public class LocationRepository {
	
	@Autowired
	Location location;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Location findOne(String id) {
		return getSession().get(Location.class, id);
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional
	public Location save(Location entity) {
		getSession().save(entity);
		return entity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Location> findAll() {
		Query query = getSession().createQuery(" FROM "+ Location.class.getName());
		
		return query.list();
	}

	public List<Location> findAll(List<String> ids) {
		Query query = getSession().createQuery(" FROM "+ Location.class.getName() +" where id IN (:ids)")
				.setParameterList("ids", ids);
		return query.list();
	}
	
}
