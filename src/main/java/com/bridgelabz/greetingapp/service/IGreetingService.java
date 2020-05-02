package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;

public interface IGreetingService {
    String getGreeting(String... name);

    Greeting addGreeting(UserDTO userDTO);

    String updateGreeting(String... name);

    String deleteGreeting(String... name);
}
