package com.lti.facisa.RDM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.facisa.RDM.models.Student;
import com.lti.facisa.RDM.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public Student createStudent(Student student) {

		return this.repository.save(student);

	}

	public Student updateStudent(long id, Student student) {

		student.setId(id);
		return this.repository.save(student);

	}

	public void deleteStudent(Long id) {

		this.repository.delete(id);
	}

	public List<Student> readStudent() {

		return (List<Student>) this.repository.findAll();

	}

	public Student readById(long id) {

		return this.repository.findOne(id);

	}

}
