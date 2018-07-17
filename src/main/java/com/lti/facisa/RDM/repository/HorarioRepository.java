package com.lti.facisa.RDM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.facisa.RDM.models.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Long> {

}
