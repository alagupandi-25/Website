package com.example.WebSite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebSite.Models.Services;
import com.example.WebSite.Repository.ServiceRepository;

@Service
public class ServiceSection {
	
	@Autowired
	ServiceRepository servicesRepo;
	
	public List<Services> getAllServices() throws Exception{
		return servicesRepo.findAll();
	}
}
