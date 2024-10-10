package com.example.WebSite.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebSite.Models.Services;

public interface ServiceRepository extends JpaRepository<Services, Long>{
	ArrayList<Services> findAll();
}
