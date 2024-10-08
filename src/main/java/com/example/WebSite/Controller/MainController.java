package com.example.WebSite.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.WebSite.Models.Services;
import com.example.WebSite.Service.ServiceSection;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/") 
public class MainController {
	
	@Autowired
	private ServiceSection serviceService;
	
	@GetMapping
	public String getIndex(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "index";
	}
	
	@GetMapping("about")
    public String about(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
        return "about"; 
    }

	@GetMapping("incubatore")
	public String incubatore(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "incubatore";
	}
	
	@GetMapping("services")
	public String services(HttpServletRequest request, Model model) {
		try {
			ArrayList<Services> services = (ArrayList<Services>) serviceService.getAllServices();
			model.addAttribute("request", request);
			model.addAllAttributes(services);
			System.out.println(services.size());
			return "services";
		}
		catch (Exception e) {
			return  "error ouccred";
		}
		
	}
	
	@GetMapping("technology")
	public String technology(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "technology";
	}
}