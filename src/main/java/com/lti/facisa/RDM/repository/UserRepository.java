package com.lti.facisa.RDM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.facisa.RDM.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String user);

}
