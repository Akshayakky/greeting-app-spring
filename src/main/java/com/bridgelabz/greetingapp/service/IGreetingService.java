package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.exception.GreetingAppException;
import com.bridgelabz.greetingapp.model.Greeting;

import java.util.List;

public interface IGreetingService {
    List<Greeting> getAllGreeting();

    Greeting getGreeting(long id);

    Greeting addGreeting(UserDTO userDTO);

    Greeting updateGreeting(long id, String name) throws GreetingAppException;

    String deleteGreeting(String... name);
}
