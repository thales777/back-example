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
import com.lti.facisa.RDM.models.Subject;
import com.lti.facisa.RDM.services.DisciplinaService;

@Controller
@RequestMapping("api/subject")
public class DisciplinaController {
	
	@Autowired
	public DisciplinaService service;
	
	@GetMapping
	public ResponseEntity<List<Subject>> getAll(){
		
		List<Subject> body = service.readDisciplina();
		return new ResponseEntity<List<Subject>>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subject> getById(@PathVariable Long id){
		
		notEmpty(id);
		Subject disciplina = service.readById(id);
		return new ResponseEntity<Subject>(disciplina, HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<Subject> postDisciplina(@RequestBody Subject Disciplina){
		
		Subject body = service.createDisciplina(Disciplina);
		return new ResponseEntity<Subject>(body, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Subject> putDisciplina(@PathVariable Long id,@RequestBody Subject Disciplina){
		
		notEmpty(id);
		Subject body = service.updateDisciplina(id, Disciplina);
		return new ResponseEntity<Subject>(body, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDisciplina(@PathVariable long id) {
		
		notEmpty(id);
		service.deleteDisciplina(id);			
		return ResponseEntity.ok().build();
		
	}
	
    private void notEmpty(Long id){
        if (service.readById(id) == null)
            throw new ResourceNotFoundException("Subject de id " + id + " não encontrado");
    }
}
