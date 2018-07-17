package com.lti.facisa.RDM.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.lti.facisa.RDM.models.Curso;
import com.lti.facisa.RDM.services.CursoService;

@Controller
@RequestMapping("api/curso")
public class CursoController {
	
	@Autowired
	public CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getAll(){
		
		List<Curso> body = service.readCurso();
		return new ResponseEntity<List<Curso>>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> getById(@PathVariable Long id){
		
		notEmpty(id);
		Curso curso = service.readById(id);
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<Curso> postCurso(@Valid @RequestBody Curso Curso){
		
		Curso body = service.createCurso(Curso);
		return new ResponseEntity<Curso>(body, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> putCurso(@PathVariable Long id,@RequestBody Curso Curso){
		
		notEmpty(id);
		Curso body = service.updateCurso(id, Curso);
		return new ResponseEntity<Curso>(body, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCurso(@PathVariable long id) {	
		
		notEmpty(id);
		service.deleteCurso(id);		
		return ResponseEntity.ok().build();
		
	}
	
    private void notEmpty(Long id){
        if (service.readById(id) == null)
            throw new ResourceNotFoundException("Curso de id " + id + " não encontrado");
    }

}
