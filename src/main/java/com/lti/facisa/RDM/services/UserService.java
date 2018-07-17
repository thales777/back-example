package com.lti.facisa.RDM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.facisa.RDM.models.User;
import com.lti.facisa.RDM.repository.UserRepository;

@Service
public class UserService {
	

	@Autowired
	private UserRepository repository;
	
	public User createUser(User user) {
		
		return this.repository.save(user);
		
	}
	
	public User updateUser(long id,User user) {
		
		user.setId(id);
		return this.repository.save(user);
		
	}
	
	public void deleteUser(Long id) {
		
		this.repository.delete(id);
		
	}
	
	public List<User> readUser(){
		
		return (List<User>) this.repository.findAll();
	
	}
	
	public User readById(long id) {
		
		return this.repository.findOne(id);
		
	}

}
