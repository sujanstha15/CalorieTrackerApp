package com.calorietrackerapp.controller;

import com.calorietrackerapp.dto.LoginRequestDto;
import com.calorietrackerapp.dto.RegisterUserDto;
import com.calorietrackerapp.entity.User;
import com.calorietrackerapp.service.CalorieCalculatorService;
import com.calorietrackerapp.service.UserService;
import com.calorietrackerapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CalorieCalculatorService calorieCalculatorService;

    @Autowired
    private JwtUtil jwtUtil;

    //api to create a new user
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto dto){
        User user = userService.register(dto);
        return ResponseEntity.ok(user);
    }

    //getting the user
    @GetMapping("/{id}/calories")
    public ResponseEntity<Double> getCalories(@PathVariable Long id){
        Optional<User> userOpt = userService.findById(id);
        if(userOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        double calories = calorieCalculatorService.calculateCalories(userOpt.get());
        return ResponseEntity.ok(calories);
    }
    //login API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto){

        Optional<User> userOpt = userService.findByEmail(dto.getEmail());

        if(userOpt.isEmpty() || !userOpt.get().getPassword().equals(dto.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password or email");
        }
        String token = jwtUtil.generateToken(dto.getEmail());
        return ResponseEntity.ok().body(token);

    }


}
