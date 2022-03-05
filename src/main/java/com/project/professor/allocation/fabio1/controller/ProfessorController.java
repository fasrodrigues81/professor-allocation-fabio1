package com.project.professor.allocation.fabio1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.fabio1.service.ProfessorService;

@RestController
public class ProfessorController {

	private final ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		super();
		this.professorService = professorService;
	}

}
