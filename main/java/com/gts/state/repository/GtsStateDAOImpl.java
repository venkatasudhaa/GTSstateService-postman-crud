package com.gts.state.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gts.state.model.GtsState;

@Repository
@Transactional
public class GtsStateDAOImpl implements GtsStateDAO<GtsState, String> {

	@Autowired
	 EntityManager entityManager;
	    
	@Override
	public List<GtsState> findByStateName(String stateName) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<GtsState> query=currentSession.createQuery("FROM GtsState where gts_state_name = :stateName",GtsState.class);
		
		query.setParameter("stateName", stateName);
		
		return query.getResultList();
		
	}
}


