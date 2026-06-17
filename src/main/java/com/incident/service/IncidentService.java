package com.incident.service;

import com.incident.dto.CreateIncidentRequest;
import com.incident.dto.IncidentCreatedEvent;
import com.incident.entity.Incident;
import com.incident.producer.IncidentProducer;
import com.incident.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IncidentService {

	private final IncidentRepository repository;
	private final IncidentProducer producer;

	public IncidentService(
			final IncidentRepository repository,
			final IncidentProducer producer) {
		this.repository = repository;
		this.producer = producer;
	}

	public Incident create(final CreateIncidentRequest request) {

		Incident incident = new Incident();
		incident.setUid(UUID.randomUUID());
		incident.setIncidentName(request.incidentName());

		Incident saved = repository.save(incident);

		producer.publish(
				new IncidentCreatedEvent(
						saved.getId(),
						saved.getUid(),
						saved.getIncidentName()
				)
		);

		return saved;
	}

	public List<Incident> getAll() {
		return repository.findAll();
	}
}