package com.project.professor.allocation.fabio1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.fabio1.entity.Course;
import com.project.professor.allocation.fabio1.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	// CRUD READ all
	public List<Course> findAll() {

		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	// CRUD READ by ID
	public Course findById(Long id) {

		// Optional<Allocation> optional = allocationRepository.findById(id);
		// Allocation allocation = optional.orElse(null)
		// return allocation;
		return courseRepository.findById(id).orElse(null);
	}

	// CRUD CREATE
	public Course create(Course course) {

		course.setId(null);
		Course courseNew = courseRepository.save(course);
		return courseNew;
	}

	// CRUD UPDATE
	public Course update(Course course) {
		Long id = course.getId();
		if (id != null && courseRepository.existsById(id)) {

			Course courseNew = courseRepository.save(course);
			return courseNew;
		} else {
			return null;
		}

	}

	// CRUD DELET by ID
	public void deleteById(Long id) {
		if (courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
		}

	}

	// CRUD DELETE all
	public void deleteAll() {
		courseRepository.deleteAllInBatch();

	}

}
