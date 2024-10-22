package com.example.demoforJpa;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demoforJpa.Controller.StudentController;
import com.example.demoforJpa.entity.Student;
import com.example.demoforJpa.repo.StudentRepository;

@SpringBootTest
class DemoforJpaApplicationTests {
	
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks
	StudentController studentController;
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetAllStudents()
	{
		//Given
		List<Student> students = new ArrayList<>();
		students.add(new Student(1043,"Ganesh",76,"CSE"));
		students.add(new Student(1044,"Harish",74,"CSE"));
		when(studentRepository.findAll()).thenReturn(students);
		
		//when
		List<Student> result=studentController.getAllStudents();
		
		//Then
		assertEquals(2,result.size());
		verify(studentRepository,times(1)).findAll();
		
		
	}
	@Test
	public void testgetStudentById()
	{
		//Given
		
		Student student = new Student(1043,"Ganesh",76,"CSE");
		when(studentRepository.findById(1043)).thenReturn(Optional.of(student));
		
		//when
		Student reuslt = studentController.getStudentId(1043);
		
		//Then
		assertEquals("Ganesh", reuslt.getName());
		assertEquals(76, reuslt.getPercentage());
		
		verify(studentRepository,times(1)).findById(1043);
	}
	
	@Test
	public void testAddStudents()
	{
		//Given
		Student student = new Student(1043,"Ganesh",76,"CSE");
		
		//When
		studentController.addStudent(student);
		
		//Then
		verify(studentRepository, times(1)).save(student);
	}
	
	@Test
	public void testDeleteStudent()
	{
		//Given
		int id = 1;
		
		//When
		studentController.deleteStudent(id);
		
		//Then
		verify(studentRepository,times(1)).deleteById(id);
	}

}
