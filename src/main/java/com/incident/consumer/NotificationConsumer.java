package com.incident.consumer;

import com.incident.dto.IncidentCreatedEvent;
import com.incident.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

	private final EmailService emailService;

	public NotificationConsumer(EmailService emailService) {
		this.emailService = emailService;
	}

	@KafkaListener(
			topics = "incident-created",
			groupId = "notification-group"
	)
	public void consume(IncidentCreatedEvent event) {

		System.out.println("Received Event : "
		                   + event.incidentName());

		emailService.sendEmail(
				"bhilegaonkarsakshi@gmail.com",
				"New Incident Created",
				"Incident Created : "
				+ event.incidentName()
		);
	}
}