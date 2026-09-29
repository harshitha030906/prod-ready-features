package com.harshitha.production_ready_features.production_ready_features.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String description;
}
