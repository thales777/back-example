package com.lti.facisa.RDM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.facisa.RDM.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	

}
