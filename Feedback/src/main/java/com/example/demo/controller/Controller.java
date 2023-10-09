package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmailDetails;
import com.example.demo.entity.Feedback;
import com.example.demo.service.EmailServiceImpl;
import com.example.demo.service.Services;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/feed")
public class Controller {
	
	@Autowired
	private Services fs;
	
	@Autowired 
	private EmailServiceImpl emailService;
	
	@PostMapping("/add")
	public Feedback addFeedback(@RequestBody Feedback f) {
		return fs.addfeed(f);
	}
	@GetMapping("/get")
	public List<Feedback> getFeed(){
		return fs.getFeedback();
	}
	@PutMapping("/update")
	public Feedback updateFeed(@RequestBody Feedback f) {
		return fs.updateFeedback(f);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFeed(@PathVariable int id) {
		if(fs.deleteFeedback(id))
			return ResponseEntity.ok("Deleted user with id: "+id);
		else 
			return ResponseEntity.notFound().build();
	}

	@PostMapping("/send")
	public String sendMail(@RequestBody EmailDetails details){
	    String status= emailService.sendSimpleMail(details);
	    return status;
	}
}

