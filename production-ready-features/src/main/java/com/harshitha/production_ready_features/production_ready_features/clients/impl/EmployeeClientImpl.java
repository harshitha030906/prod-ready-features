package com.harshitha.production_ready_features.production_ready_features.clients.impl;

import com.harshitha.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.harshitha.production_ready_features.production_ready_features.dto.EmployeeDTO;
import com.harshitha.production_ready_features.production_ready_features.exceptions.ApiResponse;
import com.harshitha.production_ready_features.production_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
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

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            ApiResponse<List<EmployeeDTO>> employeeList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeList.getData();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeByID(Long employeeID) {
        try{
            ApiResponse<EmployeeDTO> employee = restClient.get()
                    .uri("employees/" + employeeID)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});

            return employee.getData();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
        try{
            ApiResponse<EmployeeDTO> employee = restClient.post()
                                    .uri("employees")
                    .body(inputEmployee)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req, res) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {});

            return employee.getData();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
