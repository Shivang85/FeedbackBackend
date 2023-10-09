package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Feedback;

public interface Repo extends JpaRepository<Feedback, Integer>{

}
