package com.example.demoforJpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demoforJpa.entity.Student; // Adjust the package path accordingly

// Student class that we are passing and the our primaray key is int type so Integer
public interface StudentRepository extends JpaRepository<Student , Integer> {

}
