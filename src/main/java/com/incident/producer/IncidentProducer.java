package com.incident.producer;

import com.incident.dto.IncidentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncidentProducer
{

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void publish(IncidentCreatedEvent event)
	{
		kafkaTemplate.send("incident-created", event);
	}
}