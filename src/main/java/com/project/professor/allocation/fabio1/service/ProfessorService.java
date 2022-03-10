package com.project.professor.allocation.fabio1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.fabio1.entity.Department;
import com.project.professor.allocation.fabio1.entity.Professor;
import com.project.professor.allocation.fabio1.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;
	private final DepartmentService departmentService;

		public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
	}

	// CRUD READ all
	public List<Professor> findAll(String name) {
		if (name == null) {
			return professorRepository.findAll();
		} else {
			return professorRepository.findByNameContainingIgnoreCase(name);
		}
	}

	// CRUD READ by ID
	public Professor findById(Long id) {

		// Optional<Allocation> optional = allocationRepository.findById(id);
		// Allocation allocation = optional.orElse(null)
		// return allocation;
		return professorRepository.findById(id).orElse(null);
	}
	
	public List<Professor> findByDepartment(Long departmentId) {
		return professorRepository.findByDepartmentId(departmentId);
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
		if (id != null && professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}

	}

	// CRUD DELETE all
	public void deleteAll() {
		professorRepository.deleteAllInBatch();

	}

}
