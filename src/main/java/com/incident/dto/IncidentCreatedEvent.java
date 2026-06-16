package com.incident.dto;

public record IncidentCreatedEvent(
        Long incidentId,
        String title,
        String severity
) {
}