package com.example.WebSite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebSite.Models.FileModel;

public interface FileRepository extends JpaRepository<FileModel, Long>{
	
}
