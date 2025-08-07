package com.calorietrackerapp.service;


import com.calorietrackerapp.dto.RegisterUserDto;
import com.calorietrackerapp.entity.User;
import com.calorietrackerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CalorieCalculatorService calorieCalculatorService;

    public User register(RegisterUserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAge(dto.getAge());
        user.setHeight(dto.getHeight());
        user.setWeight(dto.getWeight());
        user.setGender(dto.getGender());
        user.setActivityLevel(dto.getActivityLevel());
        user.setGoal(dto.getGoal());

        double calories = calorieCalculatorService.calculateCalories(user);

        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
