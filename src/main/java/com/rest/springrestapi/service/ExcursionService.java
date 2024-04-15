package com.rest.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springrestapi.dao.ExcursionRepository;
import com.rest.springrestapi.entity.Excursion;

@Service
public class ExcursionService {
    
    @Autowired
    private ExcursionRepository excursionRepository;

    public List<Excursion> getExcursions(){
        return excursionRepository.findAll();
    }

    public Excursion getExcursionById(int id){
        return excursionRepository.findById(id).orElse(null);
    }

    public Excursion createExcursion(Excursion excursion) {
		return excursionRepository.save(excursion);
		
	}

    public Excursion updateExcursion(Excursion excursion){
        Excursion oldExcursion = null;
        Optional<Excursion> optionalExcursion=excursionRepository.findById(excursion.getId());
		if(optionalExcursion.isPresent()) {
			oldExcursion=optionalExcursion.get();
			oldExcursion.setTitle(excursion.getTitle());
			oldExcursion.setPlace(excursion.getPlace());
			oldExcursion.setNumberOfParticipants(excursion.getNumberOfParticipants());
		
			excursionRepository.save(oldExcursion);
		}else {
			return new Excursion();
		}
		return oldExcursion;
    }



}
