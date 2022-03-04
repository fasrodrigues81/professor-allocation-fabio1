package com.project.professor.allocation.fabio1.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.fabio1.entity.Allocation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationRepository allocationRepository;

	@SuppressWarnings("unused")
	@Test
	public void findAll() {
		// Act
		List<Allocation> allocations = allocationRepository.findAll();

		// Print
		System.out.println();
	}

	@Test
	public void findById() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void findByProfessorId() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void findByCourseId() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setDay(DayOfWeek.MONDAY);
		allocation.setCourseId(1L);
		allocation.setProfessorId(1L);
		allocation.setStart(sdf.parse("10:00-0300"));
		allocation.setEnd(sdf.parse("11:00-0300"));

		// Act
		Allocation alooc = allocationRepository.save(allocation);

		// Print
		System.out.println(alooc);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void deleteById() {
		// Arrange

		// Act

	}

	@Test
	public void deleteAll() {
		// Act

	}
}
