package com.krishna.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krishna.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsById(int primaryKey);

	public List<Employee> findByName(String name);

	public List<Employee> findByStatus(String status);

	public List<Employee> findByIdAndName(int id, String name);

	public List<Employee> findByIdOrName(int id, String name);

	public List<Employee> findByNameAndStatus(String name, String status);

	public List<Employee> findByNameStartingWith(String start);

	public List<Employee> findByNameEndingWith(String end);

	// Native query
	@Query(value = "select e from employee e", nativeQuery = true)
	public List<Employee> getAllEmployees();

	// JPQL
	@Query(value = "from Employee where name=:name or status=:status")
	public List<Employee> getAllEmployees(@Param("name") String name, @Param("status") String status);

	@Modifying
	@Transactional
	@Query("Update Employee set status=:status where id=:id")
	public int updateEmployee(@Param("status") String status, @Param("id") int id);

	@Modifying
	@Transactional
	@Query("Delete Employee where id=:id")
	public int deleteEmployee(@Param("id") int id);

}
