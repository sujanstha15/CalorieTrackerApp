package com.calorietrackerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//sending back these data to user, not directly from entity
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
}
