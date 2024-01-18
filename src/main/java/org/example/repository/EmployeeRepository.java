package org.example.repository;

import org.example.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//The Long in JpaRepository<Employee, Long>
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

