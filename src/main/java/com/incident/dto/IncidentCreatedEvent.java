package com.incident.dto;

import java.util.UUID;

public record IncidentCreatedEvent(
        Long incidentId,
        UUID uid,
        String incidentName
) {
}