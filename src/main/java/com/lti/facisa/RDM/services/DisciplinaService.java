package com.lti.facisa.RDM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.facisa.RDM.models.Subject;
import com.lti.facisa.RDM.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	public Subject createDisciplina(Subject disciplina) {

		return this.repository.save(disciplina);

	}

	public Subject updateDisciplina(long id, Subject disciplina) {

		disciplina.setId(id);
		return this.repository.save(disciplina);

	}

	public void deleteDisciplina(Long id) {

		this.repository.delete(id);

	}

	public List<Subject> readDisciplina() {

		return (List<Subject>) this.repository.findAll();

	}

	public Subject readById(long id) {

		return this.repository.findOne(id);

	}
}
