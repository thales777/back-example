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
import com.lti.facisa.RDM.models.Horario;
import com.lti.facisa.RDM.services.HorarioService;

@Controller
@RequestMapping("api/horario")
public class HorarioController {
	
	@Autowired
	public HorarioService service;
	
	@GetMapping
	public ResponseEntity<List<Horario>> getAll(){
		
		List<Horario> body = service.readHorario();
		return new ResponseEntity<List<Horario>>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Horario> getById(@PathVariable Long id){
		
		notEmpty(id);
		Horario horario = service.readById(id);
		return new ResponseEntity<Horario>(horario, HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<Horario> postHorario(@RequestBody Horario Horario){
		
		Horario body = service.createHorario(Horario);
		return new ResponseEntity<Horario>(body, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Horario> putHorario(@PathVariable Long id,@RequestBody Horario Horario){
		
		notEmpty(id);
		Horario body = service.updateHorario(id, Horario);
		return new ResponseEntity<Horario>(body, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteHorario(@PathVariable long id) {	
		
		notEmpty(id);
		service.deleteHorario(id);	
		return ResponseEntity.ok().build();
		
	}
	
    private void notEmpty(Long id){
        if (service.readById(id) == null)
            throw new ResourceNotFoundException("Horario de id " + id + " não encontrado");
    }

}
