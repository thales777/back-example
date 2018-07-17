package com.lti.facisa.RDM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.facisa.RDM.models.Professor;
import com.lti.facisa.RDM.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public Professor createProfessor(Professor professor) {
		
		return this.repository.save(professor);
		
	}
	
	public Professor updateProfessor(long id,Professor professor) {
		
		professor.setId(id);
		return this.repository.save(professor);
		
	}
	
	public void deleteProfessor(Long id) {
		
		this.repository.delete(id);
		
	}
	
	public List<Professor> readProfessor(){
		
		return (List<Professor>) this.repository.findAll();
	
	}
	
	public Professor readById(long id) {
		
		return this.repository.findOne(id);
		
	}

}
