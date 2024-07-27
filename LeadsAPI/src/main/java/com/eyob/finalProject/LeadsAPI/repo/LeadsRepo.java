package com.eyob.finalProject.LeadsAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyob.finalProject.LeadsAPI.model.Leads;

@Repository
public interface LeadsRepo extends JpaRepository<Leads, Integer> {



}
