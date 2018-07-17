package com.lti.facisa.RDM.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Student {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column()
	private String name;
	
	@Column()
	private String registration;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Subject> subject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String subject) {
		this.registration = subject;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subjects) {
		this.subject = subjects;
	}
	

	
	
	
}
