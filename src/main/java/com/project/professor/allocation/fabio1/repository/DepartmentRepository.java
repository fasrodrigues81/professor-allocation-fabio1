package com.project.professor.allocation.fabio1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.fabio1.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	List<Department> findByNameContainingIgnoreCase(String name);

}
