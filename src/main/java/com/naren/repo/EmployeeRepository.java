package com.naren.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naren.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
