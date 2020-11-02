package com.gts.state.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gts.state.model.GtsState;
import com.gts.state.repository.GtsStateRepository;

@Service
public class GtsStateServiceImpl implements GtsStateService{

	@Autowired
	private GtsStateRepository gtsStateRepository;	

	@Override
	public List<GtsState> getAllGtsStates() {
		List<GtsState> gtsStates = new ArrayList<>();
		gtsStateRepository.findAll().forEach(gtsStates::add);
		return gtsStates;
	}

	@Override
	public Optional<GtsState> findByStateId(int id) {
		return gtsStateRepository.findById(id);
	}
	
	@Override
	public List<GtsState> findByStateName(String stateName) {
        
		return gtsStateRepository.findByStateName(stateName);

	}

	@Override
	public String addGtsState(GtsState gtsState) {

		JSONObject jsonObject = new JSONObject();
		try {
			gtsStateRepository.save(gtsState);
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Gts State(s) created successfully");
			jsonObject.put("status_code", HttpStatus.CREATED.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();

	}

	@Override
	public String updateGtsState(GtsState gtsState) {

		JSONObject jsonObject = new JSONObject();
		try {
			gtsStateRepository.save(gtsState);
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Gts State(s) updated successfully");
			jsonObject.put("status_code", HttpStatus.OK.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public String deleteGtsState(int id) {

		JSONObject jsonObject = new JSONObject();
		try {
			gtsStateRepository.deleteById(id);
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Gts State deleted successfully");
			jsonObject.put("status_code", HttpStatus.OK.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public String deleteAllGtsStates() {
		
		JSONObject jsonObject = new JSONObject();
		try {
			gtsStateRepository.deleteAll();
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Gts States deleted successfully");
			jsonObject.put("status_code", HttpStatus.OK.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

	
}
