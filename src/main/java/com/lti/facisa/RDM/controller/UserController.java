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
import com.lti.facisa.RDM.models.User;
import com.lti.facisa.RDM.services.UserService;

@Controller
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	public UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		
		List<User> body = service.readUser();
		return new ResponseEntity<List<User>>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		
		notEmpty(id);
		User User = service.readById(id);
		return new ResponseEntity<User>(User, HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<User> postUser(@RequestBody User User){
		
		User body = service.createUser(User);
		return new ResponseEntity<User>(body, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User User ){
		
		notEmpty(id);
		User body = service.updateUser(id, User);
		return new ResponseEntity<User>(body, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {	
		
		notEmpty(id);
		service.deleteUser(id);
		return ResponseEntity.ok().build();
		
	}	
	
    private void notEmpty(Long id){
        if (service.readById(id) == null)
            throw new ResourceNotFoundException("User de id " + id + " não encontrado");
    }
}
