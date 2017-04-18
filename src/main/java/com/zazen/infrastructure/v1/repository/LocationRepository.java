package com.zazen.infrastructure.v1.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zazen.infrastructure.v1.controller.LocationController;
import com.zazen.infrastructure.v1.pojos.Location;

@Repository
@Transactional
public class LocationRepository extends BaseRepository {
	
	Logger logger= LoggerFactory.getLogger(LocationRepository.class);
	
	@Autowired
	Location location;
	
	public Location findOne(String id) {
		return getSession().get(Location.class, id);
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional
	public Location save(Location entity) {
		super.save(entity);
		//logger.debug("Location with id "+ persistedId + " saved." );
		return entity;
	}
	
	@Transactional
	public Location update(Location entity) {
		super.doUpdate(entity);
		//logger.debug("Location with id "+ persistedId + " saved." );
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
	
	public Location findByUserId(String userId){
		Query query = getSession().createQuery(" FROM "+ Location.class.getName()
				+ " where userId = :userId")
				.setParameter("userId", userId);
		return (Location) query.getSingleResult();
	}
	
}
