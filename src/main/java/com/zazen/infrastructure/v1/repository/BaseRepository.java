package com.zazen.infrastructure.v1.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    protected Session getSession(){
    	return this.sessionFactory.getCurrentSession();
    }
}
