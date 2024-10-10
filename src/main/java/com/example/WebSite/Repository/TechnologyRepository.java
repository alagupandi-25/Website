package com.example.WebSite.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebSite.Models.Technology;
import com.example.WebSite.Models.TechnologyType;

public interface TechnologyRepository extends JpaRepository<Technology,Long> {
	ArrayList<Technology> findByType(TechnologyType type);
}
