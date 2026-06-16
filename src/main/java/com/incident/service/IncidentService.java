package com.incident.service;

import com.incident.dto.CreateIncidentRequest;
import com.incident.dto.IncidentCreatedEvent;
import com.incident.entity.Incident;
import com.incident.producer.IncidentProducer;
import com.incident.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository repository;
    private final IncidentProducer producer;

    public Incident create(
            CreateIncidentRequest request
    ) {

        Incident incident =
                Incident.builder()
                        .title(request.title())
                        .description(request.description())
                        .severity(request.severity())
                        .status(request.status())
                        .build();

        Incident saved =
                repository.save(incident);

        producer.publish(
                new IncidentCreatedEvent(
                        saved.getId(),
                        saved.getTitle(),
                        saved.getSeverity()
                )
        );

        return saved;
    }

    public List<Incident> getAll() {
        return repository.findAll();
    }
}