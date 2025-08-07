package com.calorietrackerapp.service;

import com.calorietrackerapp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CalorieCalculatorService {

    public double calculateCalories(User user){
        double bmr;
        if("male".equalsIgnoreCase(user.getGender())){
            bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge() + 5;;
        }
        else{
            bmr =  10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge() - 161;
        }

        double activityFactor = getActivityFactor(user.getActivityLevel());
        double maintenanceCalories = bmr * activityFactor;

        switch(user.getGoal().toLowerCase()){
            case "gain":
                return maintenanceCalories +500;

            case "lose":
                return maintenanceCalories-500;

            default:
                return maintenanceCalories;
        }

    }

    private double getActivityFactor(String activityLevel){
        switch(activityLevel.toLowerCase()){
            case "sedentary":
                return 1.2;

            case "lightly active":
                return 1.375;
            case "moderately active":
                return 1.55;
            case "very active":
                return 1.725;
            case "extra active":
                return 1.9;
            default:
                return 1.2;
        }
    }
}
