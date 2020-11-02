package com.gts.state.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="gts_states")
public class GtsState {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="gts_state_id")
	@JsonProperty("gtsStateId")
	private Integer gtsStateId;
	
	@Column(name="gts_state_name")
	@JsonProperty("gtsStateName")
	private String gtsStateName;
	
	@Column(name="gts_state_description")
	@JsonProperty("gtsStateDescription")
	private String gtsStateDescription;
	
	@Column(name="gts_state_status" )
	@JsonProperty("gtsStateStatus")
	private boolean gtsStateStatus;
	
	public GtsState() {
		
	}

	public GtsState(int gtsStateId, String gtsStateName, String gtsStateDescription, boolean gtsStateStatus) {
		super();
		this.gtsStateId = gtsStateId;
		this.gtsStateName = gtsStateName;
		this.gtsStateDescription = gtsStateDescription;
		this.gtsStateStatus = gtsStateStatus;
	}

	public Integer getGtsStateId() {
		return gtsStateId;
	}

	public void setGtsStateId(Integer gtsStateId) {
		this.gtsStateId = gtsStateId;
	}

	public String getGtsStateName() {
		return gtsStateName;
	}

	public void setGtsStateName(String gtsStateName) {
		this.gtsStateName = gtsStateName;
	}

	public String getGtsStateDescription() {
		return gtsStateDescription;
	}

	public void setGtsStateDescription(String gtsStateDescription) {
		this.gtsStateDescription = gtsStateDescription;
	}

	public boolean isGtsStateStatus() {
		return gtsStateStatus;
	}

	public void setGtsStateStatus(boolean gtsStateStatus) {
		this.gtsStateStatus = gtsStateStatus;
	}
		
}
