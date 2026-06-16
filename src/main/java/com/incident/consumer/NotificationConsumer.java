package com.incident.consumer;

import com.incident.dto.IncidentCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "incident-created",
            groupId = "notification-group"
    )
    public void consume(
            IncidentCreatedEvent event
    ) {

        System.out.println(
                "Notification received -> "
                        + event.title()
        );
    }
}