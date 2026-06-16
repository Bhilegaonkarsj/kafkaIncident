package com.incident.repository;

import com.incident.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository
        extends JpaRepository<Incident, Long> {
}