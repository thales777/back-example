package com.lti.facisa.RDM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.facisa.RDM.models.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

}
