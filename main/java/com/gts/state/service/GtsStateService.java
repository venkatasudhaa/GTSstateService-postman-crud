package com.gts.state.service;

import java.util.List;
import java.util.Optional;

import com.gts.state.model.GtsState;

public interface GtsStateService {
	
	List<GtsState> getAllGtsStates();
	Optional<GtsState> findByStateId(int id);
	List<GtsState> findByStateName(String stateName);
	
	String addGtsState(GtsState gtsState);
	String updateGtsState(GtsState gtsState);
	
	String deleteGtsState(int id);
	String deleteAllGtsStates();
	

}
