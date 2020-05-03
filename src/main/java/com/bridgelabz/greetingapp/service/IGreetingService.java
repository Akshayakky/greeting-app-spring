package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;

import java.util.List;

public interface IGreetingService {
    List<Greeting> getAllGreeting();

    Greeting getGreeting(Long... id);

    Greeting addGreeting(UserDTO userDTO);

    String updateGreeting(String... name);

    String deleteGreeting(String... name);
}
