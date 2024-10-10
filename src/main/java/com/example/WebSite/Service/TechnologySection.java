package com.example.WebSite.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebSite.Models.Technology;
import com.example.WebSite.Models.TechnologyType;
import com.example.WebSite.Repository.TechnologyRepository;

@Service
public class TechnologySection {
	
	public TechnologyRepository techRepository;

	@Autowired
	public TechnologySection(TechnologyRepository techRepository) {
		this.techRepository = techRepository;
	}
	
	public ArrayList<Technology> getPioneerTechnologies() throws Exception{
		return techRepository.findByType(TechnologyType.Pioneer);
	}
	
	public ArrayList<Technology> getSupportTechnologies() throws Exception{
		return techRepository.findByType(TechnologyType.Supporting);
	}
}
