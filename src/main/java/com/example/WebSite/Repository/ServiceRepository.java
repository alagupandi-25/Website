package com.example.WebSite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebSite.Models.Services;

public interface ServiceRepository extends JpaRepository<Services, Long>{
	List<Services> findAll();
}
