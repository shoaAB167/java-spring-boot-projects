package com.s_project_hibernate.repository;

import com.s_project_hibernate.model.Users;

import com.s_project_hibernate.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByName(String name);

}