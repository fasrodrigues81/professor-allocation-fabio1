package com.project.professor.allocation.fabio1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.fabio1.entity.Course;
import com.project.professor.allocation.fabio1.service.CourseService;

@RestController
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	// GET http://localhost:8080/departments
	public ResponseEntity<List<Course>> findAll() {
		List<Course> courses = courseService.findAll();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/courses/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> finsById(@PathVariable(name = "course_id") Long id) {
		Course course = courseService.findById(id);

		if (course != null) {
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			// return null;
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@ResponseStatus(HttpStatus.CREATED)
	// READ, CREAT, UPDATE, DELETE
	// GET , POST , PUT , DELETE
	@PostMapping(path = "/courses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> create(@RequestBody Course course) {
		try {
			Course newCourse = courseService.create(course);
			return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path = "/courses/{course_id}")
	public ResponseEntity<Course> update(Course course) 
	{
		try 
		{
			Course newCourse = courseService.update(course);
			if (newCourse != null) 
			{
				return new ResponseEntity<>(newCourse,HttpStatus.OK);
			}
			else 
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
