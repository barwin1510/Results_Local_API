package com.project.Results.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Results.model.Details;
import com.project.Results.repository.DetailsRepository;

@RestController
public class ResultsController {
	
	@Autowired
	private DetailsRepository detailsRepository;
	
	@GetMapping()
	public List<Details> get(){
		return detailsRepository.findAll();
	}
	
	@PostMapping()
	public String post(@RequestBody Details d) {
		d.calculateTotalAndResult();
		detailsRepository.save(d);
		return "Posted Successfully";
	}
	
	@PutMapping("{id}")
	public String put(@PathVariable Long id, @RequestBody Details d) {
		Optional<Details> exist = detailsRepository.findById(id);
		if(exist.isPresent()) {
			Details update = exist.get();
			update.setName(d.getName());
			update.setRegisterNo(d.getRegisterNo());
			update.setEnglish(d.getEnglish());
			update.setTamil(d.getTamil());
			update.setMaths(d.getMaths());
			update.setScience(d.getScience());
			update.setSocial(d.getSocial());
			update.calculateTotalAndResult();
			detailsRepository.save(update);
			return "Updated Successfully";
		}
		return "Not Found";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		if(detailsRepository.existsById(id)) {
			detailsRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not Found";
	}
}
