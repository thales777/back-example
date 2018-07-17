package com.lti.facisa.RDM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.facisa.RDM.error.ResourceNotFoundException;
import com.lti.facisa.RDM.models.Professor;
import com.lti.facisa.RDM.services.ProfessorService;

@Controller
@RequestMapping("api/professor")
public class ProfessorController {
	
	@Autowired
	public ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<Professor>> getAll(){
		
		List<Professor> body = service.readProfessor();
		return new ResponseEntity<List<Professor>>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> getById(@PathVariable Long id){
		
		notEmpty(id);
		Professor professor = service.readById(id);
		return new ResponseEntity<Professor>(professor, HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<Professor> postProfessor(@RequestBody Professor Professor){
		
		Professor body = service.createProfessor(Professor);
		return new ResponseEntity<Professor>(body, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Professor> putProfessor(@PathVariable Long id,@RequestBody Professor Professor){
		
		notEmpty(id);
		Professor body = service.updateProfessor(id, Professor);
		return new ResponseEntity<Professor>(body, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProfessor(@PathVariable long id) {		
		
		notEmpty(id);
		service.deleteProfessor(id);
		return ResponseEntity.ok().build();
		
	}
	
    private void notEmpty(Long id){
        if (service.readById(id) == null)
            throw new ResourceNotFoundException("Professor de id " + id + " não encontrado");
    }

}
