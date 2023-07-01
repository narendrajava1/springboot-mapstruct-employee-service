package com.naren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Narendra Kumar Kolli",
						email = "kolli7571@gmail.com",
						url = "https://www.youtube.com/channel/UC4n7bQO6KahGdxJ-jXv25bg"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.youtube.com/channel/UC4n7bQO6KahGdxJ-jXv25bg"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url = "https://www.youtube.com/channel/UC4n7bQO6KahGdxJ-jXv25bg"
		)
)
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
