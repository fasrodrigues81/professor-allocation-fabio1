package com.project.professor.allocation.fabio1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.fabio1.entity.Department;
import com.project.professor.allocation.fabio1.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	// CRUD READ all
	public List<Department> findAll(String name) {
		if (name == null) {
			return departmentRepository.findAll();
		} else {
			return departmentRepository.findByNameContainingIgnoreCase(name);
		}
	}

	// CRUD READ by ID
	public Department findById(Long id) {

		// Optional<Allocation> optional = allocationRepository.findById(id);
		// Allocation allocation = optional.orElse(null)
		// return allocation;
		return departmentRepository.findById(id).orElse(null);
	}

	// CRUD CREATE
	public Department create(Department department) {

		department.setId(null);
		Department departmentNew = departmentRepository.save(department);
		return departmentNew;
	}

	// CRUD UPDATE
	public Department update(Department department) {
		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {

			Department departmentNew = departmentRepository.save(department);
			return departmentNew;
		} else {
			return null;
		}

	}

	// CRUD DELET by ID
	public void deleteById(Long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}

	}

	// CRUD DELETE all
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();

	}

	public Department save(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

}
