package com.project.professor.allocation.fabio1.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.fabio1.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findAll() {
        // Act
    	List<Course> courses = courseRepository.findAll();

        // Print
    	courses.forEach(System.out::println);
    }

    @Test
    public void findById() {
        // Arrange
    	Long id = 1L;

        // Act
    	Course course = courseRepository.findById(id).orElse(null);

        // Print
    	System.out.println(course);
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
    	Course course = new Course();
        course.setId(null);
        course.setName("Course 1");

        // Act
        course = courseRepository.save(course);

        // Print
        System.out.println(course);
        
    }

    @Test
    public void save_update() throws ParseException {
        // Arrange
    	Course course = new Course();
        course.setId(1L);
        course.setName("Course 2");

        // Act
        course = courseRepository.save(course);

        // Print
        System.out.println(course);
    }

    @Test
    public void deleteById() {
        // Arrange
    	Long id = 1L;

        // Act
    	courseRepository.deleteById(id); 
    }

    @Test
    public void deleteAll() {
        // Act
    	 courseRepository.deleteAllInBatch(); 
    }
}

