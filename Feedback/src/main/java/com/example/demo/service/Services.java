package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.Repo;

@Service
public class Services{
	@Autowired
	private Repo repo;

	public Feedback addfeed(Feedback f) {
		return repo.save(f);
	}

	public List<Feedback> getFeedback() {
		return repo.findAll();
	}

	public Feedback updateFeedback(Feedback f) {
		return repo.save(f);
	}

	public boolean deleteFeedback(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		else 
			return false;
	}
}
