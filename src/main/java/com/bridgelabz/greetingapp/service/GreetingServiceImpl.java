package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService {

    @Override
    public String getGreeting(String... name) {
        String greeting = "Hello";
        greeting += (name.length > 0) ? " " + name[0] : "";
        greeting += (name.length > 1) ? " " + name[1] : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }

    @Override
    public String addGreeting(UserDTO userDTO) {
        String greeting = "Hello";
        greeting += (userDTO.getFirstName() != null) ? " " + userDTO.getFirstName() : "";
        greeting += (userDTO.getLastName() != null) ? " " + userDTO.getLastName() : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }

    @Override
    public String updateGreeting(String... name) {
        String greeting = "Hello";
        greeting += (name.length > 0) ? " " + name[0] : "";
        greeting += (name.length > 1) ? " " + name[1] : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }

    @Override
    public String deleteGreeting(String... name) {
        String greeting = "Hello";
        greeting += (name.length > 0) ? " " + name[0] : "";
        greeting += (name.length > 1) ? " " + name[1] : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }
}
