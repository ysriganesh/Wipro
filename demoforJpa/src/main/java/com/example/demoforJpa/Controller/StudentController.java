package com.example.demoforJpa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoforJpa.entity.Student;
import com.example.demoforJpa.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentId(@PathVariable int id) {
		Student student =  studentRepository.findById(id).get();
		return student;
	}
	
	@PostMapping("/students/add")
	public void addStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
				
	}
	
	@PutMapping("/students/update/{id}")
	public Student updateStudent(@PathVariable int id)
	{
		Student student = studentRepository.findById(id).get();
		student.setName("Aneesh");
		student.setPercentage(54);
		studentRepository.save(student);
		
		return student;
	}
	
	@DeleteMapping("/students/delete/{id}")
	public void deleteStudent(@PathVariable int id)
	{
		studentRepository.deleteById(id);
	}
}
