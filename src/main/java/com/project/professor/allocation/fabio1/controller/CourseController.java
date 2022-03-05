package com.project.professor.allocation.fabio1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.fabio1.service.CourseService;

@RestController
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

}
