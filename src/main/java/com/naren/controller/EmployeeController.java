package com.naren.controller;

	import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naren.dto.APIResponseDto;
import com.naren.dto.EmployeeDto;
import com.naren.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
        name = "CRUD REST APIs for Employee Resource",
        description = "CRUD REST APIs - Create Employee, Update Employee, Get Employee, Get All Employees, Delete Employee"
)

	@RestController
	@RequestMapping("api/employees")
	@AllArgsConstructor
	public class EmployeeController {

	    private EmployeeService employeeService;
	    
	    
	    @Operation(
	            summary = "Create Employee REST API",
	            description = "Create Employee REST API is used to save Employee in a database"
	    )
	    @ApiResponse(
	            responseCode = "201",
	            description = "HTTP Status 201 CREATED"
	    )
	    // Build Save Employee REST API
	    @PostMapping
	    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
	        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }

	    
	    @Operation(
	            summary = "Get Employee By ID REST API",
	            description = "Get Employee By ID REST API is used to get a single Employee from the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	    )
	    // Build Get Employee REST API
	    @GetMapping("{id}")
	    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
	        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
	        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	    }
}
