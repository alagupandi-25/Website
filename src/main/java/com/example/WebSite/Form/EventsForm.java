package com.example.WebSite.Form;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EventsForm {
	
	private String title;

	private String description;
	
	private String link;

	private String status;
	
    private MultipartFile[] files; 
	
	private LocalDateTime eventdate;
	
	private int totaldays;
	
	private Long phoneNumber;
	
	private String email;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public LocalDateTime getEventdate() {
		return eventdate;
	}

	public void setEventdate(LocalDateTime eventdate) {
		this.eventdate = eventdate;
	}

	public int getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(int totaldays) {
		this.totaldays = totaldays;
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
