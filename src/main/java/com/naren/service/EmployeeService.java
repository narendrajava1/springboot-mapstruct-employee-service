package com.naren.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.naren.dto.APIResponseDto;
import com.naren.dto.DepartmentDto;
import com.naren.dto.EmployeeDto;
import com.naren.entity.Employee;
import com.naren.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	 public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

	        Employee employee = new Employee(
	                employeeDto.getId(),
	                employeeDto.getFirstName(),
	                employeeDto.getLastName(),
	                employeeDto.getEmail(),
	                employeeDto.getDepartmentCode()
	        );

	        Employee saveDEmployee = employeeRepository.save(employee);

	        EmployeeDto savedEmployeeDto = new EmployeeDto(
	                saveDEmployee.getId(),
	                saveDEmployee.getFirstName(),
	                saveDEmployee.getLastName(),
	                saveDEmployee.getEmail(),
	                saveDEmployee.getDepartmentCode()
	        );

	        return savedEmployeeDto;
	    }

	    public APIResponseDto getEmployeeById(Long employeeId) {

	        Employee employee = employeeRepository.findById(employeeId).get();

//	        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//	                DepartmentDto.class);

//	        DepartmentDto departmentDto = responseEntity.getBody();
	        DepartmentDto departmentDto = new DepartmentDto();

//	        DepartmentDto departmentDto = webClient.get()
//	                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//	                .retrieve()
//	                .bodyToMono(DepartmentDto.class)
//	                .block();

	      //  DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

	        EmployeeDto employeeDto = new EmployeeDto(
	                employee.getId(),
	                employee.getFirstName(),
	                employee.getLastName(),
	                employee.getEmail(),
	                employee.getDepartmentCode()
	        );

	        APIResponseDto apiResponseDto = new APIResponseDto();
	        apiResponseDto.setEmployee(employeeDto);
	        apiResponseDto.setDepartment(departmentDto);

	        return apiResponseDto;
	    }

}
