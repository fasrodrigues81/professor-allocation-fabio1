package com.project.professor.allocation.fabio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.fabio1.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
}
		

