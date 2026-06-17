package com.incident.producer;

import com.incident.dto.IncidentCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class IncidentProducer {

	private final KafkaTemplate<String, IncidentCreatedEvent> kafkaTemplate;

	public IncidentProducer(
			KafkaTemplate<String, IncidentCreatedEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void publish(IncidentCreatedEvent event) {

		System.out.println("Publishing Event : "
		                   + event.incidentName());

		kafkaTemplate.send(
				"incident-created",
				event
		);
	}
}