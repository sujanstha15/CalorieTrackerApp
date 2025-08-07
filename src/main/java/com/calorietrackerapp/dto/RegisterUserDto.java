package com.calorietrackerapp.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String name;
    private String email;
    private String password;
    private int age;
    private double height;
    private double weight;
    private String gender;
    private String activityLevel;
    private String goal;
}
