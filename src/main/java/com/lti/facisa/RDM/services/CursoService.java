package com.lti.facisa.RDM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.facisa.RDM.models.Curso;
import com.lti.facisa.RDM.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;

	public Curso createCurso(Curso curso) {

		return this.repository.save(curso);

	}

	public Curso updateCurso(long id, Curso curso) {

		curso.setId(id);
		return this.repository.save(curso);

	}

	public void deleteCurso(Long id) {

		this.repository.delete(id);

	}

	public List<Curso> readCurso() {

		return (List<Curso>) this.repository.findAll();

	}

	public Curso readById(long id) {

		return this.repository.findOne(id);

	}

}
