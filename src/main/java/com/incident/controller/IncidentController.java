package com.incident.controller;

import com.incident.dto.CreateIncidentRequest;
import com.incident.entity.Incident;
import com.incident.service.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService service;

    @PostMapping
    public Incident create(
            @RequestBody
            CreateIncidentRequest request
    ) {
        return service.create(request);
    }

    @GetMapping
    public List<Incident> getAll() {
        return service.getAll();
    }
}