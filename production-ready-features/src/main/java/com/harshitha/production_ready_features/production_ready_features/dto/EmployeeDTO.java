package com.harshitha.production_ready_features.production_ready_features.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDTO {

    private Long employeeID;

    private String firstName;

    private String lastName;

    private String email;

    private Double salary;

    private Integer age;

    private String role;

}
