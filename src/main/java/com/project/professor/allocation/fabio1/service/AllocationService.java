package com.project.professor.allocation.fabio1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.fabio1.entity.Allocation;
import com.project.professor.allocation.fabio1.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}

	// CRUD READ all
	public List<Allocation> findAll() {

		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;
	}

	// CRUD READ by ID
	public Allocation findById(Long id) {

		// Optional<Allocation> optional = allocationRepository.findById(id);
		// Allocation allocation = optional.orElse(null)
		// return allocation;
		return allocationRepository.findById(id).orElse(null);
	}

	// CRUD CREATE
	public Allocation create(Allocation allocation) {

		allocation.setId(null);
		Allocation allocationNew = allocationRepository.save(allocation);
		return allocationNew;
	}

	// CRUD UPDATE
	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id)) {

			Allocation allocationNew = allocationRepository.save(allocation);
			return allocationNew;
		} else {
			return null;
		}

	}

	// CRUD DELET by ID
	public void deleteById(Long id) {
		if (allocationRepository.existsById(id)) {
			allocationRepository.deleteById(id);
		}

	}

	// CRUD DELETE all
	public void deleteAll() {
		allocationRepository.deleteAllInBatch();
	}

}
