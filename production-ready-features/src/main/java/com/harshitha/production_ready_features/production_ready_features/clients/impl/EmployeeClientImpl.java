package com.harshitha.production_ready_features.production_ready_features.clients.impl;

import com.harshitha.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.harshitha.production_ready_features.production_ready_features.dto.EmployeeDTO;
import com.harshitha.production_ready_features.production_ready_features.exceptions.ApiResponse;
import com.harshitha.production_ready_features.production_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        /*log.error("error log");
        log.info("info log");
        log.warn("warn log");
        log.debug("debug log");
        log.trace("trace log");*/
        log.trace("getAllEmployees()");
        try {
            log.info("Attempting to get all employees");
            ApiResponse<List<EmployeeDTO>> employeeList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved all the employees");
            log.trace("Retrieved employee list : {}", employeeList.getData());
            return employeeList.getData();
        }catch(Exception e){
            log.error("Exception occurred in getAllEmployees()",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeByID(Long employeeID) {
        log.trace("getEmployeeByID()");
        try{
            log.info("Attempting to get the employee by id: {}", employeeID);
            ApiResponse<EmployeeDTO> employee = restClient.get()
                    .uri("employees/" + employeeID)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});
            log.debug("Successfully retrieved the employee by id: {}", employeeID);
            log.trace("Retrieved the employee by id: {}", employee.getData());
            return employee.getData();
        }catch(Exception e){
            log.error("Exception occurred in getEmployeeByID()",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
        log.trace("createEmployee()");
        try{
            log.info("Attempting to create a new employee: {}", inputEmployee);
            ApiResponse<EmployeeDTO> employee = restClient.post()
                                    .uri("employees")
                    .body(inputEmployee)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req, res) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {});
            log.debug("Successfully created the employee");
            log.trace("Created employee in createEmployee() : {}", employee.getData());
            return employee.getData();
        }catch(Exception e){
            log.error("Exception occurred in createEmployee()", e);
            throw new RuntimeException(e);
        }
    }
}
