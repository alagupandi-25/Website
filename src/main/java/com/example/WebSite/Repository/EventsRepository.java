package com.example.WebSite.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebSite.Models.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {
	ArrayList<Events> findAll();
}
