package com.project.professor.allocation.fabio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.fabio1.entity.Allocation;
import com.project.professor.allocation.fabio1.entity.Course;
import com.project.professor.allocation.fabio1.entity.Professor;
import com.project.professor.allocation.fabio1.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;
	private final ProfessorService professorService;
	private final CourseService courseService;

	public AllocationService(AllocationRepository allocationRepository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorService = professorService;
		this.courseService = courseService;
	}

	// CRUD READ all
	public List<Allocation> findAll() {

		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;
	}

	// CRUD READ by ID
	public Allocation findById(Long id) {
		Optional<Allocation> optional = allocationRepository.findById(id);
		Allocation allocation = optional.orElse(null);
		return allocationRepository.findById(id).orElse(null);
	}

	public List<Allocation> findByProfessor(Long professorId) {
		return allocationRepository.findByProfessorId(professorId);
	}

	public List<Allocation> findByCourse(Long courseId) {
		return allocationRepository.findByCourseId(courseId);
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
	
	private Allocation saveInternal(Allocation allocation) {
		if (hasCollision(allocation)) {
			throw new RuntimeException("hasCollision");
		} else {
			Allocation allocationNew = allocationRepository.save(allocation);

			Professor professor = professorService.findById(allocationNew.getProfessorId());
			Course course = courseService.findById(allocationNew.getCourseId());

			allocationNew.setProf(professor);
			allocationNew.setCour(course);

			return allocationNew;
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
		
		// Regra de Neg??cio
		boolean hasCollision(Allocation newAllocation) {
			boolean hasCollision = false;

			List<Allocation> currentAllocations = allocationRepository.findByProfessorId(newAllocation.getProfessorId());

			for (Allocation currentAllocation : currentAllocations) {
				hasCollision = hasCollision(currentAllocation, newAllocation);
				if (hasCollision) {
					break;
				}
			}

			return hasCollision;
		}

		private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
			return !currentAllocation.getId().equals(newAllocation.getId())
					&& currentAllocation.getDay() == newAllocation.getDay()
					&& currentAllocation.getStart().compareTo(newAllocation.getEnd()) < 0
					&& newAllocation.getStart().compareTo(currentAllocation.getEnd()) < 0;
		}
	}
