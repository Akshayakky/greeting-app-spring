package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;

public interface IGreetingService {
    String getGreeting(String... name);

    String addGreeting(UserDTO userDTO);

    String updateGreeting(String... name);

    String deleteGreeting(String... name);
}
