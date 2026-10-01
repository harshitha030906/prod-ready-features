package com.harshitha.production_ready_features.production_ready_features;

import com.harshitha.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.harshitha.production_ready_features.production_ready_features.dto.EmployeeDTO;
import jakarta.persistence.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootTest
class ProductionReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;
    @Autowired
    private RestClient restClient;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetEmployees(){
        List<EmployeeDTO> employeeList = employeeClient.getAllEmployees();
		System.out.println(employeeList);
	}

	@Test
	void TestGetEmployeeById(){
		EmployeeDTO employee = employeeClient.getEmployeeByID(52L);
		System.out.println(employee);
	}

	@Test
	void TestCreateNewEmployee(){
		EmployeeDTO employeeDTO = EmployeeDTO.builder()
				.firstName("Roshini")
				.lastName("Dumpa")
				.email("roshinidumpa@gmail.com")
				.age(21)
				.role("USER")
				.salary(25000D)
				.build();

		EmployeeDTO post = employeeClient.createEmployee(employeeDTO);
		System.out.println(post);
	}

}
