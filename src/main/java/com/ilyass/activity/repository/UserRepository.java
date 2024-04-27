package com.ilyass.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilyass.activity.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
