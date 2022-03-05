package com.project.professor.allocation.fabio1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.fabio1.entity.Professor;
import com.project.professor.allocation.fabio1.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}

	// CRUD READ all
	public List<Professor> findAll() {

		List<Professor> professor = professorRepository.findAll();
		return professor;
	}

	// CRUD READ by ID
	public Professor findById(Long id) {

		// Optional<Allocation> optional = allocationRepository.findById(id);
		// Allocation allocation = optional.orElse(null)
		// return allocation;
		return professorRepository.findById(id).orElse(null);
	}

	// CRUD CREATE
	public Professor create(Professor professor) {

		professor.setId(null);
		Professor professorNew = professorRepository.save(professor);
		return professorNew;
	}

	// CRUD UPDATE
	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {

			Professor professorNew = professorRepository.save(professor);
			return professorNew;
		} else {
			return null;
		}

	}

	// CRUD DELET by ID
	public void deleteById(Long id) {
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}

	}

	// CRUD DELETE all
	public void deleteAll() {
		professorRepository.deleteAllInBatch();

	}

}
