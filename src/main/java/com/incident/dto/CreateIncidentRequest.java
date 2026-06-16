package com.incident.dto;


public record CreateIncidentRequest(

        String title,

        String description,

        String severity,

        String status
) {
}