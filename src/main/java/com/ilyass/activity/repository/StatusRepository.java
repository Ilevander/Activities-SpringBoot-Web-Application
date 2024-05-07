package com.ilyass.activity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilyass.activity.models.Status;
import com.ilyass.activity.models.Student;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
	Optional<Status> findByStudent(Student student);
}
