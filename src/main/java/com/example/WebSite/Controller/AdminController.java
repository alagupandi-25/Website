package com.example.WebSite.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.WebSite.Form.EventsForm;
import com.example.WebSite.Models.Services;
import com.example.WebSite.Models.Technology;
import com.example.WebSite.Service.EventsSection;
import com.example.WebSite.Service.ServiceSection;
import com.example.WebSite.Service.TechnologySection;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/") 
public class AdminController {
	
	@Autowired
	EventsSection eventsSection;
	@Autowired
	ServiceSection serviceSection;
	@Autowired
	TechnologySection technologySection;
	
	@GetMapping("events/form")
	public String eventAdd(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("request", request);
			model.addAttribute("Events", new EventsForm());
			return "EventAdmin";
		}
		catch (Exception e) {
			return "Error";
		}
	
	}

	@PostMapping("events/add")
	public String addEvent(@ModelAttribute EventsForm event, Model model,HttpServletRequest request)  {
			eventsSection.addEvents(event);
			model.addAttribute("request", request);
			for(MultipartFile ele : event.getFiles())
					System.out.println("---->"+ele.getOriginalFilename()+" : "+ele.getContentType());
			return "about"; 
	}
	
	@GetMapping("services")
	public String serviceList(HttpServletRequest request, Model model) {
		try {
			ArrayList<Services> services = serviceSection.getAllServices();
			model.addAttribute("request", request);
			model.addAttribute("services", services);
			return "ServiceList";
		}
		catch (Exception e) {
			return "Error";
		}
	}
	
	@GetMapping("technology")
	public String technologyList(HttpServletRequest request, Model model) {
		try {
			ArrayList<Technology> technologies = technologySection.getAllTechnologies();
			System.out.println(technologies.size());
			model.addAttribute("request", request);
			model.addAttribute("technologies", technologies);
			return "TechonogyList";
		}
		catch (Exception e) {
			return "Error";
		}
	}
	
}
