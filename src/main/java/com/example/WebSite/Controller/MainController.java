package com.example.WebSite.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.WebSite.Models.Services;
import com.example.WebSite.Models.Technology;
import com.example.WebSite.Service.ServiceSection;
import com.example.WebSite.Service.TechnologySection;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/") 
public class MainController {
	
	@Autowired
	private ServiceSection serviceService;
	@Autowired
	private TechnologySection technologyService;
	
	@GetMapping
	public String getIndex(HttpServletRequest request, Model model) {
		try {
			ArrayList<Services> services = serviceService.getAllServices();
			ArrayList<Technology> pioneer = technologyService.getPioneerTechnologies();
			ArrayList<Technology> support = technologyService.getSupportTechnologies();
			model.addAttribute("services", services);
			model.addAttribute("pioneer", pioneer);
			model.addAttribute("support", support);
			model.addAttribute("request", request);
			return "index";
		}
		catch (Exception e) {
			return  "error occurred";
		}
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
			ArrayList<Services> services = serviceService.getAllServices();
			model.addAttribute("request", request);
			model.addAttribute("services", services);
			return "services";
		}
		catch (Exception e) {
			return  "error occurred";
		}
	}
	
	@GetMapping("technology")
	public String technology(HttpServletRequest request, Model model) {
		try {
			ArrayList<Technology> pioneer = technologyService.getPioneerTechnologies();
			ArrayList<Technology> support = technologyService.getSupportTechnologies();
			model.addAttribute("request", request);
			model.addAttribute("pioneer", pioneer);
			model.addAttribute("support", support);
			return "technology";
		}
		catch (Exception e) {
			return  "error occurred";
		}
	}
}