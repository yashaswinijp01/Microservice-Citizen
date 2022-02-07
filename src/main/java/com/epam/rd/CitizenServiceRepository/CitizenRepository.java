package com.epam.rd.CitizenServiceRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.rd.CitizenServiceEntity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCenterId(Integer id);

}
