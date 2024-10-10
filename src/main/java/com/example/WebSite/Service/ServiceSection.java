package com.example.WebSite.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebSite.Models.Services;
import com.example.WebSite.Repository.ServiceRepository;

@Service
public class ServiceSection {
	
	private ServiceRepository servicesRepo;
	
	@Autowired
	public ServiceSection(ServiceRepository servicesRepo) {
		this.servicesRepo =  servicesRepo;
	}
	
	public ArrayList<Services> getAllServices() throws Exception{
		return servicesRepo.findAll();
	}
	
	
}
