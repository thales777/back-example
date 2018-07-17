package com.lti.facisa.RDM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.facisa.RDM.models.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}
