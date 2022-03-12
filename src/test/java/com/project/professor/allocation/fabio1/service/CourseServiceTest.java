package com.project.professor.allocation.fabio1.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.fabio1.entity.Allocation;
import com.project.professor.allocation.fabio1.entity.Course;
import com.project.professor.allocation.fabio1.service.CourseService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	 CourseService courseService;

	@Test
	public void findAll() {
		// Act
		List<Course> allocations = courseService.findAll(null);

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Arrange
		Long id = 1L;

		// Act
		Course allocation = courseService.findById(id);

		// Print
		System.out.println(allocation);
	}
	
	@Test
    public void findAllByName() {
        // Arrange
        String name = "course";

        // Act
        List<Course> courses = courseService.findAll(name);

        // Print
        courses.forEach(System.out::println);
    }

	@Test
	public void save() throws ParseException {
		// Arrange
		Course course = new Course();
        course.setId(null);
        course.setName("Course 1");

		// Act
        course = courseService.create(course);

		// Print
		System.out.println(course);
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Course course = new Course();
        course.setId(1L);
        course.setName("Course 2");

		// Act
		course = courseService.update(course);

		// Print
		System.out.println(course);
	}

	@Test
	public void deleteById() {
		// Arrange
		Long id = 1L;

		// Act
		Course course = courseService.findById(id);
		
		// Print
        System.out.println(course);
	}

	@Test
	public void deleteAll() {
		// Act
		courseService.deleteAll();
	}

}
