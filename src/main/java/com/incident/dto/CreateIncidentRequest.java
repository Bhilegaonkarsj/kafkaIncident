package com.incident.dto;


public record CreateIncidentRequest(

        String incidentName,

        String description,

        String severity,

        String status
) {
}