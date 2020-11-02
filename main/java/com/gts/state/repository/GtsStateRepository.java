package com.gts.state.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gts.state.model.GtsState;


public interface GtsStateRepository extends JpaRepository<GtsState, Integer>,GtsStateDAO<GtsState, String> {


}
