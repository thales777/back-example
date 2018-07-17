package com.lti.facisa.RDM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.facisa.RDM.models.Subject;

@Repository
public interface DisciplinaRepository extends CrudRepository<Subject, Long> {

}
