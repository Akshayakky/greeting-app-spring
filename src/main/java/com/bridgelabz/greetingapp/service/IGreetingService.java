package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;

import java.util.List;

public interface IGreetingService {
    List<Greeting> getAllGreeting();

    Greeting getGreeting(long id);

    Greeting addGreeting(UserDTO userDTO);

    Greeting updateGreeting(long id, String name);

    void deleteGreeting(long id);
}
