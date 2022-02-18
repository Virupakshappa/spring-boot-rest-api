package com.janadri.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janadri.demo.dao.AlienRepo;
import com.janadri.demo.model.Alien;

@RestController
public class AlienController {

@Autowired
AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return  "home.jsp";
	}
//adding the data through jpa	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "return.jsp";
		
	}
	@RequestMapping(path="/aliens", produces={"application/xml"})
	public List<Alien> getAliens() {
	
		return repo.findAll();
	}
	@RequestMapping(path="alien/{aid}", produces= {"application/json"})
	public Optional<Alien> getAlien(@PathVariable int aid) {
	
		return repo.findById(aid);
	}
//Adding the data through raw json(postman)
	@PostMapping(path="/alien", consumes={"application/json"})
	public Alien postAlien(@RequestBody Alien alien) {   //raw body(json) has to be passed through postman so we use @RequestBody
		repo.save(alien);
		return alien;
	}
	@DeleteMapping(path="/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien alien = repo.getById(aid);
		repo.delete(alien);
		return "deleted";
	}
	@PutMapping(path="/alien", consumes={"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}