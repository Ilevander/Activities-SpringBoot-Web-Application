package com.ilyass.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilyass.activity.models.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}    
