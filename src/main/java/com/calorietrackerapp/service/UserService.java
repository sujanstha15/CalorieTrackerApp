package com.calorietrackerapp.service;

import com.calorietrackerapp.dto.UserRequestDTO;
import com.calorietrackerapp.dto.UserResponseDTO;
import com.calorietrackerapp.entity.User;
import com.calorietrackerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    //to register new user
    public UserResponseDTO registerUser(UserRequestDTO request){
        //convert DTO to entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        //saving to DB
        User savedUser = userRepository.save(user);

        //convert Entity to ResponseDTO
        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
