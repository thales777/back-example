package com.lti.facisa.RDM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.facisa.RDM.models.Horario;
import com.lti.facisa.RDM.repository.HorarioRepository;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioRepository repository;

	public Horario createHorario(Horario horario) {

		return this.repository.save(horario);

	}

	public Horario updateHorario(long id, Horario horario) {

		horario.setId(id);
		return this.repository.save(horario);

	}

	public void deleteHorario(Long id) {

		this.repository.delete(id);

	}

	public List<Horario> readHorario() {

		return (List<Horario>) this.repository.findAll();

	}

	public Horario readById(long id) {

		return this.repository.findOne(id);

	}


}
