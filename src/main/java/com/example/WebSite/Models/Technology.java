package com.example.WebSite.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "Technology_Table")
public class Technology {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id; 
		
		@Column(nullable = false)
		private String name; 
		
		@Enumerated(EnumType.STRING)
		@Column(nullable = false)
		private TechnologyType type;
		
		@Column(columnDefinition = "TEXT")
		private String content;
		
		@Column(columnDefinition = "VARCHAR(100)")
		private String link;
		
		@CreatedDate
		@Column(updatable = false)
		private LocalDateTime createdate;
		
		@LastModifiedDate
		private LocalDateTime updatedate;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public TechnologyType getType() {
			return this.type;
		}

		public void setType(TechnologyType type) {
			this.type = type;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
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
