package com.gts.state.repository;

import java.util.List;

import com.gts.state.model.GtsState;

public interface GtsStateDAO<T, S> {
	
	List<GtsState> findByStateName(String stateName);

}
