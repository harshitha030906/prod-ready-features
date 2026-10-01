package com.harshitha.production_ready_features.production_ready_features.clients;

import com.harshitha.production_ready_features.production_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeByID(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employee);
}
