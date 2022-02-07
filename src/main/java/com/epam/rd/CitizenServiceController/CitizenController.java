package com.epam.rd.CitizenServiceController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.rd.CitizenServiceEntity.Citizen;
import com.epam.rd.CitizenServiceRepository.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	CitizenRepository repo;
	
	@GetMapping("/citizens")
	public ResponseEntity<List<Citizen>> getAllCitizens(){
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(path="/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
		List<Citizen> listCitizen = repo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
	
	@PostMapping(path="/addCitizen")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
		return new ResponseEntity<>(repo.save(citizen), HttpStatus.OK);
		
	}

	/*@RequestMapping(path="/id/{id}")
	public ResponseEntity<Citizen> getCitizenById(@PathVariable Integer id){
		Optional<Citizen> citizen = repo.findById(id);
		return new ResponseEntity<>(citizen, HttpStatus.OK);
	}*/

}
