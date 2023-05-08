package com.krishna.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishna.demo.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
