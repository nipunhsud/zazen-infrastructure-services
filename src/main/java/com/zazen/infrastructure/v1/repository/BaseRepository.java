package com.zazen.infrastructure.v1.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zazen.infrastructure.v1.controller.QuestionController;

public class BaseRepository {
	
	Logger logger= LoggerFactory.getLogger(BaseRepository.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    protected Session getSession(){
    	return this.sessionFactory.getCurrentSession();
    }
    
    public <T extends TimeStampedEntity> TimeStampedEntity save(TimeStampedEntity timeStampedEntity){
		timeStampedEntity = this.addTimeStamps(timeStampedEntity);
		String persistedId = (String) getSession().save(timeStampedEntity);
		logger.debug("Saved Entity with id "+ persistedId);
		return timeStampedEntity;
	}
    
    public TimeStampedEntity doUpdate(TimeStampedEntity timeStampedEntity){
    	timeStampedEntity = this.addTimeStamps(timeStampedEntity);
    	getSession().update(timeStampedEntity);
    	return timeStampedEntity;
    }
	
	private TimeStampedEntity addTimeStamps(TimeStampedEntity timeStampedEntity){
		timeStampedEntity.setCreateTime();
		timeStampedEntity.setLastModified();
		return timeStampedEntity;
	}
	
}
