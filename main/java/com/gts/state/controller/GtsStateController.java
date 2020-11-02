package com.gts.state.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gts.state.exception.ApplicationException;
import com.gts.state.exception.GtsStateNotFoundException;
import com.gts.state.model.GtsState;
import com.gts.state.service.GtsStateService;

@RestController
@RequestMapping(value="api/v1/state")
public class GtsStateController {
	
	@Autowired
	private GtsStateService gtsStateService;
	
	
	
	@GetMapping("/gts_states")
	public ResponseEntity<List<GtsState>> getAll() {
		return new ResponseEntity<>(gtsStateService.getAllGtsStates(),HttpStatus.OK);
	}
	
	@GetMapping("/{state_id}")
	public ResponseEntity<GtsState> searchByStateId(@RequestParam int stateId) {
		Optional<GtsState> gtsStateId= gtsStateService.findByStateId(stateId);
		if(!gtsStateId.isPresent()) {
			throw new GtsStateNotFoundException("Gts State Id not found ");
			}
		return new ResponseEntity<>(gtsStateId.get(), HttpStatus.OK);

	}
	
	@GetMapping("/state_name")
	public ResponseEntity<List<GtsState>> searchByStateName(@RequestParam String stateName) {
		
		List<GtsState> gtsStateName= gtsStateService.findByStateName(stateName);
		if(gtsStateName.isEmpty()) {
			throw new GtsStateNotFoundException("Gts State Name not found ");
			}
		
		return new ResponseEntity<>(gtsStateService.findByStateName(stateName), HttpStatus.OK);		
	}

	@PostMapping
	public ResponseEntity<String> addGtsStates(@RequestBody GtsState[] gtsStates) {
		
		String gtsStateObj=null;
		
		for(GtsState gtsState: gtsStates ) {
			
			if(gtsState.getGtsStateId() != null) {
				throw new ApplicationException("Gts State id found, ID is not required to add the data ");
			}
			
			if(gtsState.getGtsStateName() == "" || gtsState.getGtsStateName() == null ) {
				throw new ApplicationException("Gts State Name should not be empty ");
			}
			
			gtsStateObj=gtsStateService.addGtsState(gtsState);
			
		}
		
		return new ResponseEntity<>(gtsStateObj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<String> updateGtsStates(@RequestBody GtsState[] gtsStates){
		
		String gtsStateObj=null;
		
		for(GtsState gtsState: gtsStates ) {
			if(gtsState.getGtsStateId() == null) {
				throw new ApplicationException("Gts State id missing here!, ID is required for update the data ");
			
			} 
			
			Optional<GtsState> gtsStateId= gtsStateService.findByStateId(gtsState.getGtsStateId());
			
			if(!gtsStateId.isPresent()) {
				throw new GtsStateNotFoundException("Gts State Id not found you can't update data ");
			}
			
			
			if(gtsState.getGtsStateName() == "" || gtsState.getGtsStateName() == null ) {
				throw new ApplicationException("Gts State Name should not be empty ");
			
			}
		
			gtsStateObj=gtsStateService.updateGtsState(gtsState);
		
		}
		return new ResponseEntity<>(gtsStateObj,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/state_id")
	public ResponseEntity<String> deleteGtsState(@RequestParam int stateId){
		
		Optional<GtsState> gtsStateId= gtsStateService.findByStateId(stateId);
		
		if(!gtsStateId.isPresent()) {	
			throw new GtsStateNotFoundException("Gts State id not found");
		}
	
		return new ResponseEntity<>(gtsStateService.deleteGtsState(stateId),HttpStatus.OK);

	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllRecords(){
		
		return new ResponseEntity<>(gtsStateService.deleteAllGtsStates(),HttpStatus.OK);
		
	}

}
