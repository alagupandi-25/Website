package com.example.WebSite.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebSite.Form.EventsForm;
import com.example.WebSite.Models.EventStatus;
import com.example.WebSite.Models.Events;
import com.example.WebSite.Repository.EventsRepository;

@Service
public class EventsSection {
	
	@Autowired
	EventsRepository eventRepository;

	public void addEvents(EventsForm eventForm) {
	    Events event = new Events();
	    event.setTitle(eventForm.getTitle());
	    event.setDescription(eventForm.getDescription());
	    event.setStatus(EventStatus.Pendigng); 
	    event.setLink("www.website.com");
	    event.setEventdate(eventForm.getEventdate());
	    event.setTotaldays(eventForm.getTotaldays());
	    event.setPhoneNumber(eventForm.getPhoneNumber());
	    event.setEmail(eventForm.getEmail());
	    event.setFiles(null);
	    event.setCreatedate(LocalDateTime.now());
	    event.setUpdatedate(LocalDateTime.now());
	    eventRepository.save(event);
	}
	
	public ArrayList<Events> getAllEvents() throws Exception{
		try {
			return eventRepository.findAll();
		}
		catch (Exception e) {
			return null;
		}
	}

}
