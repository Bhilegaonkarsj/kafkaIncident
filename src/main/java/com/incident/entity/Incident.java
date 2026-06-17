package com.incident.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "incident")
public class Incident {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uid;

	private String incidentName;

	public Incident() {
	}

	public Long getId() {
		return id;
	}

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	public String getIncidentName() {
		return incidentName;
	}

	public void setIncidentName(String incidentName) {
		this.incidentName = incidentName;
	}

	@PrePersist
	public void generateUid() {
		if (uid == null) {
			uid = UUID.randomUUID();
		}
	}
}