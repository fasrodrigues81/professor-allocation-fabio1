package com.project.professor.allocation.fabio1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.fabio1.service.DepartmentService;

@RestController
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

}
