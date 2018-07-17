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
import com.lti.facisa.RDM.models.Student;
import com.lti.facisa.RDM.services.StudentService;


@Controller
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	public StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAll(){
		
		List<Student> body = service.readStudent();
		return new ResponseEntity<List<Student>>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable Long id){
		
		notEmpty(id);
		Student student = service.readById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<Student> postStudent(@RequestBody Student student){
		
		Student body = service.createStudent(student);
		return new ResponseEntity<Student>(body, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> putStudent(@PathVariable Long id,@RequestBody Student student){
		
		notEmpty(id);
		Student body = service.updateStudent(id, student);
		return new ResponseEntity<Student>(body, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable long id) {	
		
		notEmpty(id);
		service.deleteStudent(id);	
		return ResponseEntity.ok().build();
		
	}

    private void notEmpty(Long id){
        if (service.readById(id) == null)
            throw new ResourceNotFoundException("Student de id " + id + " não encontrado");
    }
}
