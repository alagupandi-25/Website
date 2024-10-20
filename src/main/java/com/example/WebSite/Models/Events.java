package com.example.WebSite.Models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "Events_Table")
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(columnDefinition = "VARCHAR(100)")
	private String link;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EventStatus status;
	
	@ManyToMany
	@JoinTable(
	    name = "Events_file",
	    joinColumns = @JoinColumn(name = "Event_id"),
	    inverseJoinColumns = @JoinColumn(name = "file_id")
	
	)
	private HashSet<FileModel> files;
	
	private LocalDateTime eventdate;
	
	private int totaldays;

	private String phoneNumber;
	
	
	private String email;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdate;
	
	@LastModifiedDate
	private LocalDateTime updatedate;

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

	public EventStatus getStatus() {
		return status;
	}

	public void setStatus(EventStatus status) {
		this.status = status;
	}
	
	public HashSet<FileModel> getFiles() {
		return files;
	}

	public void setFiles(HashSet<FileModel> files) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phonenumber) {
		this.phoneNumber = Long.toString(phonenumber);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}

	public LocalDateTime getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDateTime updatedate) {
		this.updatedate = updatedate;
	}

	public long getId() {
		return id;
	}
}
