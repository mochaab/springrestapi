package com.rest.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springrestapi.dao.ExcursionRepository;
import com.rest.springrestapi.entity.Excursion;
import com.rest.springrestapi.service.ExcursionService;

@RestController
public class ExcursionController {
    private final ExcursionRepository excursionRepository;

    @Autowired
    private ExcursionService excursionService;

    public ExcursionController(ExcursionRepository excursionRepository){
        this.excursionRepository = excursionRepository;
    }

    @GetMapping("/excursions")
    public List<Excursion> all(){
        return excursionService.getExcursions();
    }

    @PostMapping("/addExcursion")
	public Excursion addBooking(@RequestBody Excursion excursion) {
		return excursionService.createExcursion(excursion);
	}
}
